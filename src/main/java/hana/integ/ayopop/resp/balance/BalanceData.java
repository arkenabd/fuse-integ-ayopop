package hana.integ.ayopop.resp.balance;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "balance", "currency", "partnerId" })
public class BalanceData {

	@JsonProperty("balance")
	private Integer balance;
	@JsonProperty("currency")
	private String currency;
	@JsonProperty("partnerId")
	private String partnerId;

	@JsonProperty("balance")
	public Integer getBalance() {
		return balance;
	}

	@JsonProperty("balance")
	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	@JsonProperty("currency")
	public String getCurrency() {
		return currency;
	}

	@JsonProperty("currency")
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@JsonProperty("partnerId")
	public String getPartnerId() {
		return partnerId;
	}

	@JsonProperty("partnerId")
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

}