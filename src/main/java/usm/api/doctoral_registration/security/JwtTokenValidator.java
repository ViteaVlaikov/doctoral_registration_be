package usm.api.doctoral_registration.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenValidator implements OAuth2TokenValidator<Jwt> {
    @Override
    public OAuth2TokenValidatorResult validate(Jwt token) {
        if (token.getAudience().contains("3290a8de-07b9-47b3-b0f3-1cab68ee6e8d")) {
            return OAuth2TokenValidatorResult.success();
        } else {
            return OAuth2TokenValidatorResult.failure(
                    new OAuth2Error("invalid_token", "The audience is not as expected, got " + token.getAudience(),
                            null));
        }
    }
}
