package shopping_online_pv;
import java.time.*;
import java.time.format.DateTimeFormatter;


public class Transaction {
	private static final String DEFAULT_TRANSACTION_ID = "default_id";
	private static final int DEFAULT_PRODUCT_AMNT = 0;
	
	private String transaction_id;
	private Customer customer;
	private Product product;
	private int product_amnt;
	private LocalDateTime date;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // formatting timestamp

	// non-parameter constructor
	Transaction() {
		this.transaction_id = DEFAULT_TRANSACTION_ID;
		this.customer = new Customer();
		this.product = new Product();
		this.date = LocalDateTime.now(); // set now timestamp as default value
		this.product_amnt = DEFAULT_PRODUCT_AMNT;
	}
	// constructor with parameters
	Transaction(String transaction_id, Customer customer, Product product, 
			int product_amnt, LocalDateTime date) {
		try {
			validateTransactionProductAmount(product_amnt);
			this.product_amnt = product_amnt;
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid product amount : " + product_amnt + ", " + e.getMessage());
		}
		this.transaction_id = transaction_id;
		this.customer = customer;
		this.product = product;
		this.date = date;

	}
	// setter
	void setTransactionId(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	void setTransactionCustomer(Customer customer) {
		this.customer = customer;
	}
	void setTransactionProduct(Product product) {
		this.product = product;
	}
	void setTransactionProductAmount(int product_amnt) {
		try {
			validateTransactionProductAmount(product_amnt);
			this.product_amnt = product_amnt;
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid product amount : " + product_amnt + ", " + e.getMessage());
		}
	}
	void setTransactionDate(LocalDateTime date) {
		this.date = date;
	}
	// getter
	String getTransactionId() {
		return this.transaction_id;
	}
	String getTransactionCustomer() {
		return this.customer.getCustomerId();
	}
	String getTransactionProduct() {
		return this.product.getProductId();
	}
	int getTransactionProductAmount() {
		return this.product_amnt;
	}
	String getTransactionDate() {
		return this.date.format(formatter);
	}
	// additional method for checking input error in price and stock amount
	void validateTransactionProductAmount(int product_amnt) {
		if (product_amnt < 0) {
			throw new IllegalArgumentException("Product amount cannot be negative.");
		}
	}
	// additional (overriding) method for pretty printing when using println('object')
	@Override
	public String toString() {
		return 	"Transaction ID: " + getTransactionId() + "\n" +
				"Transaction Customer: " +  this.customer.getCustomerId() +"\n" +
				"Transaction Product: " + this.product.getProductId() + "\n" +
				"Transaction Product Amount: " + getTransactionProductAmount() + "\n" +
				"Transaction Date: " + getTransactionDate();
	}
	
	// *** Testing (if don't want to show this part, just comment it ...)		
	public static void main(String[] args) {
		// test constructor with parameters 
		System.out.println("Testing constructor with parameters ");
		Customer customer_test1 = new Customer("N01", "Prommin V", "Nonthaburi, Thailand", "080-954-1527", "promminv", "PSdsafl@33");
		Product product_test1 = new Product("P01", "tester1", 24.50, 1000);
		LocalDateTime date_test1 = LocalDateTime.of(2023,12,20,15,30); // date = 20/12/2023 time = 15.30
		Transaction transaction1 = new Transaction("T01", customer_test1, product_test1, 20, date_test1);
		System.out.println(transaction1);
		System.out.println("--------------------------------------------");
		
		// test constructor with non-parameter
		System.out.println("Testing constructor with non-parameter");
		Transaction transaction2 = new Transaction();
		System.out.println(transaction2);
		System.out.println("--------------------------------------------");
		// test constructor with non-parameter (after using setter)
		System.out.println("Testing constructor with non-parameter (after using setter)");
		Customer customer_test2 = new Customer("N02", "Billy P", "Bangkok, Thailand", "081-987-5456", "bbppor", "sdfa@3sd3");
		Product product_test2 = new Product("P02", "tester2", 60.50, 10);
		LocalDateTime date_test2 = LocalDateTime.of(2023,12,21,10,30); // date = 20/12/2023 time = 15.30

		transaction2.setTransactionId("T02");
		transaction2.setTransactionCustomer(customer_test2);
		transaction2.setTransactionProduct(product_test2);
		transaction2.setTransactionProductAmount(5);
		transaction2.setTransactionDate(date_test2);

		System.out.println(transaction2);
		System.out.println("--------------------------------------------");
		
		// test getter
		System.out.println("Testing getter");
		String get_transaction2_id = transaction2.getTransactionId();
		String get_transaction2_customer = transaction2.getTransactionCustomer();
		String get_transaction2_product = transaction2.getTransactionProduct();
		int get_transaction2_product_amnt = transaction2.getTransactionProductAmount();
		String get_transaction2_date = transaction2.getTransactionDate();

		System.out.println(
				"get_transaction2_id = " + get_transaction2_id +
				"\nget_transaction2_customer = " + get_transaction2_customer +
				"\nget_transaction2_product = " + get_transaction2_product +
				"\nget_transaction2_product_amnt = " + get_transaction2_product_amnt +
				"\nget_transaction2_date = " + get_transaction2_date
		);
		
		System.out.println("--------------------------------------------");
		
		// test input-error
			// in constuctor with parameters
		System.out.println("Testing input-error in constructor with parameters");
		Transaction transaction3 = new Transaction("T03", customer_test1, product_test1, -20, date_test1);
		System.out.println(transaction3);
		System.out.println("--------------------------------------------");
			// in constructor with non-parameter (after using setter)
		System.out.println("Testing input-error in constructor with non-parameter");
		Transaction transaction4 = new Transaction();
		transaction4.setTransactionProductAmount(-10);
		System.out.println(transaction4);
		System.out.println("--------------------------------------------");

	}
}
