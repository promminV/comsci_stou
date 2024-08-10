package shopping_online_pv;
import java.time.*;

public class Shop {
	private String shopname;
	private String ownername;
	private String shopphone;
	private Product[] products;
	private Customer[] customers;
	private Transaction[] transactions; // adding
	private int pointer_products_index = 0; // adding
	private int pointer_customers_index = 0; // adding
	private int pointer_transactions_index = 0; // adding
	
	final static String DEFAULT_SHOPNAME = "default_shop";
	final static String DEFAULT_OWNERNAME = "default_owner";
	final static String DEFAULT_SHOPPHONE = "default_shopphone";
	// note: use static size array to follow the instruction (hashmap or arraylist are better)
	final static Product[] DEFAULT_PRODUCTS = new Product[5]; // allocates size = 5 as default
	final static Customer[]  DEFAULT_CUSTOMERS = new Customer[5]; // allocates size = 5 as default
	final static Transaction[] DEFAULT_TRANSACTIONS = new Transaction[5];   // allocates size = 5 as default
	
	Shop() {
		this.shopname = DEFAULT_SHOPNAME;
		this.ownername = DEFAULT_OWNERNAME;
		this.shopphone = DEFAULT_SHOPPHONE;
		this.products = DEFAULT_PRODUCTS; // give default size to products array
		this.customers = DEFAULT_CUSTOMERS; // give default size to customers array
		this.transactions = DEFAULT_TRANSACTIONS;
	}
	
	Shop(String shopname) {
		this.shopname = shopname;
		this.ownername = DEFAULT_OWNERNAME;
		this.shopphone = DEFAULT_SHOPPHONE;
		this.products = DEFAULT_PRODUCTS; // give default size to products array
		this.customers = DEFAULT_CUSTOMERS; // give default size to customers array
		this.transactions = DEFAULT_TRANSACTIONS;
	}
	
	void addCustomer(Customer customer) {
		// pointer_customers_index start 0, customers.length = 10 (index from 0-9)
			// length=10 -> end_index = 9; if pointer_customers_index <= 9 -> add /, else -> don't add X
		int end_index = this.customers.length-1;
		if (pointer_customers_index > end_index) {
			System.out.println("addCustomer() -> Cannot add the customer id: " + customer.getCustomerId() + " into customer array because it is full."
					+ "\nPlease set a new size to customer array by using setCustomerSize().");
		} else {
			this.customers[pointer_customers_index] = customer;
			pointer_customers_index += 1;
			System.out.println("addCustomer() -> The customer id: " + customer.getCustomerId() + " has been added successfully.");
		}
	}
	
	void addProduct(Product product) {
		int end_index = this.products.length-1;
		if (pointer_products_index > end_index) {
			System.out.println("addProduct() -> Cannot add the product id: " + product.getProductId() + " into product array because it is full." +
							"\nPlease set a new size to product array by using setProductSize().");
		} else {
			this.products[pointer_products_index] = product;
			pointer_products_index += 1;
			System.out.println("addProduct() -> The product id: " + product.getProductId() + " has been added successfully.");
		}
	}
	
	void addTransaction(Transaction transaction) {
		// if transaction array is full, create new array with double size from old one -> copy old one and paste into new array
		int end_index = this.transactions.length-1;
		if (pointer_transactions_index > end_index) {
			int old_size = this.transactions.length;
			Transaction[] new_transactions = new Transaction[old_size*2];
			System.arraycopy(this.transactions, 0, new_transactions, 0, old_size);
			this.transactions = new_transactions; // pointer this.transactions to a new created array 
			System.out.println("addTransaction() -> Current transaction array is full. " + 
								"Transaction array size has changed from " + old_size + " to " + this.transactions.length + ".");
		} 
		this.transactions[pointer_transactions_index] = transaction;
		pointer_transactions_index += 1;
		System.out.println("addTransaction() -> The transaction id: " + transaction.getTransactionId() + " has been created successfully.");
	}
	
	void buy(Customer customer, Product product, int amount) {
		if (amount > product.getProductStock()) {
			System.out.println("buy() -> Order cancelled. There are not enough products in stock.\n" +
								"In stock: " + product.getProductStock() + "\n" + 
								"Your amount : " + amount);
		} else if (amount <= 0) {
			System.out.println("buy() -> Order cancelled. Buying quantity must be at least 1.");
		} else {
			// update new transaction into transactions[]
			System.out.println("buy() -> Customer id: " + customer.getCustomerId() + " has bought product id:" + product.getProductId() + " quantity: " + amount + " successfully.");
			LocalDateTime buy_date = LocalDateTime.now();
			String t_id = "T" + String.valueOf(pointer_transactions_index + 1); // point to index 0, id = 1 , t_id = "T1"
			Transaction created_transaction = new Transaction(t_id, customer, product, amount, buy_date);
			addTransaction(created_transaction);
			// update change in quantity of stocks
			int remaining_stock = product.getProductStock() - amount;
			product.setProductStock(remaining_stock);
			System.out.println("setProductStock() -> Current quantity of stock has been updated.");
		}
	}
	
	void showTransaction() {
		for (int i=0; i<pointer_transactions_index; i++) {
			System.out.println(this.transactions[i]);
			System.out.println("- - - - - - - - - -");
		}
	}
	
	// additional method: : for showing customer in customers and product in products array
	void showCustomer() {
		for (int i=0; i<pointer_customers_index; i++) {
			System.out.println(this.customers[i]);
			System.out.println("- - - - - - - - - -");
		}
	}
	
	void showProduct() {
		for (int i=0; i<pointer_products_index; i++) {
			System.out.println(this.products[i]);
			System.out.println("- - - - - - - - - -");
		}
	}
		
	// additional method : setter
	void setShopname(String shopname) {
		this.shopname = shopname;
		System.out.println("setShopname() -> Set shop name to \"" + shopname + "\" successfully.");
	}
	
	void setOwnername(String ownername) {
		this.ownername = ownername;
		System.out.println("setOwnername() -> Set owner name to \"" + ownername + "\" successfully.");
	}
	
	void setShopphone(String shopphone) {
		this.shopphone = shopphone;
		System.out.println("setShopphone() -> Set shop phone to \"" + shopphone + "\" successfully.");
	}

	void setCustomerSize(int new_customers_size) { // allow users to customize size of customer array (static size)
		// not_null_count = 10, new_customer_size = 9 -> new size is not large enough
		int not_null_count = countNotNullElement(this.customers);
		if (new_customers_size < not_null_count) { // reject if new size from users is not enough to collect elements in old array
			System.out.println("setCustomerSize() -> Cannot change size of customer array to " + new_customers_size + " because it is smaller than number of existing elements (" + not_null_count + ").");
		} else if (new_customers_size == not_null_count) {
			System.out.println("setCustomerSize() ->No changes,  new size (" + new_customers_size + ") is equal to number of existing elements (" + not_null_count +").");

		} else {
			Customer[] new_customers = new Customer[new_customers_size];
			int old_cus_size = this.customers.length;
			System.arraycopy(this.customers, 0, new_customers, 0, this.customers.length);
			this.customers = new_customers;
			System.out.println("setCustomerSize() -> Change size of customer array complete. Old Size: " + old_cus_size + " Current Size: " + this.customers.length);
		}
	}
	
	void setProductSize(int new_products_size) { // allow users to customize size of product array (static size)
		int not_null_count = countNotNullElement(this.products);
		if (new_products_size < not_null_count) { // reject if new size from users is not enough to collect elements in old array
			System.out.println("setProductSize() -> Cannot change size of product array to " + new_products_size + " because it is smaller than number of existing elements (" + not_null_count + ").");
		} else if (new_products_size == not_null_count){
			System.out.println("setProductSize() ->No changes,  new size (" + new_products_size + ") is equal to number of existing elements (" + not_null_count +").");
		} else {
			Product[] new_products = new Product[new_products_size];
			int old_prod_size = this.products.length;
			System.arraycopy(this.products, 0, new_products, 0, this.products.length);
			this.products = new_products;
			System.out.println("setProductSize() -> Change size of product array complete. Old Size: " + old_prod_size + " Current Size: " + this.products.length);
		}
	}
	
	// additional method : count valid elements in array (not null element)
		// used to check before allow users to change the size of product and customer array
	private int countNotNullElement(Object[] array) {
		int not_null_count = 0;
		for (int i=0; i<array.length; i++) {
			if (array[i] != null) {
				not_null_count += 1;
			}
		}
		return not_null_count;
	}
	
	// additional (overriding) method for pretty printing when using println('object')
	@Override
	public String toString() {
		return 	"\tShop Name: " + this.shopname + "\n" +
				"\tOwner Name: " + this.ownername +"\n" +
				"\tShop Phone: " + this.shopphone;
	}

	
	// Testing  (if don't want to show this part, just comment it ...)
	public static void main(String[] args) {
		System.out.println("Testing constructor with non-parameter");
		// Testing non-parameter constructor
		Shop shop1 = new Shop();	
		System.out.println(shop1);
			// check initial size allocation in products, customers, transactions array of shop1
		System.out.println("Checking initial size of products, customers, transactions array when after using constructor");
		System.out.println("Size of products[] in shop1 (null included): " + shop1.products.length);
		System.out.println("Size of customers[] in shop1 (null included): " + shop1.customers.length);
		System.out.println("Size of transactions[] in shop1 (null included): " + shop1.transactions.length);
		shop1.showTransaction();
		System.out.println("---------------------------------------");
			// Test setter 
		System.out.println("Testing setter");
		System.out.println("setShopName()");
		shop1.setShopname("Prommin's Shop");
		System.out.println("- - - - - - - - - - - - - - -");
		
		System.out.println("setOwnername()");
		shop1.setOwnername("Prommin Vutivivatchai");
		System.out.println("- - - - - - - - - - - - - - -");

		System.out.println("setShopphone()");
		shop1.setShopphone("080-954-1527");
		System.out.println("- - - - - - - - - - - - - - -");

		System.out.println("Showing result after setting.."); 
		System.out.println(shop1);
		System.out.println("---------------------------------------");
		
		// Testing constructor with 'shopname' parameter
		System.out.println("Testing constructor with 'shopname' parameter");
		Shop shop2 = new Shop("ABC shop");
		System.out.println(shop2);
			// check initial size allocation in products, customers, transactions array of shop2
		System.out.println("Size of products[] in shop2 (null included): " + shop2.products.length);
		System.out.println("Size of customers[] in shop2 (null included): " + shop2.customers.length);
		System.out.println("Size of transactions[] in shop2 (null included): " + shop2.transactions.length);
		System.out.println("---------------------------------------");
		
		// Testing Product Method
		System.out.println("Testing product method....in shop1");
			// Testing addProduct(), showProduct()
		System.out.println("Testing addProduct(), showProduct()");
		System.out.println(shop1);
		Product product_test1 = new Product("P01", "product1", 20.00, 3);
		Product product_test2 = new Product("P02", "product2", 30.00, 4);
		Product product_test3 = new Product("P03", "product3", 45.50, 10);
		
		shop1.addProduct(product_test1);
		shop1.addProduct(product_test2);
		shop1.addProduct(product_test3);
		
		System.out.println("Products in shop1: ");
		shop1.showProduct();
		System.out.println("---------------------------------------");

			// Testing add a product element in arrays beyond the limit;
		System.out.println("Testing addProduct() to products[] beyond the limit (initial size = 5)");
		Product product_test4 = new Product("P04", "product4", 100.50, 45);
		Product product_test5 = new Product("P05", "product5", 97.25, 80);
		Product product_test6 = new Product("P06", "product6", 250.0, 100);
		
		shop1.addProduct(product_test4);
		shop1.addProduct(product_test5);
		shop1.addProduct(product_test6); // this product is beyond the limit of current size
		System.out.println("Showing that the product id 'P06'  is not added to the product array");
		shop1.showProduct();
		System.out.println("---------------------------------------");
			
			// Testing set new size to products array
		System.out.println("Testing set a new size value to the products array");
		shop1.setProductSize(7);
		System.out.println("- - - - - - - - - - - - - - - - - - - -");
		
			// trying to add product 'P06'
		System.out.println("Trying to add product 'P06' again");
		shop1.addProduct(product_test6);
			// showing all products
		System.out.println("Showing product items...");
		shop1.showProduct();
		System.out.println("---------------------------------------");
		
			// Testing inputs of setProductSize()
		System.out.println("Testing inputs of setProductSize(): ");
		System.out.println("Showing that cannot set a size of product array smaller than quantity of exsiting data");
		System.out.println("Quantity of existing data in product array = " + shop1.countNotNullElement(shop1.products)); // result = 6
		shop1.setProductSize(5); // will be rejected
		shop1.setProductSize(-1); // will be rejected
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		System.out.println("Showing that no changes if new size is equal to the number of existing elements");
		shop1.setProductSize(6);
		System.out.println("---------------------------------------");
		
		// Testing Customer Method
		System.out.println("Testing customer method.... in shop1");
			// Testing addCustomer(), showCustomer()
		System.out.println("Testing addCustomer(), showCustomer()");
		Customer customer1 = new Customer("N01", "Billy MM", "Paholyothin Rd., Bangkok, Thailand, 10401", "081-975-4456", "pbro345", "Asfr123@");
		Customer customer2 = new Customer("N02", "Prommin VV", "Rattanathibet Rd., Nonthaburi, Thailand, 11000", "080-954-1527", "pv1234", "asd2@879");
		Customer customer3 = new Customer("N03", "Piler Moore", "Sukumvit Rd., Bangkok, Thailand, 10540", "084-546-2112", "toppot123", "dsfa@F321");
		
		shop1.addCustomer(customer1);
		shop1.addCustomer(customer2);
		shop1.addCustomer(customer3);
		
		System.out.println("Customer members in shop1: ");
		shop1.showCustomer();
		System.out.println("---------------------------------------");

			// Testing add a customer element in arrays beyond the limit;
		System.out.println("Testing addCustomer() to customers[] beyond the limit (initial size = 5)");
		Customer customer4 = new Customer("N04", "Firstname4 Lastname4", "Address 4", "081-879-9152", "username4", "password4");
		Customer customer5 = new Customer("N05", "Firstname5 Lastname5", "Address 5", "065-989-4421", "username5", "password5");
		Customer customer6 = new Customer("N06", "Firstname6 Lastname6", "Address 6", "087-921-4563", "username6", "password6");
		
		shop1.addCustomer(customer4);
		shop1.addCustomer(customer5);
		shop1.addCustomer(customer6);
		System.out.println("Showing that the customer id 'C06'  is not added to the customer array");
		shop1.showCustomer();
		System.out.println("---------------------------------------");

			// Testing set new size to customers array
		System.out.println("Testing set a new size value to the customers array");
		shop1.setCustomerSize(7);
		System.out.println("- - - - - - - - - - - - - - - - - - - -");

			// trying to add customer 'N06'
		System.out.println("Trying to add customer 'N06' again");
		shop1.addCustomer(customer6);
			
			// showing all customers
		System.out.println("Showing all customers...");
		shop1.showCustomer();
		System.out.println("---------------------------------------");

			// Testing inputs of setCustomerSize()
		System.out.println("Testing inputs of setCustomer(): ");
		System.out.println("Showing that cannot set a size of customer array smaller than quantity of exsiting data");
		System.out.println("Quantity of existing data in customer array = " + shop1.countNotNullElement(shop1.customers)); // result = 6
		shop1.setCustomerSize(5); // will be rejected
		shop1.setCustomerSize(-1); // will be rejected
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		System.out.println("Showing that no changes if new size is equal to the number of existing elements");
		shop1.setCustomerSize(6);
		System.out.println("---------------------------------------");

		// Testing buy + transaction method
		System.out.println("Testing buy + transaction method");
			// Testing buy(), showTransaction()
		System.out.println("Testing buy(), showTransaction()");
		shop1.buy(customer1, product_test3, 2);
		System.out.println("Showing created transaction by showTransaction()");
		shop1.showTransaction();
		System.out.println("---------------------------------------");
			// Testing stock quantity verification : test case -> buy over quantity
		System.out.println("Testing stock quantity verification ");
		shop1.buy(customer2, product_test1, 5); // product_test1 quantity in stock = 3 -> buy = 5 -> reject
		System.out.println("---------------------------------------");
			// Testing users cannot buy a product with negative or zero quantity value
		System.out.println("Testing that negative or zero value of buying quantity will be cancelled");
		shop1.buy(customer3, product_test1, -5);
		shop1.buy(customer2, product_test3, 0);
		System.out.println("---------------------------------------");
			// Testing re-allocate size of transaction arrays function automatically when it is full.
				// buy until transaction array is full
		System.out.println("Testing re-allocate size of transaction arrays function automatically when it is full.");
		shop1.buy(customer1, product_test1, 2);
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		shop1.buy(customer4, product_test5, 6);
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		shop1.buy(customer3, product_test6, 3);
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		shop1.buy(customer2, product_test4, 3);
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		
		System.out.println("Current size of transaction array is " + shop1.transactions.length);
		System.out.println("Showing transaction...");
		shop1.showTransaction();
		
//		shop1.showProduct();
				// The next purchase will trigger a transaction that exceeds the size of the array.
		System.out.println("The next purchase will trigger a transaction that exceeds the size of the array.");
		shop1.buy(customer6, product_test1, 1);
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("Current size of transaction array is " + shop1.transactions.length);
		System.out.println("Showing transaction (new transaction has been added)...");
		shop1.showTransaction();	
	}
}
