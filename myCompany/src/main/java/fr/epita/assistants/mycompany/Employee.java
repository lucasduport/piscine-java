package fr.epita.assistants.mycompany;

public abstract class Employee {
    private String firstName;
    private String lastName;

    public Employee(String lastName, String firstName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString()
    {
        return this.lastName + " " + this.firstName;
    }

    public void sayMyName()
    {
        System.out.println("My name is " + this.toString() + ".");
    }

    public abstract void sayMyJob();
}
