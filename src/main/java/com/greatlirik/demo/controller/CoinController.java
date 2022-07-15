package com.greatlirik.demo.controller;

import com.greatlirik.demo.model.Coin;
import com.greatlirik.demo.service.CoinService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * CoinRESTController
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/coins")
@Tag(name = "Coin Controller", description = "Allows to perform CRUD operations on the coin")
public class CoinController {

    /**
     * Autowired field coinService
     */
    private final CoinService coinService;

    /**
     * Find all coins
     *
     * @return List<Coin>
     */
    @Operation(
            summary = "Find all coins"
    )
    @GetMapping
    public List<Coin> findAllCoins() {
        return coinService.findAll();
    }

    /**
     * Find coin with given id
     *
     * @param id
     * @return Coin
     */
    @Operation(
            summary = "Find coin by id"
    )
    @GetMapping("{id}")
    public Coin getCoin(final @PathVariable("id") Long id) {
        return coinService.findByID(id);
    }

}
