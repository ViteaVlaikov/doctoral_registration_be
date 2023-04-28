package usm.api.doctoral_registration.exception.entity;

import static usm.api.doctoral_registration.exception.CodeException.SCIENCE_BRANCH_NOT_FOUND;

public class ScienceBranchNotFoundException extends EntityNotFoundException {
    public ScienceBranchNotFoundException(Number id) {
        super("ScienceBranch", id, SCIENCE_BRANCH_NOT_FOUND   );
    }
}
