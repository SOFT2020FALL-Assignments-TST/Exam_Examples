package dto;

import java.util.Date;

public class CustomerCreation {

    private final String firstname;
    private final String lastname;
    private final Date birthDate;
    private final String phoneNumber;

    public CustomerCreation(String firstname, String lastname, Date birthDate, String phoneNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

}
