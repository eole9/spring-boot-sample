package ffr.services;

import ffr.entities.Customer;
import ffr.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;

@Service("Customer")
public class CustomerServiceImpl implements CustomerService {

    @Resource
    CustomerRepository customerRepository;

    public CustomerRepository getPersonneRepository() {
        return customerRepository;
    }

    public void setPersonneRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Collection<Customer> getAllCustomers() {
        Collection<Customer> allCustomers = new ArrayList<Customer>();
        Iterable<Customer> customers = customerRepository.findAll();
        for (Customer customer : customers) {
            allCustomers.add(customer);
        }
        return allCustomers;
    }

    @Override
    public Customer getCustomerById(Long id) {
        Customer customer = customerRepository.findOne(id);
        return customer;
    }

    @Override
    public Customer getCustomerByFirstName(String firstName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

}
