package hana.integ.ayopop.resp.inquiry;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "ID", "EN" })
public class InquiryMessagePrepaid {

	@JsonProperty("ID")
	private String iD;
	@JsonProperty("EN")
	private String eN;

	@JsonProperty("ID")
	public String getID() {
		return iD;
	}

	@JsonProperty("ID")
	public void setID(String iD) {
		this.iD = iD;
	}

	@JsonProperty("EN")
	public String getEN() {
		return eN;
	}

	@JsonProperty("EN")
	public void setEN(String eN) {
		this.eN = eN;
	}

}