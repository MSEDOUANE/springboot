
// package com.example.springboot;

// import java.io.IOException;
// import java.sql.Date;
// import java.util.ArrayList;

// import javax.servlet.FilterChain;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// import com.auth0.jwt.JWT;
// import com.auth0.jwt.algorithms.Algorithm;
// import com.example.springboot.models.User;
// import com.fasterxml.jackson.databind.ObjectMapper;

// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.AuthenticationException;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


// public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

//     private static final long EXPIRATION_TIME = 0;
// 	private AuthenticationManager authenticationManager;

//     public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
//         this.authenticationManager = authenticationManager;

//     }

//     @Override
//     public Authentication attemptAuthentication(HttpServletRequest req,
//                                                 HttpServletResponse res) throws AuthenticationException {
//         try {
//             User creds = new ObjectMapper()
//                     .readValue(req.getInputStream(), User.class);

//             return authenticationManager.authenticate(
//                     new UsernamePasswordAuthenticationToken(
//                             creds.getName(),
//                             creds.getPassword(),
//                             new ArrayList<>())
//             );
//         } catch (IOException e) {
//             throw new RuntimeException(e);
//         }
//     }

//     @Override
//     protected void successfulAuthentication(HttpServletRequest req,
//                                             HttpServletResponse res,
//                                             FilterChain chain,
//                                             Authentication auth) throws IOException {
//         String token = JWT.create()
//                 .withSubject(((User) auth.getPrincipal()).getName())
//                 .withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
//                 .sign(Algorithm.HMAC512(SecurityConstants.SECRET.getBytes()));

//         String body = ((User) auth.getPrincipal()).getName() + " " + token;

//         res.getWriter().write(body);
//         res.getWriter().flush();
//     }
// }
