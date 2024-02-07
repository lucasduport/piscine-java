package fr.epita.assistants.exceptions;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int age;
    private String major;

    public Student(String name, int age, String major) throws InvalidNameException, InvalidAgeException, InvalidMajorException {
        this.name = name;
        this.age = age;
        this.major = major.toUpperCase();
        List<String> majors = new ArrayList<>();
        majors.add("IMAGE");
        majors.add("GISTRE");
        majors.add("SRS");
        majors.add("SCIA");
        majors.add("MTI");
        majors.add("TCOM");
        majors.add("SIGL");
        majors.add("GITM");
        majors.add("ICE");
        majors.add("SANTE");
        majors.add("SSIE");
        majors.add("IF");
        majors.add("Q");

        if (name.contains("0123456789"))
            throw new InvalidNameException(name);
        if (age <= 0 || age >= 130)
            throw new InvalidAgeException(age);
        if (!majors.contains(major.toUpperCase()))
            throw new InvalidMajorException(major);

    }

    @Override
    public String toString()
    {
        return ("Name: " + this.name + ", Age: " + this.age + ", Major: " + this.major);
    }
}
