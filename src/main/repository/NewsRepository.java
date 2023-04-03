package main.repository;

import main.constants.NewsCategory;
import main.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long>, JpaSpecificationExecutor {
    List<News> findAllByCategory(String category);

    List<News> findAllByName(String name);

    List<News> findAllByContent(String content);
}
