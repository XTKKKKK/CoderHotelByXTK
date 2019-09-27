import java.time.LocalDateTime;


public class Clock {

    protected LocalDateTime localDateTime;
    protected int TimeDistinction;
    public Clock(int TimeDistinction) {
        this.TimeDistinction = TimeDistinction;
        this.localDateTime = LocalDateTime.now().plusHours(TimeDistinction);
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }



    public String toString() {
        return "Clock{" +
                "localDateTime=" + localDateTime +
                ", TimeDistinction=" + TimeDistinction +
                '}';
    }
}
