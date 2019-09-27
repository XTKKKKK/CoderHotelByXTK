
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Scanner;


public class UserPanel {

    private static Controller controller;

    public static void main(String[] args) {
        controller = new Controller();
        Scanner in = new Scanner(System.in);

        String input = " ";
        while (!input.equals("q")){
            input = PanelMenu(in);
        }
        System.out.println("System terminated succeeded!");
    }


    public static String PanelMenu(Scanner in){
        System.out.println("Choose one operation: ");
        System.out.println("1: Show the clock time");
        System.out.println("2: show the phone clock");
        System.out.println("3: show the all the clocks(included phone clock)");
        System.out.println("4: Synchronize the clocks");
        System.out.println("q: Exit");
        String option = in.next();
        System.out.println("======================================");
        switch (option){
            case "1":
                ShowClocks();
                break;
            case "2":
                ShowPhoneClock();
                break;
            case "3":
                ShowClocks();
                ShowPhoneClock();
                break;
            case "4":
                controller.sync();
                SucessInfo();
                break;
            case "q":
                break;
            default:
                ShowFailInfo();
                break;
        }
        System.out.println("======================================");

        return option;
    }

    public static void ShowClocks(){
        Map<String, Object> clocks = controller.getTimeZone().getClocks();
        for (Map.Entry<String, Object> entry : clocks.entrySet()){
            Clock clock = (Clock)entry.getValue();
            LocalDateTime localDateTime = clock.getLocalDateTime();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formatDate = localDateTime.format(formatter);
            System.out.println(entry.getKey() + ": " + formatDate);
        }
    }

    public static void ShowPhoneClock(){
        PhoneClock phoneClock = controller.getPhoneClock();
        LocalDateTime phoneDateTime = LocalDateTime.now();
        phoneClock.setLocalDateTime(phoneDateTime);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDate = phoneDateTime.format(formatter);
        System.out.println("Phone Clock: " + formatDate);
    }

    public static void ShowFailInfo(){
        System.out.println("INCORRECT INPUT");
    }


    public static void SucessInfo(){
        System.out.println("Synchronization succeeded!");
    }


}


