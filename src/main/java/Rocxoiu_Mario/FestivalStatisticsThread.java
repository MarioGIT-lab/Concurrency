package Rocxoiu_Mario;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

class FestivalStatisticsThread extends Thread {
    private final FestivalGate gate;
    private final Map<TicketType, AtomicInteger> ticketStats = new EnumMap<>(TicketType.class);

    public FestivalStatisticsThread(FestivalGate gate) {
        this.gate = gate;
        for (TicketType type : TicketType.values()) {
            ticketStats.put(type, new AtomicInteger(0));
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
                if (gate.hasTickets()) {
                    List<TicketType> newTickets = gate.drainTickets();
                    for (TicketType type : newTickets) {
                        ticketStats.get(type).incrementAndGet();
                    }
                    printStats();
                }
            } catch (InterruptedException e) {
                System.out.println("Statistics thread interrupted.");
                break;
            }
        }
    }

    private void printStats() {
        int total = ticketStats.values().stream().mapToInt(AtomicInteger::get).sum();
        System.out.println("\n--- Festival Statistics ---");
        System.out.println("Total attendees: " + total);
        for (TicketType type : TicketType.values()) {
            System.out.printf("%s: %d\n", type.name(), ticketStats.get(type).get());
        }
    }
}
