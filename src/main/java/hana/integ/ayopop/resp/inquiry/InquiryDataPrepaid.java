package hana.integ.ayopop.resp.inquiry;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "inquiryId", "accountNumber", "customerName", "productName", "productCode", "category", "amount",
		"totalAdmin", "processingFee", "validity", "customerDetail", "billDetails", "productDetails", "extraFields" })
public class InquiryDataPrepaid {

	@JsonProperty("inquiryId")
	private Integer inquiryId;
	@JsonProperty("accountNumber")
	private String accountNumber;
	@JsonProperty("customerName")
	private String customerName;
	@JsonProperty("productName")
	private String productName;
	@JsonProperty("productCode")
	private String productCode;
	@JsonProperty("category")
	private String category;
	@JsonProperty("amount")
	private Integer amount;
	@JsonProperty("totalAdmin")
	private Integer totalAdmin;
	@JsonProperty("validity")
	private String validity;
	@JsonProperty("customerDetail")
	private List<Object> customerDetail = null;
	@JsonProperty("billDetails")
	private List<Object> billDetails = null;
	@JsonProperty("productDetails")
	private List<Object> productDetails = null;
	@JsonProperty("extraFields")
	private List<Object> extraFields = null;

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

	@JsonProperty("customerName")
	public String getCustomerName() {
		return customerName;
	}

	@JsonProperty("customerName")
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@JsonProperty("productName")
	public String getProductName() {
		return productName;
	}

	@JsonProperty("productName")
	public void setProductName(String productName) {
		this.productName = productName;
	}

	@JsonProperty("productCode")
	public String getProductCode() {
		return productCode;
	}

	@JsonProperty("productCode")
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	@JsonProperty("category")
	public String getCategory() {
		return category;
	}

	@JsonProperty("category")
	public void setCategory(String category) {
		this.category = category;
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

	@JsonProperty("validity")
	public String getValidity() {
		return validity;
	}

	@JsonProperty("validity")
	public void setValidity(String validity) {
		this.validity = validity;
	}

	@JsonProperty("customerDetail")
	public List<Object> getCustomerDetail() {
		return customerDetail;
	}

	@JsonProperty("customerDetail")
	public void setCustomerDetail(List<Object> customerDetail) {
		this.customerDetail = customerDetail;
	}

	@JsonProperty("billDetails")
	public List<Object> getBillDetails() {
		return billDetails;
	}

	@JsonProperty("billDetails")
	public void setBillDetails(List<Object> billDetails) {
		this.billDetails = billDetails;
	}

	@JsonProperty("productDetails")
	public List<Object> getProductDetails() {
		return productDetails;
	}

	@JsonProperty("productDetails")
	public void setProductDetails(List<Object> productDetails) {
		this.productDetails = productDetails;
	}

	@JsonProperty("extraFields")
	public List<Object> getExtraFields() {
		return extraFields;
	}

	@JsonProperty("extraFields")
	public void setExtraFields(List<Object> extraFields) {
		this.extraFields = extraFields;
	}

}