package usm.api.doctoral_registration.exception.request;

import usm.api.doctoral_registration.exception.DoctoralRegistrationException;

import static usm.api.doctoral_registration.exception.CodeException.UPPER_CRITERIA_NOT_FOUND;

public class UpperCriteriaNotFoundException extends DoctoralRegistrationException {
    public UpperCriteriaNotFoundException() {
        super("Request doesn't contains any upper criteria like: science_id, profile_id, branch_id, domain_id," +
                "school_id", UPPER_CRITERIA_NOT_FOUND);
    }
}
