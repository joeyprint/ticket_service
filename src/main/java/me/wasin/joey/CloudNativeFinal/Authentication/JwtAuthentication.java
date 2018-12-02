package me.wasin.joey.CloudNativeFinal.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import me.wasin.joey.CloudNativeFinal.User.User;

import java.util.Date;

public class JwtAuthentication {

    private static String SECRET_KEY = "JoeyWasinVerySecret";
    private static final long TIMEOUT = 1000 * 600;

    public static String createToken(User user) {
        user.setPassword("");
        user.setUsername("");
        String token = Jwts.builder()
                .setIssuedAt(new Date())
                .setSubject("TicketEvent")
                .claim("User", user)
                .setNotBefore(new Date(System.currentTimeMillis() + TIMEOUT))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
        return token;
    }

    public static void validateToken(String token) {
        Jwts.parser().setSigningKey(SECRET_KEY)
                .parse(token);
    }
}
