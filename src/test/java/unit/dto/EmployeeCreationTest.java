package unit.dto;

import dto.EmployeeCreation;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EmployeeCreationTest {

    @Test
    public void testEmployeeCreationDTO(){
        String firstName = "Morten";
        String lastName = "Feldt";
        Date birthDate = new Date();

        EmployeeCreation e = new EmployeeCreation(firstName, lastName, birthDate);

        assertNotNull(e);
        assertEquals(e.getFirstname(), firstName);
        assertEquals(e.getLastname(), lastName);
        assertEquals(e.getBirthdate(), birthDate);
    }

}
