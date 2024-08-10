package shopping_online_pv;

public class Customer {
	// additional attribute to set default value as constant in class-level
	private static final String DEFAULT_ID = "default_id";
	private static final String DEFAULT_FULLNAME = "default_fullname";
	private static final String DEFAULT_ADDRESS = "default_address";
	private static final String DEFAULT_PHONE = "default_phone";
	private static final String DEFAULT_LOGINNAME = "default_login";
	private static final String DEFAULT_PASSWORD = "default_password";

	private String customer_id;
	private String customer_fullname;
	private String customer_address;
	private String customer_phone;
	private String customer_loginname;
	private String customer_password;
	// non-parameter constructor
	Customer() {
		this.customer_id = DEFAULT_ID;
		this.customer_fullname = DEFAULT_FULLNAME;
		this.customer_address = DEFAULT_ADDRESS;
		this.customer_phone = DEFAULT_PHONE;
		this.customer_loginname = DEFAULT_LOGINNAME;
		this.customer_password = DEFAULT_PASSWORD;
	}
	// constructor with parameters
	Customer(String customer_id, String customer_fullname,String customer_address,String customer_phone,
			String customer_loginname,String customer_password) {
		this.customer_id = customer_id;
		this.customer_fullname = customer_fullname;
		this.customer_address = customer_address;
		this.customer_phone = customer_phone;
		this.customer_loginname = customer_loginname;
		this.customer_password = customer_password;
	}
	// setter
	void setCustomerId(String customer_id) {
		this.customer_id = customer_id;
	}
	void setCustomerFullName(String customer_fullname) {
		this.customer_fullname = customer_fullname;
	}
	void setCustomerAddress(String customer_address) {
		this.customer_address = customer_address;
	}
	void setCustomerPhone(String customer_phone) {
		this.customer_phone = customer_phone;
	}
	void setCustomerLoginName(String customer_loginname) {
		this.customer_loginname = customer_loginname;
	}
	void setCustomerPassword(String customer_password) {
		this.customer_password = customer_password;
	}
	// getter
	String getCustomerId() {
		return this.customer_id;
	}
	String getCustomerFullName() {
		return this.customer_fullname;
	}
	String getCustomerAddress() {
		return this.customer_address;
	}
	String getCustomerPhone() {
		return this.customer_phone;
	}
	String getCustomerLoginName() {
		return this.customer_loginname;
	}
	String getCustomerPassword() {
		return this.customer_password;
	}
	// additional (overriding) method for pretty printing when using println('object')
		@Override
		public String toString() {
			return 	"\tCustomer ID: " + getCustomerId() + "\n" +
					"\tCustomer Full Name: " + getCustomerFullName() +"\n" +
					"\tCustomer Address: " + getCustomerAddress() + "\n" +
					"\tCustomer Phone: " + getCustomerPhone() + "\n" +
					"\tCustomer Login Name: " + getCustomerLoginName() + "\n" +
					"\tCustomer Password: " + getCustomerPassword();
		}
		
	// ***Testing (if don't want to show this part, just comment it ...)
	public static void main(String[] args) {
		// testing constructor with parameters
		System.out.println("Testing Constructor with Parameters");
		Customer customer1 = new Customer("N01", "Billy MM", "Paholyothin Rd., Bangkok, Thailand, 10401", "081-975-4456", "pbro345", "Asfr123@");
		System.out.println(customer1);
		System.out.println("----------------------------------------------------------");
		
		// testing non-parameter constructor
		System.out.println("Testing Constructor with Non-parameter");
		Customer customer2 = new Customer();
		System.out.println(customer2);
		System.out.println("----------------------------------------------------------");
			// testing setter
		System.out.println("Testing Constructor with Non-parameter (after using setter)");
		customer2.setCustomerId("N02");
		customer2.setCustomerFullName("Prommin Vutivivatchai");
		customer2.setCustomerAddress("Rattanathibet Rd., Nonthaburi, Thailand, 11000");
		customer2.setCustomerPhone("080-954-1527");
		customer2.setCustomerLoginName("prommin85");
		customer2.setCustomerPassword("Popopy_110201");
		System.out.println(customer2);
		System.out.println("----------------------------------------------------------");

		// test getter
		System.out.println("Testing getter");
		String get_customer2_id = customer2.getCustomerId();
		String get_customer2_name = customer2.getCustomerFullName();
		String get_customer2_addr = customer2.getCustomerAddress();
		String get_customer2_phone = customer2.getCustomerPhone();
		String get_customer2_loginname = customer2.getCustomerLoginName();
		String get_customer2_password = customer2.getCustomerPassword();

		System.out.println(
				"get_customer2_id = " + get_customer2_id +
				"\nget_customer2_name = " + get_customer2_name +
				"\nget_customer2_price = " + get_customer2_addr +
				"\nget_customer2_stock = " + get_customer2_phone +
				"\nget_customer2_loginname = " + get_customer2_loginname +
				"\nget_customer2_password = " + get_customer2_password
		);
		System.out.println("--------------------------------------------");
	}
}
