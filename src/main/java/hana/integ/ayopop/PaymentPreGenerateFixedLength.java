package hana.integ.ayopop;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import org.apache.camel.Exchange;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class PaymentPreGenerateFixedLength {
	public String randomNumeric(int n) {
		return RandomStringUtils.randomNumeric(n);
	}

	public String randomAlphabetic(int n) {
		return RandomStringUtils.randomAlphabetic(n);
	}

	public String randomAlphanumeric(int n) {
		return RandomStringUtils.randomAlphanumeric(n);
	}

	public List<Map<String, String>> generate(String responseCode, String inquiryId, String accountNumber,
			String customerName, String productName, String productCode, String amount, String totalAdmin,
			String validity, String messageEn, Exchange exchange) {
		// Get counter
		String existingCounter = exchange.getProperty("counter").toString();
		// Get length additional field
		int addFLength = exchange.getProperty("additionalFields").toString().length();
		// Map response code to 2 digit : (0 - 99 -> 00) ,(300 -> 00), (100 - 199 ->
		// 05), (301 - 399 -> 05), (200 - 299 -> 68)
		int respCode = Integer.parseInt(responseCode);
		String respCodeSubmit = "";
		if ((respCode >= 0 && respCode <= 99) || respCode == 300) {
			respCodeSubmit = "00";
		}
		if ((respCode >= 100 && respCode <= 199) || (respCode >= 301 && respCode <= 399)) {
			respCodeSubmit = "05";
		}
		if (respCode >= 200 && respCode <= 299) {
			respCodeSubmit = "68";
		}

		List<Map<String, String>> flResultList = new ArrayList<Map<String, String>>();
		System.out.println("=====[Start] Generate fixed length response message to Hobis=====");
		Map<String, String> map = new HashMap<>();
		if (respCodeSubmit.equals("05") || respCodeSubmit.equals("68")) {
			int length = messageEn.length();
			if (length <= 46) {
				messageEn = messageEn.substring(15);
			} else {
				messageEn = messageEn.substring(15, 46);
			}
			map.put("CUSTOMER_NAME", StringUtils.rightPad(messageEn, 30, " "));
		} else {
			map.put("CUSTOMER_NAME", StringUtils.rightPad(customerName, 30, " "));
		} // jika code 05 atau 68 disii dengan
			// reason :EN
		if (productName.length() > 30) {
			productName = productName.substring(0, 30);
		}
		if (productCode.length() > 20) {
			productCode = productCode.substring(0, 20);
		}
		if (amount.length() > 16) {
			amount = amount.substring(0, 16);
		}
		if (totalAdmin.length() > 12) {
			totalAdmin = totalAdmin.substring(0, 12);
		}
		if (validity.length() > 8) {
			validity = validity.substring(0, 16);
		}
		// Generate date with format yyyyMMddHHmmss as TRANSACTION_ID component
		String pattern = "yyyyMMddHHmmss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		map.put("SWITCH_CODE", StringUtils.rightPad("RAPI", 4, " "));// incoming RAPI kalao outgoing HOBI
		map.put("TRANSACTION_ID", StringUtils.rightPad(date, 14, " "));// yyyymmddhhmmss
		map.put("TRANSACTION_ID_SEQNUM", StringUtils.leftPad(existingCounter, 6, "0"));
		map.put("CLIENT_ID_COMMON", StringUtils.rightPad("AYOPOP", 6, " "));
		map.put("PROCESS_CODE", StringUtils.rightPad("AYOPYMN", 7, " "));

		map.put("RESP_CODE", StringUtils.rightPad(respCodeSubmit, 2, " "));
		map.put("INQUIRY_ID", StringUtils.rightPad(inquiryId, 10, " "));
		map.put("ACCOUNT_NUMBER", StringUtils.rightPad(accountNumber, 20, " "));
		map.put("CUSTOMER_NAME", StringUtils.rightPad(customerName, 30, " "));
		map.put("PRODUCT_NAME", StringUtils.rightPad(productName, 30, " "));
		map.put("PRODUCT_CODE", StringUtils.rightPad(productCode, 20, " "));
		map.put("AMOUNT", StringUtils.leftPad(amount, 16, "0"));
		map.put("TOTAL_ADMIN", StringUtils.leftPad(totalAdmin, 12, "0"));
		map.put("VALIDITY", StringUtils.rightPad(validity, 8, " "));

		int headerLength = 4 + map.get("SWITCH_CODE").length() + map.get("TRANSACTION_ID").length()
				+ map.get("TRANSACTION_ID_SEQNUM").length() + map.get("CLIENT_ID_COMMON").length()
				+ map.get("PROCESS_CODE").length() + map.get("RESP_CODE").length() + map.get("INQUIRY_ID").length()
				+ map.get("ACCOUNT_NUMBER").length() + map.get("CUSTOMER_NAME").length()
				+ map.get("PRODUCT_NAME").length() + map.get("PRODUCT_CODE").length() + map.get("AMOUNT").length()
				+ map.get("TOTAL_ADMIN").length() + map.get("VALIDITY").length() + addFLength;
		map.put("LENGTH", StringUtils.leftPad(String.valueOf(headerLength), 4, "0"));
		System.out.println("=====[Finish] Preparing fixed length response message to Hobis=====");
		flResultList.add(map);
		return flResultList;
	}

}
