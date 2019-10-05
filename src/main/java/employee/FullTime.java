package employee;

import com.lambton.iPrintable;
import org.json.simple.JSONObject;

public class FullTime extends Employee implements iPrintable {

    double salary,bonus;
    public double total;
    String s;


    public FullTime(JSONObject jsonObject){

        salary= (double) jsonObject.get("salary");
        bonus= (double) jsonObject.get("bonus");
        s=  (String) jsonObject.get("type");
        total= calculateearning();

    }

    @Override
    public void display()
    {

        System.out.println("Employee is " +s);
        System.out.println("    Salary:" +salary);
        System.out.println("    Bonus:" +bonus);
        System.out.println("    Total Earning:" +total);
        System.out.println("******************************************************************");
    }

    @Override
    public double calculateearning() {
        double x= (float) (salary+bonus);

        return x;
    }
}
