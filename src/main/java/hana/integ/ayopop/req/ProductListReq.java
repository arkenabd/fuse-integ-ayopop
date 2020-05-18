package hana.integ.ayopop.req;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "partnerId" })
public class ProductListReq {

	@JsonProperty("partnerId")
	private String partnerId;

	@JsonProperty("partnerId")
	public String getPartnerId() {
		return partnerId;
	}

	@JsonProperty("partnerId")
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public ProductListReq assignValue(String partnerId) {
		ProductListReq jreq = new ProductListReq();

		jreq.setPartnerId(partnerId.trim());
		return jreq;
	}

}