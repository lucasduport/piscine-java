package fr.epita.assistants.war;

public class Vehicle extends Combatant{

    protected String Name;
    protected int Defense;
    public Vehicle(String name, int defense)
    {
        this.Name = name;
        this.Defense = defense;
    }

    @Override
    public void scream()
    {
        System.out.println("I'm " + Name + "!");
    }

    @Override
    public void attack(Soldier s)
    {
        s.kill();
    }

    @Override
    public void attack(Vehicle v)
    {
        v.Defense /= 2;
    }

    public void printState()
    {
        System.out.println("I have " + this.Defense + " defense points.");
    }
}
