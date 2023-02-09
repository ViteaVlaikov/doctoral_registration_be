package usm.api.doctoral_registration.repository.sciences;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import usm.api.doctoral_registration.model.sciences.ScienceSchool;

import java.util.List;
import java.util.Map;

@Repository
public interface ScienceSchoolRepository extends JpaRepository<ScienceSchool, Long> {
}