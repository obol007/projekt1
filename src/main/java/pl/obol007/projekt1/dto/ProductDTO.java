package pl.obol007.projekt1.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


@Data @ToString
public class ProductDTO {

    Long id;

    @NotBlank
    String name;
    @NotBlank
    String category;
    @NotNull
    @Positive
    double price;
    @Positive
    Integer quantity;

    String description;

}
