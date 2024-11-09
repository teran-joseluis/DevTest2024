package salesiana.university.dev.test.api.services.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import salesiana.university.dev.test.api.entities.Option;
import salesiana.university.dev.test.api.entities.Vote;
import salesiana.university.dev.test.api.mappers.requests.vote.CreateVoteRequest;
import salesiana.university.dev.test.api.mappers.responses.VoteResponse;
import salesiana.university.dev.test.api.repositories.IVoteRepository;
import salesiana.university.dev.test.api.services.contracts.IVoteService;

import java.util.Optional;

@Service
public class VoteService implements IVoteService {
  private final IVoteRepository voteRepository;
  private final OptionService optionService;

  @Autowired
  public VoteService(IVoteRepository voteRepository, OptionService optionService) {
    this.voteRepository = voteRepository;
    this.optionService = optionService;
  }

  @Override
  public VoteResponse saveVote(Long optionId, CreateVoteRequest voteRequest) {
    Optional<Option> optionOptional = optionService.findOptionById(optionId);

    if (optionOptional.isEmpty()) {
      throw new RuntimeException("Option Id must be present");
    }

    Vote vote = new Vote();
    vote.setVoteId(voteRequest.optionId());
    vote.setVoterEmail(voteRequest.voterEmail());

    Vote savedVote = voteRepository.save(vote);

    return new VoteResponse(
            savedVote.getVoteId(),
            savedVote.getPoll().getPollId(),
            savedVote.getOption().getOptionId(),
            savedVote.getVoterEmail()
    );
  }
}
