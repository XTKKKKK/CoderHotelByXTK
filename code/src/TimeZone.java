import java.util.HashMap;
import java.util.Map;

public class TimeZone {

    public static int BEIJING = 0;
    public static int LONDON = -7;
    public static int MOSCOW = -5;
    public static int SYDNEY = 2;
    public static int NEW_YORK = -12;


    private Map<String, Object> clocks;

    public TimeZone() {
        clocks = new HashMap<>();

        clocks.put("Beijing", new Clock(BEIJING));
        clocks.put("London", new Clock(LONDON));
        clocks.put("Moscow", new Clock(MOSCOW));
        clocks.put("Sydney", new Clock(SYDNEY));
        clocks.put("New York", new Clock(NEW_YORK));

    }


    public Map<String, Object> getClocks() {
        return clocks;
    }


}
