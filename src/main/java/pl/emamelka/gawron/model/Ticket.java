package pl.emamelka.gawron.model;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
@Access(AccessType.FIELD)
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "seat", nullable = false)
    private String seat;

    public Ticket() {
    }

    public Ticket(Customer customer, Event event, double price, String seat) {
        this.customer = customer;
        this.event = event;
        this.price = price;
        this.seat = seat;
    }

    public Integer getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Event getEvent() {
        return event;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                '}';
    }
}
