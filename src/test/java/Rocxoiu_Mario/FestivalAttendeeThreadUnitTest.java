package Rocxoiu_Mario;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FestivalAttendeeThreadUnitTest {

    @Test
    public void testAttendeeAddsTicketToGate() throws InterruptedException {
        FestivalGate gate = new FestivalGate();
        TicketType ticketType = TicketType.FULL_VIP;
        FestivalAttendeeThread attendee = new FestivalAttendeeThread(ticketType, gate);

        attendee.start();
        attendee.join();

        List<TicketType> tickets = gate.drainTickets();
        assertEquals(1, tickets.size());
        assertEquals(ticketType, tickets.get(0));
    }
}
