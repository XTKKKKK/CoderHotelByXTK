import java.time.LocalDateTime;
import java.util.Map;

public class PhoneClock extends Clock {

    public PhoneClock(){
        super(TimeZone.BEIJING);
    }



    public void sync(Map<String, Object> clocks){
        this.localDateTime = LocalDateTime.now();
        for (Map.Entry<String, Object> entry: clocks.entrySet()){
            String city = entry.getKey();
            Clock clock = (Clock)entry.getValue();
            switch (city) {
                case "Moscow":
                    clock.setLocalDateTime(this.localDateTime.plusHours(TimeZone.MOSCOW));
                    break;
                case "Sydney":
                    clock.setLocalDateTime(this.localDateTime.plusHours(TimeZone.SYDNEY));
                    break;
                case "New York":
                    clock.setLocalDateTime(this.localDateTime.plusHours(TimeZone.NEW_YORK));
                    break;
                case "London":
                    clock.setLocalDateTime(this.localDateTime.plusHours(TimeZone.LONDON));
                    break;
                case "Beijing":
                    clock.setLocalDateTime(this.localDateTime.plusHours(TimeZone.BEIJING));
                    break;
            }
        }
    }
}
