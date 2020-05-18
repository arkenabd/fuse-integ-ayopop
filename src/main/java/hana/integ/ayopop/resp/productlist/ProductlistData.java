package hana.integ.ayopop.resp.productlist;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "name", "description", "code", "logo", "amount", "adminFee", "biller", "category", "active",
		"type" })
public class ProductlistData {

	@JsonProperty("name")
	private String name;
	@JsonProperty("description")
	private String description;
	@JsonProperty("code")
	private String code;
	@JsonProperty("logo")
	private String logo;
	@JsonProperty("amount")
	private Integer amount;
	@JsonProperty("adminFee")
	private Integer adminFee;
	@JsonProperty("biller")
	private String biller;
	@JsonProperty("category")
	private String category;
	@JsonProperty("active")
	private Boolean active;
	@JsonProperty("type")
	private String type;

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty("code")
	public String getCode() {
		return code;
	}

	@JsonProperty("code")
	public void setCode(String code) {
		this.code = code;
	}

	@JsonProperty("logo")
	public String getLogo() {
		return logo;
	}

	@JsonProperty("logo")
	public void setLogo(String logo) {
		this.logo = logo;
	}

	@JsonProperty("amount")
	public Integer getAmount() {
		return amount;
	}

	@JsonProperty("amount")
	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@JsonProperty("adminFee")
	public Integer getAdminFee() {
		return adminFee;
	}

	@JsonProperty("adminFee")
	public void setAdminFee(Integer adminFee) {
		this.adminFee = adminFee;
	}

	@JsonProperty("biller")
	public String getBiller() {
		return biller;
	}

	@JsonProperty("biller")
	public void setBiller(String biller) {
		this.biller = biller;
	}

	@JsonProperty("category")
	public String getCategory() {
		return category;
	}

	@JsonProperty("category")
	public void setCategory(String category) {
		this.category = category;
	}

	@JsonProperty("active")
	public Boolean getActive() {
		return active;
	}

	@JsonProperty("active")
	public void setActive(Boolean active) {
		this.active = active;
	}

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

}