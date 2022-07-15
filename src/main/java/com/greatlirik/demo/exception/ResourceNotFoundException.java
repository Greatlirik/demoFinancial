package com.greatlirik.demo.exception;

import java.io.Serial;

/**
 * Custom ResourceNotFoundException
 *
 * @author Zhuk Kirill
 * @version 1.0
 */
public class ResourceNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -517201472968363182L;

    /**
     * Constructor with parameter message
     *
     * @param message
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
