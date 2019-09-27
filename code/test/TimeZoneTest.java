import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class TimeZoneTest {

    @Test
    void getrightClocks() {
        TimeZone timeZone = new TimeZone();
        Map<String, Object> clocks = timeZone.getClocks();
        for (Map.Entry<String, Object> entry : clocks.entrySet()){
            String key = entry.getKey();
            Clock clock = (Clock) entry.getValue();
            switch (key){
                case "Moscow":
                    assertEquals(TimeZone.MOSCOW, clock.getTimeDistinction());
                    break;
                case "Sydney":
                    assertEquals(TimeZone.SYDNEY, clock.getTimeDistinction());
                    break;
                case "New York":
                    assertEquals(TimeZone.NEW_YORK, clock.getTimeDistinction());
                    break;
                case "London":
                    assertEquals(TimeZone.LONDON, clock.getTimeDistinction());
                    break;
                case "Beijing":
                    assertEquals(TimeZone.BEIJING, clock.getTimeDistinction());
                    break;
                default:
                    break;
            }
        }
    }
}
