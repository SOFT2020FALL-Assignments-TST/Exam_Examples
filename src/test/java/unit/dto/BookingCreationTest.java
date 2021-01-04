package unit.dto;

import dto.BookingCreation;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BookingCreationTest {

    @Test
    public void testBookingCreationDTO(){
        int customerId = 1;
        int employeeId = 1;
        Date date = new Date();
        Time start = new java.sql.Time(123456789999l);
        Time end = new java.sql.Time(123456789999l);

        BookingCreation b = new BookingCreation(customerId, employeeId, date, start, end);

        assertNotNull(b);
        assertEquals(b.getCustomerId(), customerId);
        assertEquals(b.getEmployeeId(), employeeId);
        assertEquals(b.getDate(), date);
        assertEquals(b.getStart(), start);
        assertEquals(b.getEnd(), end);
    }

}
