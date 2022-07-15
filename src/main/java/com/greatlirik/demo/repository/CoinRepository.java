package com.greatlirik.demo.repository;

import com.greatlirik.demo.model.Coin;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CoinRepository extends PagingAndSortingRepository<Coin, Long> {
}
