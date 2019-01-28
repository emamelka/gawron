package pl.emamelka.gawron.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "customers")
@Access(AccessType.FIELD)
@DynamicUpdate
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "gender", nullable = false)
    private String gender;

    public Customer() {
    }

    public Customer(String username, LocalDate dateOfBirth, String gender) {
        this.username = username;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public Customer(CustomerDto customerDto){
        this.username = customerDto.getUsername();
        this.dateOfBirth = customerDto.getDateOfBirth();
        this.gender = customerDto.getGender();
    }

    public void update(CustomerDto customerDto){
        if (customerDto.getUsername() != null){
            this.username = customerDto.getUsername();
        }
        if (customerDto.getDateOfBirth() != null){
            this.dateOfBirth = customerDto.getDateOfBirth();
        }
        if (customerDto.getGender() != null){
            this.gender = customerDto.getGender();
        }
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                '}';
    }
}
