package employee;

import com.lambton.iPrintable;
import org.json.simple.JSONObject;

public class CommissionBasedPartTime extends PartTime implements iPrintable
{
    long commission;
            public double total;
    String s;
    public CommissionBasedPartTime(JSONObject jsonObject)
    {
        super.rate= (double) jsonObject.get("rate");
        super.hWorked=(long) jsonObject.get("hoursWorked");
        commission = (long) jsonObject.get("commissionPercent");
        s=(String) jsonObject.get("type");
        total=calculateearning();
    }

    @Override
    public void display() {

        System.out.println("Employee is:" +s);
        System.out.println("    Hourly Rate:" +rate);
        System.out.println("    Hours Worked:" +hWorked);
        System.out.println("    Earning:" +rate*hWorked);
        System.out.println("    Commission Percentage:" + commission + "%");
        System.out.println("    Commission Earned:" +(rate*hWorked/100)*commission);
        System.out.println("    Total Earning: " +total  );
        System.out.println("******************************************************************");
    }

    @Override
    public double calculateearning()
    {
        double x,y;
        x=rate*hWorked;
        x=x+(x* commission /100);
        return x;
    }
}
