package de.ait.ss.validation.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Ошибки валидации")
public class ValidationErrorsDto {

    @Schema(description = "Список ошибок")
    private List<ValidationErrorDto> errors;
}
