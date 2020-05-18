package hana.integ.ayopop.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "buyerEmail", "publicBuyerId" })
public class PaymentBuyerDetailsReq {

	@JsonProperty("buyerEmail")
	private String buyerEmail;
	@JsonProperty("publicBuyerId")
	private String publicBuyerId;

	@JsonProperty("buyerEmail")
	public String getBuyerEmail() {
		return buyerEmail;
	}

	@JsonProperty("buyerEmail")
	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}

	@JsonProperty("publicBuyerId")
	public String getPublicBuyerId() {
		return publicBuyerId;
	}

	@JsonProperty("publicBuyerId")
	public void setPublicBuyerId(String publicBuyerId) {
		this.publicBuyerId = publicBuyerId;
	}

}