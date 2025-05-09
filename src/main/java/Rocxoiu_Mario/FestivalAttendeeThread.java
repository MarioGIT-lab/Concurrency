package Rocxoiu_Mario;
import java.util.Random;

class FestivalAttendeeThread extends Thread {
    private final TicketType ticketType;
    private final FestivalGate gate;

    public FestivalAttendeeThread(TicketType ticketType, FestivalGate gate) {
        this.ticketType = ticketType;
        this.gate = gate;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(300));
        } catch (InterruptedException ignored) {}
        gate.addTicket(ticketType);
    }
}