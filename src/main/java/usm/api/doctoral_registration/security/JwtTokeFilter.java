package usm.api.doctoral_registration.security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationManagerResolver;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.web.authentication.BearerTokenAuthenticationFilter;
import org.springframework.stereotype.Component;


//@Component
public class JwtTokeFilter {


//    private final JwtTokenUtil jwtTokenUtil;
//    private final UserRepo userRepo;

//    public JwtTokenFilter(JwtTokenUtil jwtTokenUtil,
//                          UserRepo userRepo) {
//        this.jwtTokenUtil = jwtTokenUtil;
//        this.userRepo = userRepo;
//    }

//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response,
//                                    FilterChain chain)
//            throws ServletException, IOException {
//        // Get authorization header and validate
//        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
//        if (isEmpty(header) || !header.startsWith("Bearer ")) {
//            chain.doFilter(request, response);
//            return;
//        }
//
//        // Get jwt token and validate
//        final String token = header.split(" ")[1].trim();
////        if (!jwtTokenUtil.validate(token)) {
////            chain.doFilter(request, response);
////            return;
////        }
//
//        // Get user identity and set it on the spring security context
////        UserDetails userDetails = userRepo
////                .findByUsername(jwtTokenUtil.getUsername(token))
////                .orElse(null);
//
////        UsernamePasswordAuthenticationToken
////                authentication = new UsernamePasswordAuthenticationToken(
//////                userDetails, null,
//////                userDetails == null ?
//////                        List.of() : userDetails.getAuthorities()
////        );
////
////        authentication.setDetails(
////                new WebAuthenticationDetailsSource().buildDetails(request)
////        );
////
////        SecurityContextHolder.getContext().setAuthentication(authentication);
//        chain.doFilter(request, response);
//    }


}
