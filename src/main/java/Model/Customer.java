package Model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer {

	private String cust_fName;

	private String cust_lName;

	private String cust_billingAddress;

	private String product_Name;

	private float product_price;

	private int product_Discount;

	private String product_info;

}
