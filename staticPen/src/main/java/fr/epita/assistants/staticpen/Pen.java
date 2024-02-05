package fr.epita.assistants.staticpen;

public class Pen {
    public enum Color{
        RED,
        BLUE
    }

    static private  int reds;
    static private  int blues;

    static {
        reds = 0;
        blues = 0;
    }

    public Color _color;

    public Pen(final Color color) {
        _color = color;
        if (_color == Color.RED)
            reds++;
        if (_color == Color.BLUE)
            blues++;
    }

    public static int getRedPenCounter() {
        return reds;
    }

    public static int getPenCounter() {
        return getRedPenCounter() + getBluePenCounter();
    }

    public static int getBluePenCounter() {
        return blues;
    }

    public void changeColor(final Color color) {
        if (_color == Color.BLUE)
            blues--;
        else 
            reds--;
        _color = color;
        if (_color == Color.BLUE)
            blues++;
        else
            reds++;
        
    }

    public static void resetCounts() {
        blues = 0;
        reds = 0;
    }

    public void print() {
        System.out.print("I'm a ");
        if (_color == Color.RED)
            System.out.print("RED");
        if (_color == Color.BLUE)
            System.out.print("BLUE");
        System.out.println(" pen.");
    }
}
