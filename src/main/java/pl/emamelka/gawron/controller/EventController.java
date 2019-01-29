package pl.emamelka.gawron.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.emamelka.gawron.model.Event;
import pl.emamelka.gawron.model.EventDto;
import pl.emamelka.gawron.model.ExceptionMessage;
import pl.emamelka.gawron.repository.EventRepo;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventRepo eventRepo;

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EntityNotFoundException.class)
    public ExceptionMessage entityNotFoundException(){
        return new ExceptionMessage("Event not found.");
    }


    @GetMapping(value = "/events", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Event> getEvents(){
        return eventRepo.findAll();
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void createEvent(@RequestBody EventDto eventDto) {
        Event event = new Event(eventDto);
        eventRepo.save(event);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public EventDto getEvent(@PathVariable("id") Integer id){
       Event event = eventRepo.getOne(id);
       EventDto eventDto = new EventDto(event);
       return eventDto;
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @PatchMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void updateEvent(@PathVariable("id") Integer id, @RequestBody EventDto eventDto){
        Event event = eventRepo.getOne(id);
        event.update(eventDto);
        eventRepo.save(event);
    }
}
