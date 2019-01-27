package pl.emamelka.gawron.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.emamelka.gawron.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {


}
