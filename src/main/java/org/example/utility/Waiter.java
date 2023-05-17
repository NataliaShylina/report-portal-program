package org.example.utility;

import static java.util.concurrent.TimeUnit.SECONDS;

public final class Waiter {

    private Waiter() {

    }

    public static void waitForLoading(int timesInSeconds) {
        try {
            SECONDS.sleep(timesInSeconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
