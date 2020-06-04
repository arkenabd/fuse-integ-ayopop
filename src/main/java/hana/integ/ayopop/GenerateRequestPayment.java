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

public class GenerateRequestPayment {

	public void process(String accountNumber, String productCode, String inquiryId, String amount, String refNumber,
			String month, String billIds, Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("inquiryId: " + inquiryId);
		try {
			System.out.println("month :" + month);
			if (month.length() == 0) {
				month = "-";
			}
		} catch (Exception e) {
			month = "-";
		}
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
//		HashMap<String, Object> mapPayloadBuyerDetail = new HashMap<String, Object>();
//		mapPayloadBuyerDetail.put("buyerEmail", "test@gmail.com");
//		mapPayloadBuyerDetail.put("publicBuyerId", "1122457HG23");
		String[] callbackArr = {
				"http://integ-ayopop-apim.apps.ocp-dev.hanabank.co.id/hanabank/integ/ayopop/callback" };

		JwtBuilder builder = Jwts.builder().setHeaderParam("alg", "HS256").setHeaderParam("typ", "JWT")
				.claim("inquiryId", Long.parseLong(inquiryId.trim())).claim("accountNumber", accountNumber)
				.claim("productCode", productCode).claim("amount", Long.parseLong(amount.trim()))
				.claim("refNumber", refNumber);
		if (month != ("-")) {
			builder.claim("month", Long.parseLong(month));
		}

		builder.claim("partnerId", partnerId).claim("CallbackUrls", callbackArr).signWith(SignatureAlgorithm.HS256,
				base64Secret);

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
		System.out.println("Header Request Payment Ayopop :" + exchange.getIn().getHeaders().toString());

	}

}
