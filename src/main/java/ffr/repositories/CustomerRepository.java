package ffr.repositories;

import org.springframework.data.repository.CrudRepository;

import ffr.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	Customer findByFirstName(String firstName);

}