package employee;

import com.lambton.iPrintable;
import org.json.simple.JSONObject;
import vehicle.Car;
import vehicle.Motorcycle;

import java.text.DecimalFormat;

public class FullTime extends Employee implements iPrintable {

    double salary,bonus;
    public double total;
    String s;
    JSONObject vehicle = new JSONObject();
    DecimalFormat chosenFormat = new DecimalFormat("#,###");


    public FullTime(JSONObject jsonObject){

        salary= (double) jsonObject.get("salary");
        bonus= (double) jsonObject.get("bonus");
        s=  (String) jsonObject.get("type");
        total= calculateearning();
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
    public void display()
    {

        System.out.println("Employee is " +s);
        System.out.println("    Salary:" +salary);
        System.out.println("    Bonus:" +bonus);
        System.out.println("    Total Earning: $" +chosenFormat.format(total));
        System.out.println("******************************************************************");
    }

    @Override
    public double calculateearning() {
        double x= (float) (salary+bonus);

        return x;
    }
}
