package employee;

import com.lambton.iPrintable;
import org.json.simple.JSONObject;
import vehicle.Car;
import vehicle.Motorcycle;

import java.text.DecimalFormat;

public class FixedBasedPartTime extends PartTime implements iPrintable {


    double fixed;
    public double total;
    String s;
    JSONObject vehicle = new JSONObject();
    DecimalFormat chosenFormat = new DecimalFormat("#,###");

    public double getFixed() {
        return fixed;
    }

    public void setFixed(double fixed) {
        this.fixed = fixed;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public JSONObject getVehicle() {
        return vehicle;
    }

    public void setVehicle(JSONObject vehicle) {
        this.vehicle = vehicle;
    }

    public FixedBasedPartTime(JSONObject jsonObject){
        super.rate= (double) jsonObject.get("rate");
        super.hWorked= (long) jsonObject.get("hoursWorked");
        fixed= (double) jsonObject.get("fixedAmount");
        total= calculateearning();
        s= (String) jsonObject.get("type");
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
        System.out.println("    Total Earning: $" +chosenFormat.format(total));
        System.out.println("******************************************************************");


    }
}
