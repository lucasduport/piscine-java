package fr.epita.assistants.drawing;

public class Rectangle extends Sharp{
    private int _width;

    public Rectangle(int width, int length)
    {
        super(length);
        _width = width;
    }

    @Override
    public void draw()
    {
        for (int i = 1; i <= _length; i++) {
            for (int j = 1; j <= _width; j++) {
                if (j == 1 || j == _width || i == 1 || i == _length) {
                    System.out.print("#");
                    if (j != _width)
                        System.out.print(" ");
                }
                else {
                    System.out.print(" ");
                    if (j != _width)
                        System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }
}
