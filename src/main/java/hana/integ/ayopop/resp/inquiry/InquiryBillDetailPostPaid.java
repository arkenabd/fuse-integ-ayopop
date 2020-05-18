package hana.integ.ayopop.resp.inquiry;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
"billId",
"billInfo",
"key",
"value"
})
public class InquiryBillDetailPostPaid {

@JsonProperty("billId")
private String billId;
@JsonProperty("billInfo")
private InquiryBillInfoPostPaid billInfo;
@JsonProperty("key")
private String key;
@JsonProperty("value")
private String value;

@JsonProperty("billId")
public String getBillId() {
return billId;
}

@JsonProperty("billId")
public void setBillId(String billId) {
this.billId = billId;
}

@JsonProperty("billInfo")
public InquiryBillInfoPostPaid getBillInfo() {
return billInfo;
}

@JsonProperty("billInfo")
public void setBillInfo(InquiryBillInfoPostPaid billInfo) {
this.billInfo = billInfo;
}

@JsonProperty("key")
public String getKey() {
return key;
}

@JsonProperty("key")
public void setKey(String key) {
this.key = key;
}

@JsonProperty("value")
public String getValue() {
return value;
}

@JsonProperty("value")
public void setValue(String value) {
this.value = value;
}

}