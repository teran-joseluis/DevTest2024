package salesiana.university.dev.test.api.mappers.requests.poll;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import salesiana.university.dev.test.api.entities.Option;

import java.util.List;

public record UpdatePollRequest(
        @NotBlank(message = "Poll name must not be empty")
        @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Poll name must only contain letters, numbers, and spaces.")
        String name,

        @NotEmpty(message = "Poll must have at least two options.")
        List<Option> options
) {
}
