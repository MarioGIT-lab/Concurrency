package Rocxoiu_Mario;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class FestivalGate {
    private final Queue<TicketType> ticketQueue = new ConcurrentLinkedQueue<>();

    public void addTicket(TicketType ticketType) {
        ticketQueue.add(ticketType);
    }

    public List<TicketType> drainTickets() {
        List<TicketType> drained = new ArrayList<>();
        TicketType ticket;
        while ((ticket = ticketQueue.poll()) != null) {
            drained.add(ticket);
        }
        return drained;
    }

    public boolean hasTickets() {
        return !ticketQueue.isEmpty();
    }
}