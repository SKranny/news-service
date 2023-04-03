package main.controller;

import lombok.RequiredArgsConstructor;
import main.dto.NewsDTO;
import main.dto.SearchRequest;
import main.dto.UpdateNewsRequest;
import main.service.NewsServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/news")
public class NewsController {

    private final NewsServiceInterface newsService;

    @GetMapping
    public List<NewsDTO> getAllNews(){
        return newsService.getAllNews();
    }

    @PostMapping("/create")
    public NewsDTO creteNews(NewsDTO newsDTO){
        return newsService.createNews(newsDTO);
    }

    @DeleteMapping("/delete")
    public void deleteNews(Long id){
        newsService.deleteNews(id);
    }

    @PutMapping("/edit")
    public NewsDTO editNews(UpdateNewsRequest request, Long id){
        return newsService.editNews(request,id);
    }

    @GetMapping("/search")
    public Page<NewsDTO> search(SearchRequest request){
        return newsService.searchNews(request);
    }
}
