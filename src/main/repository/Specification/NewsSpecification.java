package main.repository.Specification;

import main.model.News;
import org.springframework.data.jpa.domain.Specification;

public class NewsSpecification {
    public static Specification<News> LikeSearchedName(String searchedName) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), String.format("%%%s%%",searchedName)));
    }

    public static Specification<News> LikeSearchedContent(String searchedContent) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("content"), String.format("%%%s%%",searchedContent)));
    }

    public static Specification<News> LikeSearchedCategory(String searchedCategory) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("category"), String.format("%%%s%%",searchedCategory)));
    }
}
