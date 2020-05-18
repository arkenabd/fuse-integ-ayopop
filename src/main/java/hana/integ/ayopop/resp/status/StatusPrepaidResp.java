package hana.integ.ayopop.resp.status;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "responseCode", "success", "message", "data" })
public class StatusPrepaidResp {

	@JsonProperty("responseCode")
	private Integer responseCode;
	@JsonProperty("success")
	private Boolean success;
	@JsonProperty("message")
	private StatusMessagePrepaid message;
	@JsonProperty("data")
	private StatusDataPrepaid data;

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
	public StatusMessagePrepaid getMessage() {
		return message;
	}

	@JsonProperty("message")
	public void setMessage(StatusMessagePrepaid message) {
		this.message = message;
	}

	@JsonProperty("data")
	public StatusDataPrepaid getData() {
		return data;
	}

	@JsonProperty("data")
	public void setData(StatusDataPrepaid data) {
		this.data = data;
	}

}