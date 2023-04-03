package main.dto;

import lombok.Data;

@Data
public class SearchRequest {
    private String name;
    private String content;
    private String category;
}
