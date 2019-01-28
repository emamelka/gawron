package pl.emamelka.gawron.model;

import java.time.LocalDate;

public class CustomerDto {

    private String username;
    private LocalDate dateOfBirth;
    private String gender;

    public CustomerDto() {
    }

    public CustomerDto(String username, LocalDate dateOfBirth, String gender) {
        this.username = username;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public CustomerDto(Customer customer){
        this.username = customer.getUsername();
        this.dateOfBirth = customer.getDateOfBirth();
        this.gender = customer.getGender();
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


}
