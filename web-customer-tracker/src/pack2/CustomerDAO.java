package pack2;

import java.util.List;


public interface CustomerDAO {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public void updateCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);
}
