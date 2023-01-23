package usm.api.doctoral_registration.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import usm.api.doctoral_registration.model.sciences.Speciality;
import usm.api.doctoral_registration.service.SpecialityService;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:8080"})
@RestController
@RequiredArgsConstructor
@RequestMapping("api")
@Slf4j
public class SalamController {
    private final SpecialityService specialityService;
    @GetMapping("/salam")
    public String salam(Authentication authentication) {
        DefaultOidcUser user = (DefaultOidcUser) authentication.getPrincipal();
        return "Salam " + user.getName() + ", Bro!!! " + user.getAuthorities();
    }

    @GetMapping("/specialities")
    public ResponseEntity<List<Speciality>> getSpecialities(){
        return ResponseEntity.ok(specialityService.findAll());
    }

}
