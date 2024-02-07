package fr.epita.assistants.mycompany;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee implements Assignable{

    private List<String> projectNames;
    public Manager(String firstName, String lastName) {
        super(firstName, lastName);
        projectNames = new ArrayList<>();
    }

    @Override
    public void sayMyJob() {
        System.out.println(this + " is a manager.");
    }

    @Override
    public void addProject(String project) {
        if (!projectNames.contains(project))
            projectNames.add(project);
    }

    @Override
    public boolean hasProject(String project) {
        return projectNames.contains(project);
    }

    @Override
    public void listProjects() {
        System.out.println(this + "'s current projects are:");
        for (String s: projectNames
             ) {
            System.out.println("- " + s);
        }
    }
}
