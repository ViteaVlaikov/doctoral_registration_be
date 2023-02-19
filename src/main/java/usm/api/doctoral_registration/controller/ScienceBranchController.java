package usm.api.doctoral_registration.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import usm.api.doctoral_registration.model.science.ScienceBranch;
import usm.api.doctoral_registration.service.science.ScienceBranchService;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class ScienceBranchController {
    private final ScienceBranchService scienceBranchService;

    @GetMapping("/branch/{domain_id}/{year}")
    List<ScienceBranch> findAllByDomainIdAndYear(@PathVariable Integer domain_id, @PathVariable Integer year){
        return null;
    }
}
