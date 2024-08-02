package com.learning.library_system.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private Integer id;

    @NotEmpty
    private String title;

    @Min(value = 10)
    private Integer pages;

    private boolean isAvailable;

    private LocalDate pubishedDate;

    private AuthorDto author;
}
