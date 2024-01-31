import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static String BrightRed = "\u001b[31;1m";

    static String BrightGreen = "\u001b[32;1m";

    static String Black = "\u001b[30m";
    static String Red = "\u001b[31m";
    static String Green = "\u001b[32m";
    static String Yellow = "\u001b[33m";
    static String Blue = "\u001b[34m";
    static String Magenta = "\u001b[35m";
    static String Cyan = "\u001b[36m";
    static String White = "\u001b[37m";
    static String Reset = "\u001b[0m";
    static String BrightBlue = "\u001b[34;1m";
    static String BrightYellow = "\u001b[33;1m";
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(BrightYellow+"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+ Reset);
        System.out.println(BrightBlue+"                         Setting up Bus                          "+Reset);
        System.out.println(BrightYellow+"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+ Reset);
        System.out.print(BrightGreen+"Enter number of Bus: ");
        int number_of_bus = scanner.nextInt();
        System.out.print("Enter number Seat of bus: "+ Reset);
        int bus_seat = scanner.nextInt();
        int[][] bus_array = new int[number_of_bus][bus_seat];
        int options;

        do {
            System.out.println(BrightYellow+"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+ Reset);
            System.out.println(BrightBlue+"                         Bus Management System                          "+Reset);
            System.out.println(BrightYellow+"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+ Reset);
            System.out.println("1- Check Bus");
            System.out.println("2- Booking Bus");
            System.out.println("3- Cancel Booking");
            System.out.println("4- Reset Bus");
            System.out.println("5- Exit");
            System.out.println(BrightYellow+"--------------------"+Reset);
            System.out.print("-> Choose option (1-5): ");
            options = scanner.nextInt();

            switch (options) {
                case 1 -> Display(bus_array);
                case 2 -> Booking(bus_array);
                case 3 -> cancelBooking(bus_array);
                case 4 -> Reset(bus_array);
                case 5 -> System.out.println("Good bye!! See you later :)");

            }
        } while (options != 5);
    }

    static void DisplaySeat(int[][] busArray, int user_id_input) {
        System.out.println();
        System.out.printf(BrightYellow+"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++%n"+Reset);
        System.out.println(BrightYellow+"                   Display BUS Information                "+Reset);
        System.out.println(BrightYellow+"                         BUS ID: "+ user_id_input + "                "+Reset);
        System.out.printf(BrightYellow+"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++%n"+Reset);
        int available = 0, unavailable = 0;
        for (int j = 0; j < busArray[user_id_input - 1].length; j++) {
            if (j % 5 == 0) {
                System.out.println();
                System.out.printf(BrightBlue+"--------------------------------------------------------------%n"+Reset);
            }
//                busArray[i][j] = j+1;
            if (busArray[user_id_input - 1][j] == 0) {
                available++;
            }
            if (busArray[user_id_input - 1][j] == 1) {
                unavailable++;
            }
            System.out.print(busArray[user_id_input - 1][j] == 0 ? BrightGreen+"(+) " + (j + 1) + "\t\t" + Reset:  BrightRed+ "(-) " + (j + 1) + "\t\t"+ Reset);
        }
//            System.out.println("Bus array index"+user_id_input);
        System.out.println();
        System.out.printf(BrightBlue+"--------------------------------------------------------------%n"+Reset);
        System.out.println();
        System.out.println(BrightGreen + "( + ) : Available (" + available + ")" + Reset+"\t\t\t\t"+ BrightRed + "( - ) : Unavailable (" + unavailable + ")"+Reset);
        System.out.println();

    }
    // Not done
    static void PaginateDisplay(int[][] busArray, int user_id_input){
        Scanner scanner = new Scanner(System.in);
        int option;
        int start=0;
        int numberOfBus = 10;
        for(int j=start;j<busArray[user_id_input-1].length/numberOfBus;j++){
            if(j % 5 ==0){
                System.out.println();
            }
            System.out.print(busArray[user_id_input - 1][j] == 0 ? "(+) " + (j + 1) + "\t\t" : "(-) " + (j + 1) + "\t\t");
        }
        System.out.println();
        do{
            System.out.println("1. NEXT");
            option = scanner.nextInt();
            switch (option){
                case 1:
                    for(int j=start;j<busArray[user_id_input-1].length/numberOfBus;j++){
                        if(j % 5 ==0){
                            System.out.println();
                        }
                        System.out.print("j= "+ busArray[user_id_input-1].length/2 + " ");
                        System.out.print(busArray[user_id_input - 1][j] == 0 ? "(+) " + (j + 1) + "\t\t" : "(-) " + (j + 1) + "\t\t");
                    }
                    start += 10;
                    numberOfBus+= 10;
                    System.out.println(start);
                    System.out.println();
                    break;
                default:
                    break;
            }
        }while (option!=5);
    }


    static void Display(int[][] busArray) {
        System.out.println();
        System.out.printf(BrightYellow+"+++++++++++++++++++++++++++++++++++++++++++++%n"+Reset);
        System.out.printf("|         "+ Green + "Display All Bus Information"+ Reset+"           |%n");
        System.out.printf(BrightYellow+"+++++++++++++++++++++++++++++++++++++++++++++%n"+Reset);
//        System.out.println("ID\t\t\tSeat\t\t\tAvailable\t\t\tUnavailable");
        System.out.printf(BrightBlue+"| %-4s | %8s | %9s | %11s |%n"+Reset, "ID","SEAT","AVAILABLE","UNAVAILABLE");
        System.out.printf(BrightYellow+"+++++++++++++++++++++++++++++++++++++++++++++%n"+Reset);

        for (int i = 0; i < busArray.length; i++) {
            int available = 0, unavailable = 0;
            for (int j = 0; j < busArray[i].length; j++) {
                if (busArray[i][j] == 0) {
                    available++;
                }
                if (busArray[i][j] == 1) {
                    unavailable++;
                }
            }
//            System.out.println(i + 1 + "\t\t\t " + busArray[i].length + "\t\t\t\t\t" + available + "\t\t\t\t\t" + unavailable);
            System.out.printf(Cyan+"| %-4s |"+Blue+" %8s "+Reset +"|"+Green+ " %9s "+Reset+"|"+Magenta+ " %11s "+Reset+"|%n", i+1,busArray[i].length,available,unavailable);
        }
        System.out.printf(BrightYellow+"---------------------------------------------%n"+Reset);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 0 to back or BUS ID to see details: ");
        int choose_id = scanner.nextInt();
        switch (choose_id){
            case 0:
                break;
            default:
                DisplaySeat(busArray, choose_id);
        }
    }

    static void Booking(int[][] busArray) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter BUS ID between " + 1 + " to " + busArray[0].length + ": ");
        String user_id_input_string = scanner.nextLine();
        Pattern pattern = Pattern.compile("^[0-9]+$");
        Matcher matcher = pattern.matcher(user_id_input_string);
        boolean matchFound;
        do{
            matchFound= matcher.find();
            if(!matchFound){
                System.out.println(Red+ "Please input number only" +Reset);
                System.out.print("Enter BUS ID between " + 1 + " to " + busArray[0].length + ": ");
                user_id_input_string = scanner.nextLine();
                pattern = Pattern.compile("^[0-9]+$");
                matcher = pattern.matcher(user_id_input_string);
            }
        }while (!matchFound);
        int user_id_input = Integer.parseInt(user_id_input_string);

        boolean condition_book_full = false;

        DisplaySeat(busArray, user_id_input);
        System.out.print("Enter chair seat you want to booked: ");
        String chair_num_string = scanner.nextLine();
        Matcher matcher1 = pattern.matcher(chair_num_string);
        boolean matchFound1;
        do{
            matchFound1 = matcher1.find();
            if(!matchFound1){
                System.out.println(Red+ "Please input number only" +Reset);
                System.out.print("Enter chair seat you want to booked: ");
                chair_num_string = scanner.nextLine();
                matcher1 = pattern.matcher(chair_num_string);
            }
        }while (!matchFound1);
        int chair_num = Integer.parseInt(chair_num_string);

        while (busArray[user_id_input - 1][chair_num-1] != 0) {
            System.out.println(Red+ "Sorry, seat " + chair_num + " is already booked. Please choose another."+ Reset);
            System.out.print("Enter chair seat you want to booked: ");
            chair_num = scanner.nextInt();
        }
        System.out.print("Do you want to book chair number "+chair_num+" ? (y/n): ");
        String confirm_booking = String.valueOf(scanner.next().charAt(0));
        switch (confirm_booking){
            case "y":

                System.out.println(BrightGreen+ "Chair number " + chair_num + " was booked successfully!"+ Reset);
                busArray[user_id_input - 1][chair_num - 1] = 1;
                break;
            case "n":
                break;
        }
    }

    static void cancelBooking(int[][] busArray) {
        boolean condition_for_all_bus = false;
        for (int i = 0; i < busArray.length; i++) {
            for (int j = 0; j < busArray[i].length; j++) {
                if (busArray[i][j] == 1) {
                    condition_for_all_bus = true;
                    break;
                }
            }
        }
        if (!condition_for_all_bus) {
            System.out.println(Red + "There are no booking seat in all Buses to cancel. Please book a seat and try again later." + Reset);
        } else {

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter bus's ID: ");
            String input_id_string = scanner.nextLine();

            Pattern pattern = Pattern.compile("^[0-9]+$");
            Matcher matcher = pattern.matcher(input_id_string);
            boolean matchFound;
            do{
                matchFound = matcher.find();
                if(!matchFound){
                    System.out.println(Red+ "Please input number only" +Reset);
                    System.out.print("Enter bus's ID: ");
                    input_id_string = scanner.nextLine();
                    pattern = Pattern.compile("^[0-9]+$");
                    matcher = pattern.matcher(input_id_string);
                }
            }while (!matchFound);

            int input_id = Integer.parseInt(input_id_string);
            boolean condition_for_each_bus = false;
            do {
                if (input_id > busArray.length) {
                    System.out.println(Red + "Array out of bound!" + Reset);
                    break;
                }
                ;
                for (int j = 0; j < busArray[input_id - 1].length; j++) {
//                busArray[i][j] = j+1;
                    if (busArray[input_id - 1][j] == 1) {
                        condition_for_each_bus = true;
                        break;
                    }
                }
                ;
                if (!condition_for_each_bus) {
                    System.out.println(Red + "This bus ID " + input_id + " does not contain a booking seat. Please choose other one" + Reset);
                    System.out.print("Enter bus's ID: ");
                    input_id = scanner.nextInt();
                } else {
                    DisplaySeat(busArray, input_id);
                    System.out.print("Enter Seat number to cancel booking: ");
                    String cancel_seat_string = scanner.nextLine();

                    Matcher matcher1 = pattern.matcher(cancel_seat_string);
                    boolean matchFound1;
                    do{
                        matchFound1 = matcher1.find();
                        if(!matchFound1){
                            System.out.println(Red+ "Please input number only" +Reset);
                            System.out.print("Enter Seat number to cancel booking: ");
                            cancel_seat_string = scanner.nextLine();
                            matcher1 = pattern.matcher(cancel_seat_string);
                        }
                    }while (!matchFound1);

                    int cancel_seat = Integer.parseInt(cancel_seat_string);
                    while (busArray[input_id - 1][cancel_seat - 1] == 0) {
                        System.out.print("Enter Seat number to cancel booking: ");
                        cancel_seat = scanner.nextInt();
                        System.out.println(Red + "This seat have not booked yet" + Reset);
                    }
                    System.out.print(Yellow + "Do you want to cancel book chair number " + cancel_seat + "? (y/n): " + Reset);
                    String confirm_cancel = String.valueOf(scanner.next().charAt(0));
                    switch (confirm_cancel) {
                        case "y":
                            busArray[input_id - 1][cancel_seat - 1] = 0;
                            System.out.println(Magenta + "Seat number " + cancel_seat + " was canceled booking successfully" + Reset);
                            break;
                        case "n":
                            break;
                    }
                }
            }while (!condition_for_each_bus) ;
        }
    }
    static void Reset(int[][] busArray){

        boolean condition_all_bus = false;

        for(int i=0;i<busArray.length;i++){
            for(int j=0;j<busArray[i].length;j++){
                if(busArray[i][j] == 1){
                    condition_all_bus = true;
                }
            }
        }

        if(!condition_all_bus){
            System.out.println(Red+ "There are no booking seat in all Buses to reset. Please book a seat and try again later."+ Reset);
        }else{
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter bus's id to reset: ");
            int user_input_bus_id = scanner.nextInt();

            boolean condition = false;
            do{
                if(user_input_bus_id>busArray.length){
                    System.out.println(Red+ "Array out of bound!"+ Reset);
                    break;
                };

                for (int j = 0; j < busArray[user_input_bus_id - 1].length; j++) {
//                busArray[i][j] = j+1;
                    if (busArray[user_input_bus_id - 1][j] == 1) {
                        condition = true;
                        break;
                    }
                }

                if(!condition){
                    System.out.println(Red+ "Nothing to reset"+ Reset);
                    System.out.print("Enter bus's id to reset: ");
                    user_input_bus_id = scanner.nextInt();
                }else{
                    System.out.print(Yellow+ "Bus ID "+ user_input_bus_id + " was reset with all seats available? (y/n): "+ Reset);
                    String make_sure_to_reset = String.valueOf(scanner.next().charAt(0));
                    switch (make_sure_to_reset) {
                        case "y":
                            for(int i=0;i<busArray[user_input_bus_id].length;i++){
                                busArray[user_input_bus_id-1][i] = 0;
                            }
                            System.out.println(Green+ "Seat number " + (user_input_bus_id) + " was canceled booking successfully"+ Reset);
                            break;
                        case "n":
                            break;
                    }
                }
            }while(!condition);

        }

    }

}
