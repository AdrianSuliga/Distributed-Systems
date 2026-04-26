package model;

import java.time.LocalDateTime;

public class PowerUsageRecord {

    private final LocalDateTime time;
    private final int consumption;

    public PowerUsageRecord(LocalDateTime time, int consumption) {
        this.time = time;
        this.consumption = consumption;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public int getConsumption() {
        return consumption;
    }
}