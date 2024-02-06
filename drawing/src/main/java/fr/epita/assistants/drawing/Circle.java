package fr.epita.assistants.drawing;

import lombok.AllArgsConstructor;

public class Circle extends Entity{
    private int _radius;

    public Circle(int radius)
    {
        _radius = radius;
    }

    @Override
    public void draw() {
        for (int y = -_radius; y <= _radius; y++) {

            for (int x = -_radius; x <= _radius; x++) {

                double sqdist = Math.abs(_radius * _radius - (x * x + y * y));
                if (sqdist < _radius)
                    System.out.print("#");
                else
                    System.out.print(" ");

                if (x < _radius)
                    System.out.print(" ");
            }
            if (y < _radius)
                System.out.print("\n");
        }
    }
}
