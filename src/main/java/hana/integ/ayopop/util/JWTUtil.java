package hana.integ.ayopop.util;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import hana.integ.ayopop.ProductlistJwtPayload;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtil {
	// API-KEY= mGKm25W0454v
	// API-SECRET= 0eN7R4uR1pxJvwJV7rAkfpQ5TTKCkanfhwN
	// 0eN7R4uR1pxJvwJV7rAkfpQ5TTKCkanfhwN
	String JWT = "";
	static String key = "0eN7R4uR1pxJvwJV7rAkfpQ5TTKCkanfhwN";
	private static final String base64Secret = DatatypeConverter.printBase64Binary(key.getBytes());

	public String generateJWT(String TRX) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("typ", "JWT");
		map.put("alg", "HS256");
		JwtBuilder builder = null;
		if (TRX.equals("productlist")) {
			ProductlistJwtPayload payload = new ProductlistJwtPayload();
			System.out.println("TRX : productlist");
			builder = Jwts.builder().setHeaderParam("alg", "HS256").setHeaderParam("typ", "JWT")
					.addClaims(payload.generatePayload()).signWith(SignatureAlgorithm.HS256, base64Secret);
		}
		if (TRX.equals("inquiry")) {
			ProductlistJwtPayload payload = new ProductlistJwtPayload();
			System.out.println("TRX : inquiry");
			builder = Jwts.builder().setHeaderParam("alg", "HS256").setHeaderParam("typ", "JWT")
					.addClaims(payload.generatePayload()).signWith(SignatureAlgorithm.HS256, base64Secret);
		}

		// Builds the JWT and serializes it to a compact, URL-safe string
		System.out.println("Generated JWT :" + builder.compact());
		JWT = builder.compact();
		return builder.compact();
	}

	public void parseJWT() {
		String jwt = JWT;
		// This line will throw an exception if it is not a signed JWS (as expected)
		System.out.println("Key :" + base64Secret);
		Claims claims = Jwts.parser().setSigningKey(base64Secret).parseClaimsJws(jwt).getBody();
		System.out.println("partnerId: " + claims.get("partnerId"));
	}

}
