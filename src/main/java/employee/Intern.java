package employee;

import com.lambton.iPrintable;
import org.json.simple.JSONObject;
import vehicle.Car;
import vehicle.Motorcycle;

public class Intern extends Employee implements iPrintable {

    String schoolname , eType;
    public double total;
    public int birthYear;
    JSONObject vehicle = new JSONObject();

    public Intern()
    {
        /*super.name= (String) jsonObject.get("name");
        super.age = (long) jsonObject.get("age");
        birthYear = super.calculatebirthyear((int) age);
        schoolname= (String) jsonObject.get("schoolName");
        eType= (String) jsonObject.get("type");
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
        }*/

    }

    public String getSchoolname()
    {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public String geteType() {
        return eType;
    }

    public void seteType(String eType) {
        this.eType = eType;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public JSONObject getVehicle() {
        return vehicle;
    }

    public void setVehicle(JSONObject vehicle) {
        this.vehicle = vehicle;
        vehicle= (JSONObject) vehicle.get("vehicle");
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
        System.out.println("Employee is " +eType);
        //System.out.println("Birth year :" + birthYear);
        System.out.println("    School Name: " +schoolname);
        System.out.println("    Earnings :" + calculateearning());
        System.out.println("******************************************************************");

    }
}
