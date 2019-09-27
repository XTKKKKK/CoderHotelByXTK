import java.time.LocalDateTime;


public class Controller {

    private TimeZone timeZone;

    private PhoneClock phoneClock;

    public Controller(){
        this.timeZone = new TimeZone();
        this.phoneClock = new PhoneClock();
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public PhoneClock getPhoneClock(){
        LocalDateTime currentPhoneTime = LocalDateTime.now();
        phoneClock.setLocalDateTime(currentPhoneTime);
        return phoneClock;
    }

    public void sync(){
        phoneClock.sync(timeZone.getClocks());
    }




}
