package com.greatlirik.demo.service;

import com.greatlirik.demo.model.Coin;

import java.math.BigDecimal;
import java.util.List;

/**
 * CRUD and simple logic operations on Coin
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
public interface CoinService {

    /**
     * Get all coins
     *
     * @return list with all coins
     */
    List<Coin> findAll();

    /**
     * find coin with given id
     *
     * @param id
     * @return coin
     */
    Coin findByID(Long id);

    /**
     * update coin price
     *
     * @param id
     * @param price_usd
     * @return coin
     */
    Coin updateCoinPrice(Long id, BigDecimal price_usd);
}
