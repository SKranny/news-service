package main.dto;

import lombok.Data;
import main.constants.NewsCategory;

import javax.validation.constraints.NotBlank;

@Data
public class UpdateNewsRequest {
   @NotBlank
   private String content;
   @NotBlank
   private String name;
   @NotBlank
   private NewsCategory category;

}
