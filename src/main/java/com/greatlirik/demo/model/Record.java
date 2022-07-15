package com.greatlirik.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Record entity
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
@Entity
@Table(name = "record")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Accessors(chain = true)
public class Record {

    /**
     * Field id
     */
    @Id
    @SequenceGenerator(name = "recordIdSeq", sequenceName = "records_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recordIdSeq")
    @Column(name = "id")
    private Long id;

    /**
     * Field userId
     */
    @Column(name = "account_id")
    private Long userId;

    /**
     * Field coinName
     */
    @Column(name = "coin_name", nullable = false)
    private String coinName;

    /**
     * Field localDateTime
     */
    @Column(name = "cur_time", nullable = false)
    private LocalDateTime localDateTime;

    /**
     * Field value
     */
    @Column(name = "price_usd", nullable = false)
    private BigDecimal price_usd;

}
