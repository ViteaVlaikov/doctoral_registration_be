package usm.api.doctoral_registration.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import usm.api.doctoral_registration.model.science.ScienceDomain;
import usm.api.doctoral_registration.service.science.ScienceDomainService;
import java.util.ArrayList;
import java.util.List;

import static usm.api.doctoral_registration.util.MockDataUtils.SCIENCE_DOMAINS;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequiredArgsConstructor
@RequestMapping("api")
@Slf4j
public class ScienceDomainController {
    private final ScienceDomainService domainService;

    @GetMapping("/domain")
    public List<ScienceDomain> getAll(){
        return domainService.findAll();
    }

    @GetMapping("/domain/{school_id}/{year}")
    public List<ScienceDomain> findAllByScienceSchoolIdAndYear(@PathVariable Integer school_id, @PathVariable Integer year){
        return domainService.findAllByScienceSchoolIdAndYear(school_id,year);
    }
}
