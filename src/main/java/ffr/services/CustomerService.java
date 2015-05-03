package ffr.services;

import ffr.entities.Customer;

import java.util.Collection;

public interface CustomerService {

    Collection<Customer> getAllCustomers();

    Customer getCustomerById(Long id);

    Customer getCustomerByFirstName(String firstName);

    Customer createCustomer(Customer personne);

}
