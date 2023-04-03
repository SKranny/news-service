package main.model;

import lombok.*;
import main.constants.NewsCategory;

import javax.persistence.*;
import java.time.ZonedDateTime;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;

    private String content;

    private ZonedDateTime dateOfPublication;

    @Enumerated(EnumType.STRING)
    private NewsCategory category;
}
