package pl.emamelka.gawron.controller;

import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.emamelka.gawron.model.Event;
import pl.emamelka.gawron.repository.EventRepo;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventRepo eventRepo;

    @GetMapping(value = "/events", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Event> getEvents(){
        return eventRepo.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void createEvent(@RequestBody Event event){
        eventRepo.save(event);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Event getEvent(@PathVariable("id") Integer id){
        return eventRepo.findById(id).orElse(null);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteEvent(@PathVariable("id") Integer id){
        eventRepo.deleteById(id);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void updateEvent(@RequestBody Event event){
        eventRepo.save(event);
    }
}
