package fr.epita.assistants.mycompany;

import java.util.Objects;

public class Engineer extends Employee implements Assignable{

    private String projectName = null;
    public Engineer(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public void sayMyJob() {
        System.out.println(this + " is an engineer.");
    }

    @Override
    public void addProject(String project) {
        projectName = project;
    }

    @Override
    public boolean hasProject(String project) {
        return Objects.equals(projectName, project);
    }

    @Override
    public void listProjects() {
        System.out.println(this + "'s current project is " + projectName + ".");
    }
}
