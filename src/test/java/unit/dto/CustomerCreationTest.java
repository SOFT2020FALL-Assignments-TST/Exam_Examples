package unit.dto;

import dto.CustomerCreation;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CustomerCreationTest {

    @Test
    public void testCustomerCreationDTO(){
        String firstName = "Morten";
        String lastName = "Feldt";
        Date birthDate = new Date();
        String phoneNumber = "+4512345";

        CustomerCreation c = new CustomerCreation(firstName, lastName, birthDate, phoneNumber);

        assertNotNull(c);
        assertEquals(c.getFirstname(), firstName);
        assertEquals(c.getLastname(), lastName);
        assertEquals(c.getBirthDate(), birthDate);
        assertEquals(c.getPhoneNumber(), phoneNumber);
    }

}
