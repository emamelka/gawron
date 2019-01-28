package pl.emamelka.gawron.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.emamelka.gawron.model.Ticket;
import pl.emamelka.gawron.repository.TicketRepo;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketRepo ticketRepo;

    @GetMapping(value = "/tickets", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Ticket> getTickets(){
        return ticketRepo.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void createTicket(@RequestBody Ticket ticket){
        ticketRepo.save(ticket);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void updateTicket(@RequestBody Ticket ticket){
        ticketRepo.save(ticket);
    }


}
