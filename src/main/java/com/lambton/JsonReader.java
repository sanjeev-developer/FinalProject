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



         double total;
        File file = new File(Objects.requireNonNull(FinalProject.class.getClassLoader().getResource("package.json")).getFile());
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(file)) {
            //storing object in JSON array
            Object obj = jsonParser.parse(reader);
            JSONArray employeeDetails = (JSONArray) obj;
            System.out.println(employeeDetails);

            //iterating for each object
            employeeDetails.forEach(vd -> parseEmployeeObject((JSONObject) vd));


        } catch (IOException | ParseException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.getMessage();
        }
    }

    private static void parseEmployeeObject(JSONObject employeeDetails) {
        //Get employee first name
        String firstName = (String) employeeDetails.get("name");
        System.out.println("Employee Name : " + firstName);

        //calculate birth year
        Intern i = new Intern(employeeDetails);
        System.out.println("Birth Year:" +i.birthYear);
        //Get employee vehicle details
        JSONObject vehicle = (JSONObject) employeeDetails.get("vehicle");
        if (vehicle == null) {
            System.out.println("Employee has no vehicle registered");
        }else {
            String vehicleName = (String) vehicle.get("@class");
            if (vehicleName.equalsIgnoreCase("motorcycle")) {
                Motorcycle m = new Motorcycle(vehicle);
                m.display();
            } else {
                Car c = new Car(vehicle);
                c.display();
            }
        }

        //get employee salary details
        String eType = (String) employeeDetails.get("type");
        if(eType.equalsIgnoreCase("intern")){
            Intern i1 = new Intern(employeeDetails);
            i.display();
        }
        if (eType.equalsIgnoreCase("fulltime")){
            FullTime f = new FullTime(employeeDetails);
            f.display();
        }

        if(eType.contains("Fixed")){
            FixedBasedPartTime fpt = new FixedBasedPartTime(employeeDetails);
            fpt.display();
        }

        if(eType.contains("Commissioned")){
            CommissionBasedPartTime cpt= new CommissionBasedPartTime(employeeDetails);
            cpt.display();
        }


    }



}
