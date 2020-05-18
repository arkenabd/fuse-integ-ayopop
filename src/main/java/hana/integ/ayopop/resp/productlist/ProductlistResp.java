package hana.integ.ayopop.resp.productlist;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "responseCode", "success", "message", "data" })
public class ProductlistResp {

	@JsonProperty("responseCode")
	private Integer responseCode;
	@JsonProperty("success")
	private Boolean success;
	@JsonProperty("message")
	private ProductlistMessage message;
	@JsonProperty("data")
	private List<ProductlistData> data = null;

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
	public ProductlistMessage getMessage() {
		return message;
	}

	@JsonProperty("message")
	public void setMessage(ProductlistMessage message) {
		this.message = message;
	}

	@JsonProperty("data")
	public List<ProductlistData> getData() {
		return data;
	}

	@JsonProperty("data")
	public void setData(List<ProductlistData> data) {
		this.data = data;
	}

}