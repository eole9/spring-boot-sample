package ffr.repositories;

import ffr.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    // Find by first name
    Customer findByFirstName(String firstName);

    // Find one by id
    @Override
    Customer findOne(Long aLong);
}