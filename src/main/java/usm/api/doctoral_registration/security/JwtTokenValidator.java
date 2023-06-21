package usm.api.doctoral_registration.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;
import usm.api.doctoral_registration.exception.CodeException;
import usm.api.doctoral_registration.exception.security.InvalidCause;
import usm.api.doctoral_registration.exception.security.TokenInvalidException;

import java.util.Date;

import static org.springframework.util.ObjectUtils.isEmpty;

@Component
public class JwtTokenValidator {

    public void validate(String token) {
        if (isEmpty(token)) {
            throw new TokenInvalidException(InvalidCause.EMPTY_TOKEN, CodeException.INVALID_TOKEN);
        }
        if (!token.startsWith("Bearer ")) {
            throw new TokenInvalidException(InvalidCause.BEARER_NOT_CONTAINING, CodeException.INVALID_TOKEN);
        }
        String accessToken = token.substring(7);
        DecodedJWT decodedJWT = JWT.decode(accessToken);
        Long expireDate = decodedJWT.getExpiresAt().getTime();
        Long currentDate = new Date().getTime();
        boolean isActive = (expireDate - currentDate) > 0;
        if (!isActive)
            throw new TokenInvalidException(InvalidCause.EXPIRED_TOKEN, CodeException.INVALID_TOKEN);
    }
}
