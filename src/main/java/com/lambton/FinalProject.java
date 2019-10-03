package com.lambton;




import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FinalProject {

    public static void main(String args[])
    {
        File file = new File(FinalProject.class.getClassLoader().getResource("package.json").getFile());
        JSONParser jsonParser= new JSONParser();
        try(FileReader reader = new FileReader(file))
        {
            Object obj = jsonParser.parse(reader);

            JSONArray employee= (JSONArray) obj;
            System.out.println(employee);

            employee.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (ParseException e) {
            e.printStackTrace();
        }

    }
    private static void parseEmployeeObject(JSONObject employee)
    {
        //Get employee object within list
        JSONObject employeeObject = (JSONObject) employee.get("employee");

        //Get employee first name
        String firstName = (String) employeeObject.get("firstName");
        System.out.println(firstName);

        //Get employee last name
        String lastName = (String) employeeObject.get("HAS A " + employeeObject.get("@class"));
        System.out.println(lastName);

        //Get employee website name
        String website = (String) employeeObject.get("website");
        System.out.println(website);
    }

    }
