package hana.integ.ayopop.util;

import org.apache.camel.Exchange;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AdditionalFields {

	public void generateAdditionalField(String jsonString, Exchange exchange) {
		System.out.println("=====[Start] Generate Additional Fields=====");
		JSONObject obj = new JSONObject(jsonString);
		String customerDetail = "";
		String billDetails = "";
		String productDetails = "";
		String extraFields = "";

		try {
			customerDetail = obj.getJSONObject("data").getJSONArray("customerDetail").toString().trim();
		} catch (JSONException e) {
			customerDetail = "";
		}
		try {
			billDetails = obj.getJSONObject("data").getJSONArray("billDetails").toString().trim();
		} catch (JSONException e) {
			billDetails = "";
		}
		try {
			productDetails = obj.getJSONObject("data").getJSONArray("productDetails").toString().trim();
		} catch (JSONException e) {
			productDetails = "";
		}
		try {
			extraFields = obj.getJSONObject("data").getJSONArray("extraFields").toString().trim();
		} catch (JSONException e) {
			extraFields = "";
		}

		System.out.println("customerDetail :" + customerDetail);
		System.out.println("billDetails :" + billDetails);
		System.out.println("productDetails :" + productDetails);
		System.out.println("extraFields :" + extraFields);
		exchange.setProperty("additionalFields",
				customerDetail + "," + billDetails + "," + productDetails + "," + extraFields);
		System.out.println("additionalFields :" + exchange.getProperty("additionalFields"));
		System.out.println("=====[Finish] Generate Additional Fields=====");
	}

	public String concatenate(String body, Exchange exchange) {
		System.out.println("=====[Start] Concatenate body + Additional Fields=====");
		System.out.println("body :" + body.toString().replace("\n", "").replace("\r", ""));
		System.out.println("body length:" + body.toString().replace("\n", "").replace("\r", "").length());
		System.out.println("additionalFields :" + exchange.getProperty("additionalFields").toString().trim());
		System.out.println("additionalFields length :" + exchange.getProperty("additionalFields").toString().length());
		String output = body.toString().replace("\n", "").replace("\r", "")
				+ exchange.getProperty("additionalFields").toString().trim();
		System.out.println("=====[Finish] Concatenate body + Additional Fields=====");
		return output;
	}

}
