// package com.example.springboot.Services;

// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;

// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// import com.fasterxml.jackson.core.JsonProcessingException;
// import com.fasterxml.jackson.databind.JsonNode;
// import com.fasterxml.jackson.databind.ObjectMapper;

// import java.util.Date;

// import static java.util.Collections.emptyList;

// import java.io.BufferedReader;
// import java.io.IOException;

// public class AuthenticationService {
//   static final long EXPIRATIONTIME = 864_000_00; // 1 day in milliseconds
//   static final String SIGNINGKEY = "SecretKey";
//   static final String PREFIX = "Bearer";

//   static public void addToken(HttpServletResponse res, String username) {
//     String JwtToken = Jwts.builder().setSubject(username)
//         .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
//         .signWith(SignatureAlgorithm.HS512, SIGNINGKEY).compact();
//     res.addHeader("Authorization", PREFIX + " " + JwtToken);
//     res.addHeader("Access-Control-Expose-Headers", "Authorization");
//   }

//   static public Authentication getAuthentication(HttpServletRequest request) {
//     String token = null;
//     try {
//       token = request.getReader().toString();
//     } catch (IOException e1) {
//       // TODO Auto-generated catch block
//       e1.printStackTrace();
//     }
//     StringBuilder sb = new StringBuilder();
//     BufferedReader reader = null;
//     try {
//       reader = request.getReader();
//     } catch (IOException e) {
//       // TODO Auto-generated catch block
//       e.printStackTrace();
//     }
//     try {
//       String line;
//       while ((line = reader.readLine()) != null) {
//         sb.append(line).append('\n');
//       }
//     } catch (IOException e) {
//       // TODO Auto-generated catch block
//       e.printStackTrace();
//     } finally {
//       try {
//         reader.close();
//       } catch (IOException e) {
//         // TODO Auto-generated catch block
//         e.printStackTrace();
//       }
//     }
//     System.out.println(sb.toString());
//     String user = null;
//     ObjectMapper mapper = new ObjectMapper();
//     try {
//       JsonNode actualObj = mapper.readTree(sb.toString());
//       user = actualObj.get("username").asText();
//     } catch (JsonProcessingException e) {
//       // TODO Auto-generated catch block
//       e.printStackTrace();
//     }

//     if (user != null)
//       return new UsernamePasswordAuthenticationToken(user, null, emptyList());

//     return null;
//   }
// }