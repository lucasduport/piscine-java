package fr.epita.assistants.mycompany;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Company {
    private String name;
    private List<Employee> employees;
    private HashMap<Employee, Manager> employeeManagement;

    public Company(String name) {
        this.name = name;
        employeeManagement = new HashMap<>();
        employees = new ArrayList<>();
    }

    public int size()
    {
        return employees.size();
    }

    public void hire(Employee p)
    {
        employees.add(p);
    }

    public void fire(Employee p)
    {
        employees.remove(p);
    }

    public void printEmployees()
    {
        System.out.println("The company " + this.name + " employs:");
        for (Employee e:this.employees
             ) {
            System.out.println("- "+ e);
        }
    }

    public boolean addEmployeeManagement(Employee e, Manager m)
    {
        if (!employees.contains(e))
            System.out.println(e + " is not employed by " + this.name + ".");
        if (!employees.contains(m))
            System.out.println(m + " is not employed by " + this.name + ".");
        if (!employees.contains(e) || !employees.contains(m))
            return false;
        if (employeeManagement.put(e,m) == null)
            System.out.println(e + " now has a manager.");
        else
            System.out.println(e + " has a new manager.");
        return true;
    }

    public void printManager(Employee e)
    {
        Manager m = employeeManagement.get(e);
        if (m == null)
            System.out.println(e + " is managed by nobody.");
        else
            System.out.println(m + " manages " + e + ".");
    }

    public void printEmployeesProject()
    {
        for (var e: employees) {
            if (e.getClass() == Manager.class || e.getClass() == Engineer.class)
                ((Assignable) e).listProjects();
        }
    }
}
