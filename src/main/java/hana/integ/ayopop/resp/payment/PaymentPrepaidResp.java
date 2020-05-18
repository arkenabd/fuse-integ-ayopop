package hana.integ.ayopop.resp.payment;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "responseCode", "success", "message", "data" })
public class PaymentPrepaidResp {

	@JsonProperty("responseCode")
	private Integer responseCode;
	@JsonProperty("success")
	private Boolean success;
	@JsonProperty("message")
	private PaymentMessagePrepaid message;
	@JsonProperty("data")
	private PaymentDataPrepaid data;

	@JsonProperty("responseCode")
	public Integer getResponseCode() {
		return responseCode;
	}

	@JsonProperty("responseCode")
	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}

	@JsonProperty("success")
	public Boolean getSuccess() {
		return success;
	}

	@JsonProperty("success")
	public void setSuccess(Boolean success) {
		this.success = success;
	}

	@JsonProperty("message")
	public PaymentMessagePrepaid getMessage() {
		return message;
	}

	@JsonProperty("message")
	public void setMessage(PaymentMessagePrepaid message) {
		this.message = message;
	}

	@JsonProperty("data")
	public PaymentDataPrepaid getData() {
		return data;
	}

	@JsonProperty("data")
	public void setData(PaymentDataPrepaid data) {
		this.data = data;
	}

}