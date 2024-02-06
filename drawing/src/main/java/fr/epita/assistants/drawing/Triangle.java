package fr.epita.assistants.drawing;

public class Triangle extends Sharp{
    public Triangle(int length) {
        super(length);
    }

    @Override
    public void draw() {
        for (int i = 1; i <= _length; i++) {
            for (int j = 1; j <= _length; j++) {
                if (j == 1 || i == _length || i == j) {
                    System.out.print("#");
                    if (i != j)
                        System.out.print(" ");
                }
                else {
                    System.out.print(" ");
                    if (j != _length)
                        System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }
}
