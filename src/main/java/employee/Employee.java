package employee;

public abstract class Employee {

    String name;
     long age;
    int totalearning;

    public int calculatebirthyear( int i)
    {
        int x= 2019 - i;
        return x;
    }

    public double calculateearning()
    {

        return 1000;
    }
}
