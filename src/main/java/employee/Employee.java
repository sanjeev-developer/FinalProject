package employee;

public abstract class Employee {

    String name;
     long age;
    int totalearning;

    public long calculatebirthyear( long i)
    {
        long x= 2019 - i;
        return x;
    }

    public double calculateearning()
    {

        return 1000;
    }
}
