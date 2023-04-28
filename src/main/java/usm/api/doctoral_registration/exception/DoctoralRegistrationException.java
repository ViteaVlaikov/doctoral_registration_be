package usm.api.doctoral_registration.exception;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class DoctoralRegistrationException extends RuntimeException {

    public DoctoralRegistrationException(String message, CodeException code) {
        super();
        this.time = LocalDateTime.now();
        this.message = message;
        this.code = code;
    }

    private final LocalDateTime time;

    private final String message;

    private final CodeException code;

}
