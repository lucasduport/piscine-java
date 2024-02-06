package fr.epita.assistants.drawing;


import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class Entity implements IDrawable {
    @Getter private long id;
    private long SEQUENCE;
}
