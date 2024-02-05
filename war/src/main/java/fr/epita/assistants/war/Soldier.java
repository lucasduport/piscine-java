package fr.epita.assistants.war;

public class Soldier extends Combatant{
    protected int hp;
    protected int dp;
    protected String scream;

    public Soldier() {
        this.hp = 15;
        this.dp = 3;
        this.scream = "No pity for losers!";
    }

    public void kill()
    {
        this.hp = 0;
    }

    @Override
    public void scream()
    {
        System.out.println(scream);
    }

    @Override
    public void attack(Soldier s)
    {
        s.hp -= this.dp;
    }

    @Override
    public void attack(Vehicle v)
    {
        System.out.println("I can't fight this");
    }

    public void printState()
    {
        System.out.println("I have " + this.hp + " health points.");
    }
}
