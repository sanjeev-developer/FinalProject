package employee;

import com.lambton.iPrintable;
import org.json.simple.JSONObject;
import vehicle.Car;
import vehicle.Motorcycle;

import java.text.DecimalFormat;

public class CommissionBasedPartTime extends PartTime implements iPrintable
{
    long commission;
            public double total;
    String s;
    JSONObject vehicle = new JSONObject();
    DecimalFormat chosenFormat = new DecimalFormat("#,###");

    public CommissionBasedPartTime(JSONObject jsonObject)
    {
        super.rate= (double) jsonObject.get("rate");
        super.hWorked=(long) jsonObject.get("hoursWorked");
        commission = (long) jsonObject.get("commissionPercent");
        s=(String) jsonObject.get("type");
        total=calculateearning();
        vehicle= (JSONObject) jsonObject.get("vehicle");
        if (vehicle == null) {
            System.out.println("Employee has no vehicle registered");
        }else {
            //creating object of appropriate class
            String vehicleName = (String) vehicle.get("@class");
            if (vehicleName.equalsIgnoreCase("motorcycle")) {
                Motorcycle m = new Motorcycle(vehicle);
                m.display();
            } else {
                Car c = new Car(vehicle);
                c.display();
            }
        }

    }

    @Override
    public void display() {

        System.out.println("Employee is:" +s);
        System.out.println("    Hourly Rate:" +rate);
        System.out.println("    Hours Worked:" +hWorked);
        System.out.println("    Earning:" +rate*hWorked);
        System.out.println("    Commission Percentage:" + commission + "%");
        System.out.println("    Commission Earned: $" +chosenFormat.format((rate*hWorked/100)*commission));
        System.out.println("    Total Earning: $" +chosenFormat.format(total) );
        System.out.println("******************************************************************");
    }

    @Override
    public double calculateearning()
    {
        double x,y;
        x=rate*hWorked;
        x=x+(x* commission /100);
        return x;
    }
}
