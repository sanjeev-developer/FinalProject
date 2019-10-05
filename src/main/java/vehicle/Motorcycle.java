package vehicle;

import com.lambton.iPrintable;
import org.json.simple.JSONObject;

public class Motorcycle extends Vehicle implements iPrintable
{


    JSONObject jsonObject;
    String model,yearOfMake;
    Boolean insurance;

    public Motorcycle(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
        super.make= (String) jsonObject.get("make");
        super.Plate = (String) jsonObject.get("plate");
        model = (String) jsonObject.get("model");
        insurance = (Boolean) jsonObject.get("insurance");
        yearOfMake = (String) jsonObject.get("year");
    }




    @Override
    public void display() {

        System.out.println("Has a " +jsonObject.get("type") );
        System.out.println("Manufacturer: " +make );
        System.out.println("Licence Plate : " +Plate);
        System.out.println("Model :" +model);
        System.out.println("Year Of Make : " +yearOfMake);
        if(insurance=true)
            System.out.println("Insurance : Yes");
        else
            System.out.println("Insurance : No");

        System.out.println("*********************************************************");

    }
}
