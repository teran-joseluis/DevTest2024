package salesiana.university.dev.test.api.services.contracts;

import salesiana.university.dev.test.api.entities.Vote;
import salesiana.university.dev.test.api.mappers.requests.vote.CreateVoteRequest;
import salesiana.university.dev.test.api.mappers.responses.VoteResponse;

public interface IVoteService {
  VoteResponse saveVote(Long optionId, CreateVoteRequest vote);
}
