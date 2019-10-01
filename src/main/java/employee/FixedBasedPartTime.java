package employee;

public class FixedBasedPartTime extends PartTime{
    float fixedAmount;

    public double getFixedAmount() {
        return fixedAmount;
    }


    public float calcEarnings(float rate, float hoursWorked , float fixedAmount)
    {
        return(rate * hoursWorked) + fixedAmount;
    }
}
