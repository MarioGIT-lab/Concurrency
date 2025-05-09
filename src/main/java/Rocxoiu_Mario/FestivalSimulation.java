package Rocxoiu_Mario;

public class FestivalSimulation {
    public static void main(String[] args) {
        FestivalGate gate = new FestivalGate();
        FestivalStatisticsThread statsThread = new FestivalStatisticsThread(gate);
        statsThread.start();

        for (int i = 0; i < 150; i++) {
            TicketType ticketType = TicketType.getRandomType();
            new FestivalAttendeeThread(ticketType, gate).start();
        }
    }
}
