package usm.api.doctoral_registration.hendler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import usm.api.doctoral_registration.exception.DoctoralRegistrationException;

import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class CustomExceptionHandler {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy hh:mm:ss a");
    @ExceptionHandler(DoctoralRegistrationException.class)
    public ResponseEntity<ErrorResponse> handleStudentNotFoundException(DoctoralRegistrationException ex) {
        ErrorResponse errorResponse = ErrorResponse
                .builder(ex, HttpStatus.BAD_REQUEST, ex.getMessage())
                .detailMessageCode(ex.getCode().toString())
                .titleMessageCode(ex.toString())
                .detailMessageArguments(ex.getTime().format(formatter))
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
