package usm.api.doctoral_registration.security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.util.Date;

import static org.springframework.util.ObjectUtils.isEmpty;

@Component
public class JwtTokenValidator {

    public void validate(String token) {
        if (isEmpty(token) || !token.startsWith("Bearer ")) {
            throw new RuntimeException();
        }
        String accessToken = token.substring(7);
        DecodedJWT decodedJWT = JWT.decode(accessToken);
        Long expireDate = decodedJWT.getExpiresAt().getTime();
        Long currentDate = new Date().getTime();
        boolean isActive = (expireDate - currentDate) > 0;
        if (!isActive)
            throw new RuntimeException();
    }
}
