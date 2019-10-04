package com.lambton;




import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import vehicle.Car;
import vehicle.Motorcycle;

//import org.json.JSONObject;
//import org.json.JSONArray;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class FinalProject {

    public static void main(String[] args)
    {

        //reading JSON from resources folder
        File file = new File(Objects.requireNonNull(FinalProject.class.getClassLoader().getResource("package.json")).getFile());
        JSONParser jsonParser= new JSONParser();
        try(FileReader reader = new FileReader(file))
        {
            //storing object in JSON array
            Object obj = jsonParser.parse(reader);
            JSONArray vehicleDetails = (JSONArray) obj;
            System.out.println(vehicleDetails);

            //iterating for each object
            vehicleDetails.forEach(vd -> parseEmployeeObject( (JSONObject) vd) );

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            e.getMessage();
        }

    }
    private static void parseEmployeeObject(JSONObject employeeVehicleDetails) {
        //Get employee first name
        String firstName = (String) employeeVehicleDetails.get("name");
        System.out.println(firstName);

        //Get employee vehicle details
        JSONObject vehicle= (JSONObject) employeeVehicleDetails.get("vehicle");
        if(vehicle == null)
            System.out.println("Has no vehicle");
        String vehicleName = (String) vehicle.get("@class");
        if(vehicleName.equalsIgnoreCase("motorcycle")) {
            Motorcycle m= new Motorcycle(vehicle);
            m.display();
        }else
        {
            Car c= new Car(vehicle);
            c.display();
        }

    }

    }
