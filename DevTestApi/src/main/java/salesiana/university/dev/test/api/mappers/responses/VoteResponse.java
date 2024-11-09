package salesiana.university.dev.test.api.mappers.responses;

public record VoteResponse(
        Long voteId,
        Long pollId,
        Long optionId,
        String voterEmail
) {
}
