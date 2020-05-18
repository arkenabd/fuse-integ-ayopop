package hana.integ.ayopop.resp.balance;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "responseCode", "success", "message", "data" })
public class BalanceResp {

	@JsonProperty("responseCode")
	private Integer responseCode;
	@JsonProperty("success")
	private Boolean success;
	@JsonProperty("message")
	private BalanceMessage message;
	@JsonProperty("data")
	private BalanceData data;

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
	public BalanceMessage getMessage() {
		return message;
	}

	@JsonProperty("message")
	public void setMessage(BalanceMessage message) {
		this.message = message;
	}

	@JsonProperty("data")
	public BalanceData getData() {
		return data;
	}

	@JsonProperty("data")
	public void setData(BalanceData data) {
		this.data = data;
	}

}