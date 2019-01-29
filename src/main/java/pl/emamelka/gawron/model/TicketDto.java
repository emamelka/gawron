package pl.emamelka.gawron.model;

public class TicketDto {

    private Integer customerId;
    private Integer eventId;
    private Integer price;
    private String seat;

    public TicketDto() {
    }

    public TicketDto(Integer customerId, Integer eventId, Integer price, String seat) {
        this.customerId = customerId;
        this.eventId = eventId;
        this.price = price;
        this.seat = seat;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }
}
