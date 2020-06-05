package hana.integ.ayopop.util;

import org.apache.camel.Exchange;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AdditionalFields {

	public void generateAdditionalField(String jsonString, Exchange exchange) {
		System.out.println("=====[Start] Generate Additional Fields=====");
		String additionalField = "{"
				+ jsonString.trim().substring(jsonString.indexOf("message") - 1, jsonString.indexOf("},") + 2)
				+ jsonString.substring(jsonString.indexOf("customerDetail") - 1, jsonString.length() - 1);
//		System.out.println(additionalField.replaceAll("[\r\n ]", ""));
		exchange.setProperty("additionalFields", additionalField.replaceAll("[\r\n]", "").trim());
		System.out.println("additionalFields :" + exchange.getProperty("additionalFields"));
		System.out.println("=====[Finish] Generate Additional Fields=====");
	}

	public String concatenate(String body, Exchange exchange) {
		System.out.println("=====[Start] Concatenate body + Additional Fields=====");
		System.out.println("body :" + body.toString().replace("\n", "").replace("\r", ""));
		System.out.println("body length:" + body.toString().replace("\n", "").replace("\r", "").length());
		System.out.println("additionalFields :" + exchange.getProperty("additionalFields").toString().trim());
		System.out.println("additionalFields length :" + exchange.getProperty("additionalFields"));
		String output = body.toString().replaceAll("[\r\n]", "")
				+ exchange.getProperty("additionalFields").toString().trim();
		System.out.println("=====[Finish] Concatenate body + Additional Fields=====");
		return output;
	}

}
