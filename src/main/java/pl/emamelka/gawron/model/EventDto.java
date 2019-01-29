package pl.emamelka.gawron.model;

import io.swagger.models.auth.In;

import java.time.LocalDate;

public class EventDto {

    private String eventName;
    private String place;
    private Integer maxNumberOfSeats;
    private LocalDate startDate;

    public EventDto() {
    }

    public EventDto(String eventName, String place, int maxNumberOfSeats, LocalDate startDate) {
        this.eventName = eventName;
        this.place = place;
        this.maxNumberOfSeats = maxNumberOfSeats;
        this.startDate = startDate;
    }

    public EventDto(Event event){
        this.eventName = event.getEventName();
        this.place = event.getPlace();
        this.maxNumberOfSeats = event.getMaxNumberOfSeats();
        this.startDate = event.getStartDate();
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

    public Integer getMaxNumberOfSeats() {
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
}
