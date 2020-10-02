
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Application {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int size = 2;
        ArrayList<User> userList = new ArrayList<>(size);
        for(int i = 0; i<size; i++){
            System.out.printf("Enter First Name for user%d: ",i+1);
            String firstname = input.next();
            System.out.printf("Enter Last Name for user%d: ",i+1);
            String lastname = input.next();
            System.out.printf("Enter Age for user%d: ",i+1);
            int age = input.nextInt();
            System.out.printf("Enter Email for user%d: ",i+1);
            String email = input.next();
            System.out.printf("Enter Status for user%d: ",i+1);
            String status = input.next();
            System.out.printf("Enter the Date for user%d in the format \"dd.mm.yyyy\": ",i+1);
            String date = input.next();
            userList.add(new User(firstname,lastname,age,email,status,date));
            System.out.println();
        }
        printUserList(userList); // display of entered data
        changeStatus(userList);
        printUserList(userList); // display modified data
    }

    public static void printUserList(ArrayList<User> userList){
        System.out.println();
        int i = 1;
        for(User users : userList){
            System.out.printf("User%d: ",i);
            System.out.println(users.toString());
            i++;
        }
    }

// This method change status to ACTIVE for NEW users
// whose timestamp when they were registered in the system is older than yesterday
// and pick up INACTIVE users that where registered more than 1 month ago and set their status to BLOCKED
    public static void changeStatus(ArrayList<User> userList){
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        Date currentDate = new Date();
        String s_date = formatter.format(currentDate);
        try {
            currentDate = formatter.parse(s_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long msDay = 24 * 60 * 60 * 1000;
        for(User users : userList){
            long msTimeDistance = currentDate.getTime() - users.getTimestamp().getTime();
            int dayCount = (int) (msTimeDistance/msDay);
            if(users.getStatus().equalsIgnoreCase("NEW")){
                if(dayCount>0) users.setStatus("ACTIVE");
            }
            if(users.getStatus().equalsIgnoreCase("INACTIVE")){
                if(dayCount>30) users.setStatus("BLOCKED");
            }
        }
    }
}
