package hana.integ.ayopop.resp.inquiry;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "responseCode", "success", "message", "data" })
public class InquiryPrepaidResp {

	@JsonProperty("responseCode")
	private Integer responseCode;
	@JsonProperty("success")
	private Boolean success;
	@JsonProperty("message")
	private InquiryMessagePrepaid message;
	@JsonProperty("data")
	private InquiryDataPrepaid data;

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
	public InquiryMessagePrepaid getMessage() {
		return message;
	}

	@JsonProperty("message")
	public void setMessage(InquiryMessagePrepaid message) {
		this.message = message;
	}

	@JsonProperty("data")
	public InquiryDataPrepaid getData() {
		return data;
	}

	@JsonProperty("data")
	public void setData(InquiryDataPrepaid data) {
		this.data = data;
	}

}