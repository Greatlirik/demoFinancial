package com.greatlirik.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

/**
 * Error message
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
@Getter
@AllArgsConstructor
public class ErrorMessage {

    /**
     * Field timestamp
     */
    private final Date timestamp;

    /**
     * Field message
     */
    private final String message;

    /**
     * Field description
     */
    private final String description;
}
