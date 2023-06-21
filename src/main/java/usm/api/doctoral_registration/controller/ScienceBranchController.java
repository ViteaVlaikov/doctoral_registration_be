package usm.api.doctoral_registration.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import usm.api.doctoral_registration.dto.science.ScienceBranchDto;
import usm.api.doctoral_registration.service.science.ScienceBranchService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/sciences/branches")
@CrossOrigin(origins = {"http://localhost:3000"})
public class ScienceBranchController {

    private final ScienceBranchService branchService;

    @GetMapping
    public ResponseEntity<List<ScienceBranchDto>> getAll() {
        return ResponseEntity.ok(branchService.getAll());
    }
}
