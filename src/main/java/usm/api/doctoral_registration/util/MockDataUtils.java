package usm.api.doctoral_registration.util;

import usm.api.doctoral_registration.model.science.ScienceBranch;
import usm.api.doctoral_registration.model.science.ScienceDomain;
import usm.api.doctoral_registration.model.science.ScienceProfile;
import usm.api.doctoral_registration.model.science.ScienceSchool;

import java.util.Collections;
import java.util.List;

public class MockDataUtils {
    public static final ScienceSchool SCIENCE_SCHOOL_1 = ScienceSchool.builder()
            .id(1)
            .name("SCIENCE_SCHOOL_1")
            .build();
    public static final ScienceDomain SCIENCE_DOMAIN_1 = ScienceDomain.builder()
            .id(1)
            .name("SCIENCE_DOMAIN_1")
            .scienceSchool(SCIENCE_SCHOOL_1)
            .scienceBranches(Collections.emptySet())
            .build();

    public static final List<ScienceDomain> SCIENCE_DOMAINS = Collections.singletonList(SCIENCE_DOMAIN_1);

    public static final ScienceBranch SCIENCE_BRANCH_1 = ScienceBranch.builder()
            .id(1)
            .name("SCIENCE_BRANCH_1")
            .scienceDomain(SCIENCE_DOMAIN_1)
            .scienceProfiles(Collections.emptySet())
            .build();

    public static final List<ScienceBranch> SCIENCE_BRANCHES = Collections.singletonList(SCIENCE_BRANCH_1);

    public static final ScienceProfile SCIENCE_PROFILE_1 = ScienceProfile.builder()
            .id(1)
            .name("SCIENCE_PROFILE_1")
            .scienceBranch(SCIENCE_BRANCH_1)
            .specialities(Collections.emptySet())
            .build();

    public static final List<ScienceProfile> SCIENCE_PROFILES = Collections.singletonList(SCIENCE_PROFILE_1);

}
