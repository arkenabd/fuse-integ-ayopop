package hana.integ.ayopop;

import java.util.HashMap;

import javax.xml.bind.DatatypeConverter;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.properties.PropertiesComponent;
import org.restlet.data.MediaType;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class GenerateRequestInquiry {

	public void process(String accoutnNumber, String productCode, String zoneId, String month, Exchange exchange)
			throws Exception {
		// TODO Auto-generated method stub
		String partnerId = "mGKm25W0454v";
		String apiSecret = "0eN7R4uR1pxJvwJV7rAkfpQ5TTKCkanfhwN";
		String token = "";
		// Check value zoneId and month
		try {
			System.out.println("zoneId :" + zoneId);
			if (zoneId.length() == 0) {
				zoneId = "-";
			}
		} catch (Exception e) {
			zoneId = "-";
		}
		try {
			System.out.println("month :" + month);
			if (month.length() == 0) {
				month = "-";
			}
		} catch (Exception e) {
			month = "-";
		}

		// Generate Token
		String key = apiSecret;
		String base64Secret = DatatypeConverter.printBase64Binary(key.getBytes());

//		JwtBuilder builder = Jwts.builder().setHeaderParam("alg", "HS256").setHeaderParam("typ", "JWT")
//				.addClaims(mapPayload).signWith(SignatureAlgorithm.HS256, base64Secret);
		JwtBuilder builder = Jwts.builder().setHeaderParam("alg", "HS256").setHeaderParam("typ", "JWT")
				.claim("partnerId", partnerId).claim("accountNumber", accoutnNumber).claim("productCode", productCode);
		if (zoneId != ("-")) {
			builder.claim("zoneId", zoneId);
		}
		if (month != ("-")) {
			builder.claim("month", Long.parseLong(month));
		}

		builder.signWith(SignatureAlgorithm.HS256, base64Secret);

		token = builder.compact();

		// Set Header
		try {
			exchange.getIn().getHeaders().clear();
		} catch (Exception e) {
		}
		exchange.getIn().setHeader(Exchange.CONTENT_TYPE, "application/json");
		exchange.getIn().setHeader("KEY", partnerId);
		exchange.getIn().setHeader("TOKEN", token);
		exchange.getIn().setHeader("Host", "dev.openapi.ayopop.id");
		exchange.getIn().setHeader(Exchange.HTTP_METHOD, "POST");
		exchange.getIn().setHeader("Cache-Control", "no-cache");
		exchange.getIn().setHeader("Connection", "keep-alive");
		exchange.getIn().setHeader("VERSION", "1.0");
		System.out.println("Header Request Inquiry Ayopop :" + exchange.getIn().getHeaders().toString());

	}

}
