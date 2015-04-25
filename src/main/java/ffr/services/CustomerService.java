package ffr.services;

import java.util.Collection;

import ffr.entities.Customer;

public interface CustomerService {

	Collection<Customer> getAllCustomers();

	Customer getCustomerById(Long id);

	Customer getCustomerByFirstName(String firstName);

	void createCustomer(Customer personne);

}
