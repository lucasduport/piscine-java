package fr.epita.assistants.practicelombok;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode( of = { "name", "nickname"})
@ToString
public class Horse {
    private String name;
    private String nickname;
    private int speed;
}
