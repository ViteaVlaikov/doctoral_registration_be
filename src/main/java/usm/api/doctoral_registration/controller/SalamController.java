package usm.api.doctoral_registration.controller;

import com.nimbusds.openid.connect.sdk.AuthenticationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
@Slf4j
public class SalamController {
    @GetMapping("/salam")
    public String salam(Authentication authentication) {
        DefaultOidcUser user = (DefaultOidcUser) authentication.getPrincipal();
        return "Salam " + user.getName() + ", Bro!!!";
    }
}
