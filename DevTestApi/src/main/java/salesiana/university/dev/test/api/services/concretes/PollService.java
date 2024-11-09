package salesiana.university.dev.test.api.services.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import salesiana.university.dev.test.api.entities.Option;
import salesiana.university.dev.test.api.entities.Poll;
import salesiana.university.dev.test.api.exceptions.EmptyOptionException;
import salesiana.university.dev.test.api.mappers.requests.poll.CreatePollRequest;
import salesiana.university.dev.test.api.repositories.IPollRepository;
import salesiana.university.dev.test.api.services.contracts.IPollService;

import java.util.List;

@Service
public class PollService implements IPollService {
  private final IPollRepository pollRepository;
  private final OptionService optionService;

  @Autowired
  public PollService(IPollRepository pollRepository, OptionService optionService) {
    this.pollRepository = pollRepository;
    this.optionService = optionService;
  }

  @Override
  public List<Poll> findAllPolls() {
    return pollRepository.findAll();
  }

  @Override
  public Poll savePoll(CreatePollRequest pollRequest) {
    List<Option> createOptionRequest = optionService.findAllOptions();

    if (createOptionRequest.isEmpty()) {
      throw new EmptyOptionException("Poll must have at least two options.");
    }

    Poll poll = new Poll();
    poll.setName(pollRequest.name());
    poll.setOptions(createOptionRequest);

    Poll savedPoll = pollRepository.save(poll);

    return new Poll(
            savedPoll.getPollId(),
            savedPoll.getName(),
            savedPoll.getOptions()
    );
  }
}
