package fr.epita.assistants.drawing;


import lombok.Getter;
import lombok.NoArgsConstructor;

public class Entity implements IDrawable {
    @Getter private long id;
    private static long SEQUENCE;

    public Entity()
    {
        SEQUENCE++;
        id = SEQUENCE;
    }

    @Override
    public void draw() {

    }
}
