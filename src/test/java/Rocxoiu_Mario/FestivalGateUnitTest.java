package Rocxoiu_Mario;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FestivalGateUnitTest {

    @Test
    public void testAddAndDrainTickets() {
        FestivalGate gate = new FestivalGate();
        gate.addTicket(TicketType.FULL);
        gate.addTicket(TicketType.ONE_DAY);

        List<TicketType> drained = gate.drainTickets();
        assertEquals(2, drained.size());
        assertTrue(drained.contains(TicketType.FULL));
        assertTrue(drained.contains(TicketType.ONE_DAY));

        assertFalse(gate.hasTickets());
    }
}