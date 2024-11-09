package salesiana.university.dev.test.api.mappers.requests.option;

import jakarta.validation.constraints.NotBlank;

public record CreateOptionRequest(
        @NotBlank(message = "Poll option name must not be empty")
        String name
) {
}
