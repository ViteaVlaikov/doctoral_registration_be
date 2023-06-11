package usm.api.doctoral_registration.exception.entity;

import static usm.api.doctoral_registration.exception.CodeException.COUNTRY_NOT_FOUND_EXCEPTION;

public class CountryNotFoundException extends EntityNotFoundException {
    public CountryNotFoundException(Number id) {
        super("Country", id, COUNTRY_NOT_FOUND_EXCEPTION);
    }
}
