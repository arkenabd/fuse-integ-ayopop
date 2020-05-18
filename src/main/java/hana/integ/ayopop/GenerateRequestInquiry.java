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

	public void process(String accoutnNumber, String productCode, Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		PropertiesComponent pc = exchange.getContext().getComponent("properties", PropertiesComponent.class);
		pc.setLocation("classpath:application.properties");
		pc.setCache(false);
		java.util.Properties properties = new java.util.Properties();
		String partnerId = "mGKm25W0454v";
		String apiSecret = "0eN7R4uR1pxJvwJV7rAkfpQ5TTKCkanfhwN";
		String token = "";

		// Generate Token
		String key = apiSecret;
		String base64Secret = DatatypeConverter.printBase64Binary(key.getBytes());
		// Payload
		HashMap<String, Object> mapPayload = new HashMap<String, Object>();
		mapPayload.put("partnerId", partnerId);
		mapPayload.put("accountNumber", accoutnNumber);
		mapPayload.put("productCode", productCode);

		JwtBuilder builder = Jwts.builder().setHeaderParam("alg", "HS256").setHeaderParam("typ", "JWT")
				.addClaims(mapPayload).signWith(SignatureAlgorithm.HS256, base64Secret);

		token = builder.compact();

		// Set Header
		exchange.getIn().getHeaders().clear();
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
