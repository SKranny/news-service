package main.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.constants.NewsCategory;

import java.time.ZonedDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewsDTO {
    private Long id;
    private String name;

    private String content;

    private ZonedDateTime dateOfPublication;

    private NewsCategory newsCategory;
}
