package usm.api.doctoral_registration.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class SalamController {
    @GetMapping("/salam")
    public String salam(){
        return "Salam!!!";
    }
}
