package main.service;

import main.dto.NewsDTO;
import main.dto.SearchRequest;
import main.dto.UpdateNewsRequest;
import main.model.News;
import org.springframework.data.domain.Page;

import java.util.List;

public interface NewsServiceInterface {
    List<NewsDTO> getAllNews();
    NewsDTO createNews(NewsDTO newsDTO);
    List<NewsDTO> findByCategory(String category);
    List<NewsDTO> findByName(String name);
    void deleteNews(Long id);
    NewsDTO editNews(UpdateNewsRequest request, Long id);

    List<NewsDTO> searchNews(SearchRequest request);
}
