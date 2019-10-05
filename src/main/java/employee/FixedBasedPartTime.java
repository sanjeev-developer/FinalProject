package employee;

import com.lambton.iPrintable;
import org.json.simple.JSONObject;

public class FixedBasedPartTime extends PartTime implements iPrintable {


    double fixed;
    public double total;
    String s;

    public FixedBasedPartTime(JSONObject jsonObject){
        super.rate= (double) jsonObject.get("rate");
        super.hWorked= (long) jsonObject.get("hoursWorked");
        fixed= (double) jsonObject.get("fixedAmount");
        total= calculateearning();
        s= (String) jsonObject.get("type");

    }

    @Override
    public double calculateearning() {
        double x;
        x= rate*hWorked;
        x=x+fixed;
        return x;
    }

    @Override
    public void display()
    {
        System.out.println("Employee is " +s);
        System.out.println("    Hourly Rate:" +rate);
        System.out.println("    Hours Worked:" +hWorked);
        System.out.println("    Fixed Amount:" +fixed);
        System.out.println("    Total Earning:" +total);
        System.out.println("******************************************************************");


    }
}
