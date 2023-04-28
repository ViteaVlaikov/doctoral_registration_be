package usm.api.doctoral_registration.exception.entity;

import static usm.api.doctoral_registration.exception.CodeException.SCIENCE_DOMAIN_NOT_FOUND;

public class ScienceDomainNotFoundException extends EntityNotFoundException {
    public ScienceDomainNotFoundException(Number id) {
        super("ScienceDomain", id, SCIENCE_DOMAIN_NOT_FOUND);
    }

    @Override
    public String toString() {
        return "ScienceDomainNotFoundException";
    }
}
