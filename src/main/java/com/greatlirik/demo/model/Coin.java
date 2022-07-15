package com.greatlirik.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Coin entity
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
@Entity
@Table(name = "coin")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Accessors(chain = true)
public class Coin {

    /**
     * Field id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Field name
     */
    @Column(name = "name", nullable = false)
    private String symbol;

    /**
     * Field value
     */
    @Column(name = "value", nullable = false)
    private BigDecimal price_usd;

}
