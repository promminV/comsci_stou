package shopping_online_pv;

public class Product {
	// additional attribute to set default value as constant in class-level
	private static final String DEFAULT_ID = "default_id";
	private static final String DEFAULT_NAME = "default_name";
	private static final double DEFAULT_PRICE = 0.0;
	private static final int DEFAULT_STOCK = 0;

	private String product_id;
	private String product_name;
	private double product_price;
	private int product_stockamnt;
	// constructor
		// if no parameter -> users need to set each value later by setter.
	Product() {
		this.product_id = DEFAULT_ID;
		this.product_name = DEFAULT_NAME;
		this.product_price = DEFAULT_PRICE;
		this.product_stockamnt = DEFAULT_STOCK;
	}
		// have parameters -> users set each value when create a product object 
	Product(String product_id, String product_name, double product_price, int product_stockamnt) {
		try {
			validatePrice(product_price);  // throw exception if input error
			this.product_price = product_price;

		} catch (IllegalArgumentException e) {
			 System.out.println("Invalid price: " + product_price + ", " + e.getMessage());
		}
		
		try {
			validateStock(product_stockamnt); // throw exception if input error
			this.product_stockamnt = product_stockamnt;


		} catch (IllegalArgumentException e) {
			 System.out.println("Invalid stock value: " + product_stockamnt + ", " + e.getMessage());
		}
		this.product_id = product_id;
		this.product_name = product_name;
	}
	// setter
	void setProductId(String product_id) {
		this.product_id = product_id;
	}
	void setProductName(String product_name) {
		this.product_name = product_name;
	}
	void setProductPrice(double product_price) {
		try {
			validatePrice(product_price);  // throw exception if input error
			this.product_price = product_price;

		} catch (IllegalArgumentException e) {
			 System.out.println("Invalid price: " + product_price + ", " + e.getMessage());
		}
	}
	void setProductStock(int product_stockamnt) {
		try {
			validateStock(product_stockamnt); // throw exception if input error
			this.product_stockamnt = product_stockamnt;

		} catch (IllegalArgumentException e) {
			 System.out.println("Invalid stock value: " + product_stockamnt + ", " + e.getMessage());
		}		
	}
	// getter
	String getProductId() {
		return this.product_id;
	}
	String getProductName() {
		return this.product_name;
	}
	double getProductPrice() {
		return this.product_price;
	}
	int getProductStock() {
		return this.product_stockamnt;
	}
	// additional method for checking input error in price and stock amount
	void validatePrice(double product_price) {
		if (product_price < 0) {
			throw new IllegalArgumentException("Price cannot be negative.");
		}
	}
	void validateStock(int product_stockamnt) {
		if (product_stockamnt < 0) {
			throw new IllegalArgumentException("Stock amount cannot be negative.");
		}
	}
	
	// additional (overriding) method for pretty printing when using println('object')
	@Override
	public String toString() {
		return 	"\tProduct ID: " + getProductId() + "\n" +
				"\tProduct Name: " + getProductName() +"\n" +
				"\tProduct Price: " + getProductPrice() + "\n" +
				"\tProduct Stock: " + getProductStock();
	}
	
	// ***Testing (if don't want to show this part, just comment it ...)
	public static void main(String[] args) {
		// test constructor with parameters 
		System.out.println("Testing constructor with parameters ");
		Product product_test1 = new Product("P01", "product1", 20.00, 3);
		System.out.println(product_test1);
		System.out.println("--------------------------------------------");

		// test constructor with non-parameters (setter testing included)
		System.out.println("Testing constructor with non-parameter");
		Product product_test2 = new Product();
		System.out.println(product_test2);
		System.out.println("--------------------------------------------");
			// test setter
		System.out.println("Testing constructor with non-parameter (after using setter)");
		product_test2.setProductId("P02");
		product_test2.setProductName("product2");
		product_test2.setProductPrice(15.0);
		product_test2.setProductStock(5);
		System.out.println(product_test2);
		System.out.println("--------------------------------------------");

		// test getter
		System.out.println("Testing getter");
		String get_product2_id = product_test2.getProductId();
		String get_product2_name = product_test2.getProductName();
		double get_product2_price = product_test2.getProductPrice();
		int get_product2_stock = product_test2.getProductStock();
		System.out.println(
				"get_product2_id = " + get_product2_id +
				"\nget_product2_name = " + get_product2_name +
				"\nget_product2_price = " + get_product2_price +
				"\nget_product2_stock = " + get_product2_stock
		);
		System.out.println("--------------------------------------------");
		
		// test input-error
			// in constuctor with parameters
		System.out.println("Test input-error in constructor with parameters");
		System.out.println("Test case 1: price < 0");
		Product product_test3 = new Product("P03", "product3", -20, 3);
		System.out.println(product_test3);
		System.out.println("Test case 2: stock < 0");
		Product product_test4 = new Product("P04", "product4", 20, -3);
		System.out.println(product_test4);
		System.out.println("--------------------------------------------");

		 	// in constructor with non-parameter (after using setter)
		System.out.println("Test input-error in constructor with non-parameter");
		Product product_test5 = new Product();
		System.out.println("Test case 1: price < 0");
		product_test5.setProductPrice(-10);
		System.out.println(product_test5);
		System.out.println("Test case 2: stock < 0");
		product_test5.setProductStock(-2);
		System.out.println(product_test5);
		System.out.println("--------------------------------------------");

	}
}
