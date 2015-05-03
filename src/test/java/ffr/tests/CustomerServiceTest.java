package ffr.tests;

import ffr.app.Application;
import ffr.entities.Customer;
import ffr.services.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;

@SpringApplicationConfiguration(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerServiceTest {

    private static Logger log = LoggerFactory.getLogger(CustomerServiceTest.class);

    @Autowired
    private CustomerService customerService;

    @Test
    public void test() {
        // Add customer
        Customer customer = customerService.createCustomer(new Customer("Julien", "Lepers"));

        // Display customers
        Collection<Customer> customers = customerService.getAllCustomers();
        if (log.isInfoEnabled())
            log.info("Customers: " + customers);

        // Display one customer
        customer = customerService.getCustomerById(customer.getId());
        if (log.isInfoEnabled())
            log.info("Customer: " + customer);
    }

    /**
     * display
     *
     * @param message  Message prefix
     * @param elements Elements to display
     */
    private void display(String message, Iterable<?> elements) {
        System.out.println(message);
        for (Object element : elements) {
            System.out.println(element);
        }
    }
}
