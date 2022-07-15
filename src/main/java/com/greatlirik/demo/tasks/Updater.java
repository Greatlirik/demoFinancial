package com.greatlirik.demo.tasks;

import com.greatlirik.demo.model.Coin;
import com.greatlirik.demo.model.Record;
import com.greatlirik.demo.service.CoinService;
import com.greatlirik.demo.service.RecordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;

/**
 * Class for update coin price
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
@RequiredArgsConstructor
@Component
@Slf4j
public class Updater {

    private final CoinService coinService;
    private final RecordService recordService;

    @Transactional
    @Scheduled(cron = "0 * * * * *")
    public void updateCoinValue() {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "https://api.coinlore.net/api/ticker/?id=90,80,48543";
        List<Coin> coins = restTemplate.exchange(
                resourceUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Coin>>() {
                }
        ).getBody();
        for (Coin coin : coins
        ) {
            coinService.updateCoinPrice(coin.getId(), coin.getPrice_usd());
            checkRecords(coin.getSymbol(), coin.getPrice_usd());
        }
    }

    private void checkRecords(final String symbol, final BigDecimal currentPrice) {
        final double givenPercentage = 0.01;
        final List<Record> records = recordService.findAll();
        for (Record record : records
        ) {
            if (record.getCoinName().equals(symbol) &&
                    Math.abs(record.getPrice_usd().doubleValue() - currentPrice.doubleValue())
                            / currentPrice.doubleValue() > givenPercentage) {
                final Long userId = record.getUserId();
                log.warn(" user with Id: {} has changed symbol: {}", userId, symbol);
            }
        }
    }

}
