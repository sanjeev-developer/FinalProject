package vehicle;

import com.lambton.iPrintable;

public abstract class Vehicle implements iPrintable
{
        String make;
        String Plate;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getPlate() {
        return Plate;
    }

    public void setPlate(String plate) {
        Plate = plate;
    }


    @Override
    public void display() {
        System.out.println("Vehicle type");
    }
}
