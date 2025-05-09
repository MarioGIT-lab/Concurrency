package Rocxoiu_Mario;

import java.util.Random;

public enum TicketType {
    FULL, FULL_VIP, FREE_PASS, ONE_DAY, ONE_DAY_VIP;

    private static final TicketType[] VALUES = values();
    private static final Random RANDOM = new Random();

    public static TicketType getRandomType() {
        return VALUES[RANDOM.nextInt(VALUES.length)];
    }
}
