package main.service;

import lombok.RequiredArgsConstructor;
import main.dto.NewsDTO;
import main.dto.SearchRequest;
import main.dto.UpdateNewsRequest;
import main.mapper.NewsMapper;
import main.model.News;
import main.repository.NewsRepository;
import main.repository.Specification.NewsSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NewsService implements NewsServiceInterface {

    private final NewsRepository newsRepository;
    private final NewsMapper newsMapper;

    @Override
    public List<NewsDTO> getAllNews() {
        return newsRepository.findAll()
                .stream()
                .map(newsMapper::toNewsDto)
                .collect(Collectors.toList());
    }
    @Override
    public NewsDTO createNews(NewsDTO newsDTO) {
        return newsMapper.toNewsDto(newsRepository.save(newsMapper.toNews(newsDTO)));
    }
    @Override
    public List<NewsDTO> findByCategory(String category){
        return newsRepository.findAllByCategory(category).stream()
                .map(newsMapper::toNewsDto)
                .collect(Collectors.toList());
    }
    @Override
    public List<NewsDTO> findByName(String name){
        return newsRepository.findAllByName(name).stream()
                .map(newsMapper::toNewsDto)
                .collect(Collectors.toList());
    }
    @Override
    public void deleteNews(Long id){
        newsRepository.deleteById(id);
    }

    @Override
    public NewsDTO editNews(UpdateNewsRequest request, Long id) {
        return newsRepository.findById(id)
                .map(news -> update(news, request))
                .map(newsRepository::save)
                .map(newsMapper::toNewsDto)
                .orElseThrow(() -> new RuntimeException("Error! News not Found"));
    }

    @Override
    public List<NewsDTO> searchNews(SearchRequest request) {
        Specification<News> specification = Specification.where(null);
        if (request.getContent() != null){
            specification.and(NewsSpecification.LikeSearchedContent(request.getContent()));
        }
        if (request.getName()!= null){
            specification.and(NewsSpecification.LikeSearchedName(request.getName()));
        }
        if (request.getCategory() != null){
            specification.and(NewsSpecification.LikeSearchedCategory(request.getCategory()));
        }
        List<News> searchedNews = newsRepository.findAll(specification);
        return searchedNews.stream()
                .map(newsMapper::toNewsDto)
                .collect(Collectors.toList());
    }

    private News update(News news, UpdateNewsRequest request){
        news.setName(request.getName());
        news.setCategory(request.getCategory());
        news.setContent(request.getContent());
        return news;
    }
}
