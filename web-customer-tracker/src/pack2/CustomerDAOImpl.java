package pack2;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class CustomerDAOImpl implements CustomerDAO {
//	inject session factory
	@Autowired
	private SessionFactory f;
	
	@Override
	public List<Customer> getCustomers() {
//		get hibernate session
		Session s = f.getCurrentSession(); 
		
//		create query
		Query<Customer> q1 = s.createQuery("from Customer order by firstName",Customer.class);
		
//		get customers list
		List<Customer> customers = q1.getResultList();
		
//		return customers list
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
//		get hibernate session
		Session s = f.getCurrentSession(); 
		
		s.save(theCustomer);
	}

}
