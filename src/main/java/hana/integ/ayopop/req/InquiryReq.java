package hana.integ.ayopop.req;

import org.apache.camel.Exchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "partnerId", "accountNumber", "productCode" })
public class InquiryReq {

	@JsonProperty("partnerId")
	private String partnerId;
	@JsonProperty("accountNumber")
	private String accountNumber;
	@JsonProperty("productCode")
	private String productCode;

	@JsonProperty("partnerId")
	public String getPartnerId() {
		return partnerId;
	}

	@JsonProperty("partnerId")
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
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

	public InquiryReq assignValue(String partnerId, String accountNumber, String productCode) {
		InquiryReq jreq = new InquiryReq();

		jreq.setPartnerId(partnerId.trim());
		jreq.setAccountNumber(accountNumber.trim());
		jreq.setProductCode(productCode.trim());
		return jreq;
	}

}