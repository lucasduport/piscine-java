package fr.epita.assistants.drawing;


import lombok.Getter;
import lombok.NoArgsConstructor;

public abstract class Entity implements IDrawable {
    @Getter private long id;
    private static long SEQUENCE = 0;

    public Entity()
    {
        id = SEQUENCE;
        SEQUENCE++;
    }

    @Override
    public void draw() {

    }
}
