package employee;

import com.lambton.iPrintable;
import org.json.simple.JSONObject;

public class Intern extends Employee implements iPrintable {

    String schoolname , eType;
    public double total;
    public int birthYear;

    public Intern(JSONObject jsonObject)
    {
        super.name= (String) jsonObject.get("name");
        super.age = (long) jsonObject.get("age");
        birthYear = super.calculatebirthyear((int) age);
        schoolname= (String) jsonObject.get("schoolName");
        eType= (String) jsonObject.get("type");
        total=calculateearning();

    }

    @Override
    public void display()
    {
        System.out.println("Employee is " +eType);
        //System.out.println("Birth year :" + birthYear);
        System.out.println("    School Name: " +schoolname);
        System.out.println("    Earnings :" + calculateearning());
        System.out.println("******************************************************************");

    }
}
