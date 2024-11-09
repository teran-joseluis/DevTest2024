package salesiana.university.dev.test.api.mappers.requests.vote;

import jakarta.validation.constraints.Email;

public record CreateVoteRequest(
        Long optionId,

        @Email(message = "VoterEmail must be a valid email address.")
        String voterEmail
) {
}
