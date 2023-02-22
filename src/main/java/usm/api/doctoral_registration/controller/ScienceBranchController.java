package usm.api.doctoral_registration.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import usm.api.doctoral_registration.model.science.ScienceBranch;
import usm.api.doctoral_registration.service.science.ScienceBranchService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/sciences/branches")
@CrossOrigin(origins = {"http://localhost:3000"})
public class ScienceBranchController {

    private final ScienceBranchService scienceBranchService;

    @GetMapping("domains/{id}/{year}")
    List<ScienceBranch> findAllByDomainIdAndYear(@PathVariable Integer id, @PathVariable Integer year) {
        return null;
    }
}
