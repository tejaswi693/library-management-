package com.crud.library.dto;

import com.crud.library.entity.Genre;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BookDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 6438792L;

    private Long Id;

    private String name;

    private Integer count;

    private Genre genre;
}
