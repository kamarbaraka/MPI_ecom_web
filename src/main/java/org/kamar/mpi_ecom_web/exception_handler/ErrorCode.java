package org.kamar.mpi_ecom_web.exception_handler;


import lombok.Getter;

/**
 * The ErrorCode class represents the error code for different error scenarios in the application.
 *
 * @author kamar baraka.
 */
@Getter
public enum ErrorCode {

    CART_ITEM_ERROR_CODE("0001");

    private final String errorCode;

    ErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
