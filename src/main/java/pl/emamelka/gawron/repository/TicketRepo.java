package pl.emamelka.gawron.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.emamelka.gawron.model.Ticket;

import java.util.Optional;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Integer> {

    Optional<Ticket> getTicketById(Integer id);

}
