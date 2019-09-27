import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    void sync() {
    Controller controller=new Controller();
        Map<String, Object> clocks = controller.getTimeZone().getClocks();
        for (Map.Entry<String, Object> entry : clocks.entrySet()){
            String key = entry.getKey();
            Clock clock = (Clock)entry.getValue();
            int otherCityClockHour = clock.getLocalDateTime().getHour();
            int phoneClockHour = controller.getPhoneClock().getLocalDateTime().getHour();

            // 需要考虑一天中不同时间段的情况，不同时间段两个城市时钟之间的差值不同
            switch (key){
                case "Moscow":
                    assertEquals(phoneClockHour >= -TimeZone.MOSCOW ? TimeZone.MOSCOW : 24 + TimeZone.MOSCOW,
                            otherCityClockHour - phoneClockHour);
                    break;
                case "Sydney":
                    assertEquals(phoneClockHour >= 24 - TimeZone.SYDNEY ? TimeZone.SYDNEY - 24 : TimeZone.SYDNEY,
                            otherCityClockHour - phoneClockHour);
                    break;
                case "New York":
                    assertEquals(phoneClockHour >= -TimeZone.NEW_YORK ? TimeZone.NEW_YORK : 24 + TimeZone.NEW_YORK,
                            otherCityClockHour - phoneClockHour);
                    break;
                case "London":
                    assertEquals(phoneClockHour >= -TimeZone.LONDON ? TimeZone.LONDON : 24 + TimeZone.LONDON,
                            otherCityClockHour - phoneClockHour);
                    break;
                case "Beijing":
                    assertEquals(TimeZone.BEIJING,
                            otherCityClockHour - phoneClockHour);
                default:
                    break;
            }

        }
    }
}



