package com.lambton;

import employee.CommissionBasedPartTime;
import employee.FixedBasedPartTime;
import employee.FullTime;
import employee.Intern;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import vehicle.Car;
import vehicle.Motorcycle;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
public class JsonReader {

    public JsonReader() {



         double total =0;
        File file = new File(Objects.requireNonNull(FinalProject.class.getClassLoader().getResource("package.json")).getFile());
        System.out.println(file);

        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(file)) {

            //storing object in JSON array
            Object obj = jsonParser.parse(reader);
            JSONArray employeeDetails = (JSONArray) obj;

            //iterating for each object
            //employeeDetails.forEach(vd -> parseEmployeeObject((JSONObject) vd));

            for(int i = 0; i<employeeDetails.size();i++)
            {
                total=total+parseEmployeeObject((JSONObject) employeeDetails.get(i));

            }
            System.out.println("Total Payroll:" +total+ " Canadian Dollars");


        } catch (IOException | ParseException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.getMessage();
        }
    }

    private static double parseEmployeeObject(JSONObject employeeDetails) {

        double total = 0;
        //Get employee first name
        String firstName = (String) employeeDetails.get("name");
        System.out.println("Employee Name : " + firstName);

        //calculate birth year
       // Intern i = new Intern(employeeDetails);
        //System.out.println("Birth Year:" +i.birthYear);


        //Get employee vehicle details

        //getting vehicle object
        /*JSONObject vehicle = (JSONObject) employeeDetails.get("vehicle");
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

        //get employee salary details

        //check the type of employee
        String eType = (String) employeeDetails.get("type");

        //create class on the basis of the type of employee
        if(eType.equalsIgnoreCase("intern")){
            Intern i1 = new Intern();

            i1.seteType((String) employeeDetails.get("type"));
            i1.setSchoolname((String) employeeDetails.get("schoolName"));
            i1.setVehicle(employeeDetails);

            i1.display();
            total=total+i1.total;
        }
        if (eType.equalsIgnoreCase("fulltime")){
            FullTime f = new FullTime(employeeDetails);
            f.display();
            total=total+f.total;
        }
        if(eType.contains("Fixed")){
            FixedBasedPartTime fpt = new FixedBasedPartTime(employeeDetails);
            fpt.display();
            total=total+fpt.total;
        }

        if(eType.contains("Commissioned")){
            CommissionBasedPartTime cpt= new CommissionBasedPartTime(employeeDetails);
            cpt.display();
            total=total+cpt.total;
        }

    return total;
    }



}
