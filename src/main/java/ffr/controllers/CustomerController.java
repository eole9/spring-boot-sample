package ffr.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ffr.entities.Customer;
import ffr.services.CustomerService;

import java.util.Collection;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

	@Resource
	private CustomerService customerService;

	@RequestMapping(method = RequestMethod.POST)
	public void createCustomer(@RequestBody Customer customer) {

		customerService.createCustomer(customer);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Customer> getAllCustomers() {

		return customerService.getAllCustomers();
	}

}