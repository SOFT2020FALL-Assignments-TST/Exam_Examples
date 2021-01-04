package unit.dto;

import dto.Booking;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class BookingTest {

    @Test
    public void testBookingDTO(){
        int id = 1;
        int customerId = 1;
        int employeeId = 1;
        Date date = new Date();
        Time start = new java.sql.Time(123456789999l);
        Time end = new java.sql.Time(123456789999l);

        Booking b = new Booking(id, customerId, employeeId, date, start, end);

        assertNotNull(b);
        assertEquals(b.getId(), id);
        assertEquals(b.getCustomerId(), customerId);
        assertEquals(b.getEmployeeId(), employeeId);
        assertEquals(b.getDate(), date);
        assertEquals(b.getStart(), start);
        assertEquals(b.getEnd(), end);
    }
}
