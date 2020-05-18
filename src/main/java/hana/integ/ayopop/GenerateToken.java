package hana.integ.ayopop;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.properties.PropertiesComponent;
import org.restlet.data.MediaType;

import hana.integ.ayopop.util.JWTUtil;

public class GenerateToken{

	
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		JWTUtil jwt = new JWTUtil();
		exchange.getIn().getHeaders().clear();
		String TRX = exchange.getProperty("TRX").toString();
		System.out.println("TRX Type: " + TRX);
		String token = jwt.generateJWT(TRX);
		exchange.getIn().setHeader(Exchange.CONTENT_TYPE, "application/json");
		exchange.getIn().setHeader("KEY", "mGKm25W0454v");
		exchange.getIn().setHeader("TOKEN", token);
		exchange.getIn().setHeader("Host", "dev.openapi.ayopop.id");
		exchange.getIn().setHeader(Exchange.HTTP_METHOD, "POST");
		exchange.getIn().setHeader("Cache-Control", "no-cache");
		exchange.getIn().setHeader("Connection", "keep-alive");
		
		
		exchange.getIn().setHeader("VERSION", "1.0");
		System.out.println("your header :" + exchange.getIn().getHeaders().toString());

	}

}
