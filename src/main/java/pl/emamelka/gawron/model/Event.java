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
    private int maxNumberOfSeats;

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
