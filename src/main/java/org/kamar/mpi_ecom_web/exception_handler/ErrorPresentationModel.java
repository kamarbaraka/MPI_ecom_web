package org.kamar.mpi_ecom_web.exception_handler;


import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * The ErrorPresentationModel class represents the presentation model for error responses. It encapsulates
 * the error code, error message, status code, URL, and request method of an error response.
 *
 * @author kamar baraka.
 */
@Data
@Component
public class ErrorPresentationModel {

    private String errorCode;

    private String errorMessage = "Unable to process your request, please contact support!";

    private int statusCode;

    private String url = "Not available!";

    private String requestMethod = "Not available!";
}
