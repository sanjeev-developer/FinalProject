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


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }



    public Boolean getInsurance() {
        return insurance;
    }

    public void setInsurance(Boolean insurance) {
        this.insurance = insurance;
    }

    @Override
    public void display() {


    }
}
