package salesiana.university.dev.test.api.services.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import salesiana.university.dev.test.api.entities.Poll;
import salesiana.university.dev.test.api.repositories.IPollRepository;
import salesiana.university.dev.test.api.services.contracts.IPollService;

import java.util.List;
import java.util.Optional;

@Service
public class PollService implements IPollService {
  private final IPollRepository pollRepository;

  @Autowired
  public PollService(IPollRepository pollRepository) {
    this.pollRepository = pollRepository;
  }

  @Override
  public List<Poll> findAllPolls() {
    return pollRepository.findAll();
  }

  @Override
  public Optional<Poll> findPollById(Long pollId) {
    return pollRepository.findById(pollId);
  }

  @Override
  public Poll savePoll(Poll poll) {
    return pollRepository.save(poll);
  }

  @Override
  public Poll updatePoll(Long pollId, Poll poll) {
    return pollRepository.save(poll);
  }

  @Override
  public boolean deletePoll(Long pollId) {
    return false;
  }
}
