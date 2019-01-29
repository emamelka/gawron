package pl.emamelka.gawron.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.emamelka.gawron.exceptions.ValidationException;
import pl.emamelka.gawron.model.*;
import pl.emamelka.gawron.repository.CustomerRepo;
import pl.emamelka.gawron.repository.EventRepo;
import pl.emamelka.gawron.repository.TicketRepo;
import pl.emamelka.gawron.validator.TicketValidator;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketValidator ticketValidator;

    @Autowired
    private TicketRepo ticketRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private EventRepo eventRepo;

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public ExceptionMessage validationNotPassedException(ValidationException ex){
        return new ExceptionMessage(ex.getMessage());
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EntityNotFoundException.class)
    public ExceptionMessage entityNotFoundException(){
        return new ExceptionMessage("Ticket not found.");
    }

    @GetMapping(value = "/tickets", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Ticket> getTickets(){
        return ticketRepo.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Ticket getTicket(@PathVariable("id") Integer id){
        return ticketRepo.getTicketById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @PostMapping(value = "/buy", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void buyTicket(@RequestBody TicketDto ticketDto){
        ticketValidator.validateTicket(ticketDto);
        Customer customer = customerRepo.getOne(ticketDto.getCustomerId());
        Event event = eventRepo.getOne(ticketDto.getEventId());
        Ticket ticket = new Ticket(customer, event, ticketDto.getPrice(), ticketDto.getSeat());
        ticketRepo.save(ticket);
    }

}
