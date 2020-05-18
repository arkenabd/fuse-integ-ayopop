package hana.integ.ayopop.req;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "partnerId", "refNumber" })
public class StatusReq {

	@JsonProperty("partnerId")
	private String partnerId;
	@JsonProperty("refNumber")
	private String refNumber;

	@JsonProperty("partnerId")
	public String getPartnerId() {
		return partnerId;
	}

	@JsonProperty("partnerId")
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	@JsonProperty("refNumber")
	public String getRefNumber() {
		return refNumber;
	}

	@JsonProperty("refNumber")
	public void setRefNumber(String refNumber) {
		this.refNumber = refNumber;
	}

	public StatusReq assignValue(String partnerId, String refNumber) {
		StatusReq jreq = new StatusReq();
		jreq.setPartnerId(partnerId.trim());
		jreq.setRefNumber(refNumber.trim());

		return jreq;
	}
}