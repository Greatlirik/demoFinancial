package com.greatlirik.demo.service.impl;

import com.greatlirik.demo.exception.ResourceNotFoundException;
import com.greatlirik.demo.model.Coin;
import com.greatlirik.demo.repository.CoinRepository;
import com.greatlirik.demo.service.CoinService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Coin service implementation
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class CoinServiceImpl implements CoinService {

    private final CoinRepository coinRepository;

    @Override
    public List<Coin> findAll() {
        final List<Coin> result = (List<Coin>) coinRepository.findAll();

        log.info("In getAll - {} coins found", result.size());
        return result;
    }

    @Override
    public Coin findByID(final Long id) {
        final Coin coin = coinRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found coin with id " + id));
        log.info("In findById - coin: {} found by id: {}", coin, id);
        return coin;
    }

    @Override
    public Coin updateCoinPrice(final Long id, final BigDecimal price_usd) {
        final Coin coin = coinRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found coin with id " + id));
        coin.setPrice_usd(price_usd);
        coinRepository.save(coin);
        log.info("In update price - coin with id: {} successfully updated", id);
        return coin;
    }
}
