package pl.emamelka.gawron.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "events")
@Access(AccessType.FIELD)
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "event_name", nullable = false)
    private String eventName;

    @Column(name = "place", nullable = false)
    private String place;

    @Column(name = "max_number_of_seats", nullable = false)
    private Integer maxNumberOfSeats;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    public Event(){
    }

    public Event(String eventName, String place, int maxNumberOfSeats, LocalDate startDate) {
        this.eventName = eventName;
        this.place = place;
        this.maxNumberOfSeats = maxNumberOfSeats;
        this.startDate = startDate;
    }

    public Event(EventDto eventDto){
        this.eventName = eventDto.getEventName();
        this.place = eventDto.getPlace();
        this.maxNumberOfSeats = eventDto.getMaxNumberOfSeats();
        this.startDate = eventDto.getStartDate();
    }

    public void update(EventDto eventDto){
        if (eventDto.getEventName() != null){
            this.eventName = eventDto.getEventName();
        }
        if (eventDto.getPlace() != null){
            this.place = eventDto.getPlace();
        }
        if (eventDto.getMaxNumberOfSeats() != null){
            this.maxNumberOfSeats = eventDto.getMaxNumberOfSeats();
        }
        if (eventDto.getStartDate() !=null){
            this.startDate = eventDto.getStartDate();
        }
    }

    public Integer getId() {
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getMaxNumberOfSeats() {
        return maxNumberOfSeats;
    }

    public void setMaxNumberOfSeats(int maxNumberOfSeats) {
        this.maxNumberOfSeats = maxNumberOfSeats;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                '}';
    }
}
