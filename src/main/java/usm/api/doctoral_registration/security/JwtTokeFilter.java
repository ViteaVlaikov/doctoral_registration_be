package usm.api.doctoral_registration.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static org.springframework.util.ObjectUtils.isEmpty;

@Component
public class JwtTokeFilter extends OncePerRequestFilter {

//    private final JwtTokenUtil jwtTokenUtil;
//    private final UserRepo userRepo;

//    public JwtTokenFilter(JwtTokenUtil jwtTokenUtil,
//                          UserRepo userRepo) {
//        this.jwtTokenUtil = jwtTokenUtil;
//        this.userRepo = userRepo;
//    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws ServletException, IOException {
        // Get authorization header and validate
        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (isEmpty(header) || !header.startsWith("Bearer ")) {
            chain.doFilter(request, response);
            return;
        }

        // Get jwt token and validate
        final String token = header.split(" ")[1].trim();
//        if (!jwtTokenUtil.validate(token)) {
//            chain.doFilter(request, response);
//            return;
//        }

        // Get user identity and set it on the spring security context
//        UserDetails userDetails = userRepo
//                .findByUsername(jwtTokenUtil.getUsername(token))
//                .orElse(null);

//        UsernamePasswordAuthenticationToken
//                authentication = new UsernamePasswordAuthenticationToken(
////                userDetails, null,
////                userDetails == null ?
////                        List.of() : userDetails.getAuthorities()
//        );
//
//        authentication.setDetails(
//                new WebAuthenticationDetailsSource().buildDetails(request)
//        );
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }

}
