package Rocxoiu_Mario;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class FestivalStatisticsThreadUnitTest {

    @Test
    public void testStatisticsThreadProcessesTickets() throws InterruptedException {
        FestivalGate gate = new FestivalGate();
        gate.addTicket(TicketType.FREE_PASS);
        gate.addTicket(TicketType.FULL_VIP);

        FestivalStatisticsThread statsThread = new FestivalStatisticsThread(gate);
        statsThread.setDaemon(true);
        statsThread.start();

        Thread.sleep(5500);

        assertFalse(gate.hasTickets());
    }
}
