package vehicle;

import com.lambton.iPrintable;
import org.json.simple.JSONObject;

public class Motorcycle extends Vehicle implements iPrintable
{


    JSONObject jsonObject;
    String model, make;
    Boolean insurance;

    public Motorcycle(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
        super.make= (String) jsonObject.get("make");
        super.Plate = (String) jsonObject.get("plate");
        model = (String) jsonObject.get("model");
        insurance = (Boolean) jsonObject.get("insurance");
    }




    @Override
    public void display() {
        System.out.println("Vehicle type :" +jsonObject.get("type") );
        System.out.println("Manufacturer: " + make );
        System.out.println("Licence Plate : " +Plate);
        System.out.println("Model :" +model);
        if(insurance=true)
            System.out.println("Insurance : Yes");
        else
            System.out.println("Insurance : No");

    }
}
