import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private final SimpleDateFormat FORMATTER = new SimpleDateFormat("dd.MM.yyyy");

    private String firstname;
    private String lastname;
    private int age;
    private String email;
    private String status;
    private Date timestamp;

    User(String firstname, String lastname, int age, String email, String status, String timestamp){
        setFirstname(firstname);
        setLastname(lastname);
        setAge(age);
        setEmail(email);
        setStatus(status);
        setTimestamp(timestamp);
    }

    public void setFirstname(String firstname){
        if(firstname.matches("^[a-zA-z]{1,50}$")) this.firstname = firstname;
    }

    public void setLastname(String lastname){
        if(lastname.matches("^[a-zA-z]{1,50}$")) this.lastname = lastname;
    }

    public void setAge(int age){
        if(age>0 && age<=100) this.age = age;
    }

    public void setEmail(String email){
        if(email.matches("^\\w{3,16}@[a-zA-z]{2,6}.[a-zA-z]{2,3}$")) this.email = email;
    }

    public void setStatus(String status){
        this.status = "NULL";
        if(status.equalsIgnoreCase("ACTIVE")) this.status = "ACTIVE";
        if(status.equalsIgnoreCase("INACTIVE")) this.status = "INACTIVE";
        if(status.equalsIgnoreCase("BLOCKED")) this.status = "BLOCKED";
        if(status.equalsIgnoreCase("NEW")) this.status = "NEW";
    }

    public void setTimestamp(String timestamp){
        try {
            this.timestamp = FORMATTER.parse(timestamp);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getStatus() {
        return status;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString(){
      return ("\nFirst Name: ")+getFirstname()+("\nLast Name: ")+getLastname()+("\nAge: ")+getAge()+("\nEmail: ")+getEmail()+("\nStatus: ")+getStatus()+("\nDate: ")+FORMATTER.format(getTimestamp());
    }
}
