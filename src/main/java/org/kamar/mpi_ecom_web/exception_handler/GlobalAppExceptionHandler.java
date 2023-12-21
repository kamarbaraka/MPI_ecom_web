package org.kamar.mpi_ecom_web.exception_handler;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.kamar.mpi_ecom_web.item.exception.CartItemException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * The GlobalAppExceptionHandler class handles global exceptions in the application and provides appropriate error responses.
 *
 * @author kamar baraka.
 */
@RestControllerAdvice
@RequiredArgsConstructor
@Log4j2
public class GlobalAppExceptionHandler {

    private final HttpServletRequest request;
    private final ErrorPresentationModel errorModel;

    /**
     * Handles the exception {@link CartItemException} and returns an HTTP response entity with the appropriate error model.
     *
     * @return the ResponseEntity with the error model
     */
    @ExceptionHandler(CartItemException.class)
    public ResponseEntity<ErrorPresentationModel> handleCartItemException(CartItemException exception){

        /*log the exception*/
        log.error(exception.getMessage());

        /*create the model*/
        errorModel.setErrorCode(ErrorCode.CART_ITEM_ERROR_CODE.getErrorCode());
        errorModel.setUrl(request.getRequestURI());
        errorModel.setRequestMethod(request.getMethod());
        errorModel.setStatusCode(HttpStatus.BAD_REQUEST.value());

        return ResponseEntity.badRequest().body(errorModel);
    }
}
