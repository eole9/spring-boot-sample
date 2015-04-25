package ffr.repositories;

import ffr.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findByFirstName(String firstName);

}