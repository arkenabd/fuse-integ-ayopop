package hana.integ.ayopop.req;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "inquiryId", "accountNumber", "productCode", "amount", "refNumber", "partnerId", "buyerDetails",
		"CallbackUrls" })
public class PaymentReq {

	@JsonProperty("inquiryId")
	private Integer inquiryId;
	@JsonProperty("accountNumber")
	private String accountNumber;
	@JsonProperty("productCode")
	private String productCode;
	@JsonProperty("amount")
	private Integer amount;
	@JsonProperty("refNumber")
	private String refNumber;
	@JsonProperty("partnerId")
	private String partnerId;
	@JsonProperty("buyerDetails")
	private PaymentBuyerDetailsReq buyerDetails;
	@JsonProperty("CallbackUrls")
	private List<String> callbackUrls = null;

	@JsonProperty("inquiryId")
	public Integer getInquiryId() {
		return inquiryId;
	}

	@JsonProperty("inquiryId")
	public void setInquiryId(Integer inquiryId) {
		this.inquiryId = inquiryId;
	}

	@JsonProperty("accountNumber")
	public String getAccountNumber() {
		return accountNumber;
	}

	@JsonProperty("accountNumber")
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@JsonProperty("productCode")
	public String getProductCode() {
		return productCode;
	}

	@JsonProperty("productCode")
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	@JsonProperty("amount")
	public Integer getAmount() {
		return amount;
	}

	@JsonProperty("amount")
	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@JsonProperty("refNumber")
	public String getRefNumber() {
		return refNumber;
	}

	@JsonProperty("refNumber")
	public void setRefNumber(String refNumber) {
		this.refNumber = refNumber;
	}

	@JsonProperty("partnerId")
	public String getPartnerId() {
		return partnerId;
	}

	@JsonProperty("partnerId")
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	@JsonProperty("buyerDetails")
	public PaymentBuyerDetailsReq getBuyerDetails() {
		return buyerDetails;
	}

	@JsonProperty("buyerDetails")
	public void setBuyerDetails(PaymentBuyerDetailsReq buyerDetails) {
		this.buyerDetails = buyerDetails;
	}

	@JsonProperty("CallbackUrls")
	public List<String> getCallbackUrls() {
		return callbackUrls;
	}

	@JsonProperty("CallbackUrls")
	public void setCallbackUrls(List<String> callbackUrls) {
		this.callbackUrls = callbackUrls;
	}

	public PaymentReq assignValue(String inquiryId, String accountNumber, String productCode, String amount,
			String refNumber, String partnerId, String buyerEmail, String publicBuyerId) {
		PaymentReq jreq = new PaymentReq();
		jreq.setInquiryId(Integer.parseInt(inquiryId.trim()));
		jreq.setAccountNumber(accountNumber.trim());
		jreq.setProductCode(productCode.trim());
		jreq.setAmount(Integer.parseInt(amount.trim()));
		jreq.setRefNumber(refNumber.trim());
		jreq.setPartnerId(partnerId.trim());
		PaymentBuyerDetailsReq buyerD = new PaymentBuyerDetailsReq();
		buyerD.setBuyerEmail(buyerEmail.trim());
		buyerD.setPublicBuyerId(publicBuyerId.trim());
		jreq.setBuyerDetails(buyerD);
		List<String> callbackUrlsInp = new ArrayList<String>();
		callbackUrlsInp.add("");
		jreq.setCallbackUrls(callbackUrlsInp);
		return jreq;
	}

}