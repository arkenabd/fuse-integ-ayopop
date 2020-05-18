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
public class BalancePreGenerateFixedLength {
	public String randomNumeric(int n) {
		return RandomStringUtils.randomNumeric(n);
	}

	public String randomAlphabetic(int n) {
		return RandomStringUtils.randomAlphabetic(n);
	}

	public String randomAlphanumeric(int n) {
		return RandomStringUtils.randomAlphanumeric(n);
	}

	public List<Map<String, String>> generate(String Timestamp, String ClientID, String Key, String BranchID,
			String CounterID, String ProductType, String TrxType, String Detail_TrxId, String Detail_Token,
			String Detail_noHP, String Detail_Amount, String Timeout, String VersiProgram, String RespCode,
			String RespDetail, Exchange exchange) {
		String existingCounter = exchange.getProperty("counter").toString();
		List<Map<String, String>> flResultList = new ArrayList<Map<String, String>>();
		System.out.println("==============================================");
		Map<String, String> map = new HashMap<>();
		map.put("LENGTH", StringUtils.leftPad("183", 4, "0"));
		// Generate date with format yyyyMMddHHmmss as TRANSACTION_ID component
		String pattern = "yyyyMMddHHmmss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		System.out.println(date);
		map.put("SWITCH_CODE", StringUtils.rightPad("RAPI", 4, " "));// incoming RAPI kalao outgoing HOBI
		map.put("TRANSACTION_ID", StringUtils.rightPad(date, 14, " "));// yyyymmddhhmmss
		map.put("TRANSACTION_ID_SEQNUM", StringUtils.leftPad(existingCounter, 6, "0"));
		map.put("CLIENT_ID_COMMON", StringUtils.rightPad("TOKO", 6, " "));
		map.put("PROCESS_CODE", StringUtils.rightPad("IDMCSHO", 7, " "));
		map.put("TIMESTAMP", StringUtils.rightPad(Timestamp, 19, " "));
		map.put("CLIENT_ID", StringUtils.rightPad(ClientID, 10, " "));
		map.put("KEY", StringUtils.rightPad(Key, 10, " "));
		map.put("BRANCH_ID", StringUtils.rightPad(BranchID, 4, " "));
		map.put("COUNTER_ID", StringUtils.rightPad(CounterID, 4, " "));
		map.put("PRODUCT_TYPE", StringUtils.rightPad(ProductType, 10, " "));
		map.put("TRX_TYPE", StringUtils.rightPad(TrxType, 10, " "));
		map.put("DETAIL_TRX_ID", StringUtils.rightPad(Detail_TrxId, 12, " "));
		map.put("DETAIL_TOKEN", StringUtils.rightPad(Detail_Token, 9, " "));
		map.put("DETAIL_NO_HP", StringUtils.rightPad(Detail_noHP, 15, " "));
		map.put("DETAIL_AMOUNT", StringUtils.rightPad(Detail_Amount, 17, " "));

		map.put("TIMEOUT", StringUtils.rightPad(Timeout, 2, " "));
		map.put("VERSI_PROGRAM", StringUtils.rightPad(VersiProgram, 6, " "));
		map.put("RESP_CODE", StringUtils.rightPad(RespCode, 2, " "));
		map.put("RESP_DETAIL", StringUtils.rightPad(RespDetail, 12, " "));

		flResultList.add(map);
		return flResultList;
	}

}
