package fr.epita.assistants.practicelombok;

import lombok.*;

@AllArgsConstructor
@Getter
@EqualsAndHashCode( of = { "name", "nickname"})
@ToString( of = {"name", "speed"})
public class Horse {
    @Setter private String name;
    @Setter private String nickname;
    private int speed;
}
