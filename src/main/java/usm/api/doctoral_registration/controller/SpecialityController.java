package usm.api.doctoral_registration.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import usm.api.doctoral_registration.dto.science.SpecialityDto;
import usm.api.doctoral_registration.mapper.YearStudyMapper;
import usm.api.doctoral_registration.service.science.SpecialityService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/sciences/specialities")
@CrossOrigin(origins = {"http://localhost:3000"})
public class SpecialityController {
    private final SpecialityService specialityService;
    private final YearStudyMapper yearStudyMapper;

    @GetMapping("/profiles/{id}/{year}")
    public ResponseEntity<List<SpecialityDto>> getSpecialitiesByProfileIdAndYear(
            @PathVariable Integer id, @PathVariable Integer year) {
        return ResponseEntity.ok(specialityService.findAllByScienceProfileIdAndGrade(id, yearStudyMapper.mapFromInteger(year)));
    }
}
