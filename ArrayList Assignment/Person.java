public class Person 
{
    private int myAge;
    private String myName;
    
    public Person(int myAge, String myName)
    {
        this.myAge = myAge;
        this.myName = myName;
    }

    public int getAge()
    {
        return myAge;
    }

    public String getName()
    {
        return myName;
    }
}
