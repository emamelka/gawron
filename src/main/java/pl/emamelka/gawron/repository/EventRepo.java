package pl.emamelka.gawron.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.emamelka.gawron.model.Event;

@Repository
public interface EventRepo extends JpaRepository<Event, Integer> {

}
