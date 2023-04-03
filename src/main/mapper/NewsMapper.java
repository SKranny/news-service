package main.mapper;

import main.dto.NewsDTO;
import main.model.News;
import org.mapstruct.Mapper;

@Mapper
public interface NewsMapper {
    NewsDTO toNewsDto(News news);

    News toNews(NewsDTO newsDTO);
}
