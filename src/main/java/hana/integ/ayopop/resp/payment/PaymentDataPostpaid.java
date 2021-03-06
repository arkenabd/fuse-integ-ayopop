package hana.integ.ayopop.resp.payment;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "refNumber", "transactionId", "accountNumber", "amount", "totalAdmin", "productCode",
		"productName", "category", "token", "customerDetails", "billDetails", "productDetails", "extraFields" })
public class PaymentDataPostpaid {

	@JsonProperty("refNumber")
	private String refNumber;
	@JsonProperty("transactionId")
	private Integer transactionId;
	@JsonProperty("accountNumber")
	private String accountNumber;
	@JsonProperty("amount")
	private Integer amount;
	@JsonProperty("totalAdmin")
	private Integer totalAdmin;
	@JsonProperty("productCode")
	private String productCode;
	@JsonProperty("productName")
	private String productName;
	@JsonProperty("category")
	private String category;
	@JsonProperty("token")
	private String token;

	@JsonProperty("refNumber")
	public String getRefNumber() {
		return refNumber;
	}

	@JsonProperty("refNumber")
	public void setRefNumber(String refNumber) {
		this.refNumber = refNumber;
	}

	@JsonProperty("transactionId")
	public Integer getTransactionId() {
		return transactionId;
	}

	@JsonProperty("transactionId")
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	@JsonProperty("accountNumber")
	public String getAccountNumber() {
		return accountNumber;
	}

	@JsonProperty("accountNumber")
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@JsonProperty("amount")
	public Integer getAmount() {
		return amount;
	}

	@JsonProperty("amount")
	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@JsonProperty("totalAdmin")
	public Integer getTotalAdmin() {
		return totalAdmin;
	}

	@JsonProperty("totalAdmin")
	public void setTotalAdmin(Integer totalAdmin) {
		this.totalAdmin = totalAdmin;
	}

	@JsonProperty("productCode")
	public String getProductCode() {
		return productCode;
	}

	@JsonProperty("productCode")
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	@JsonProperty("productName")
	public String getProductName() {
		return productName;
	}

	@JsonProperty("productName")
	public void setProductName(String productName) {
		this.productName = productName;
	}

	@JsonProperty("category")
	public String getCategory() {
		return category;
	}

	@JsonProperty("category")
	public void setCategory(String category) {
		this.category = category;
	}

	@JsonProperty("token")
	public String getToken() {
		return token;
	}

	@JsonProperty("token")
	public void setToken(String token) {
		this.token = token;
	}

}