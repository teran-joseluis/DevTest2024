package salesiana.university.dev.test.api.services.contracts;

import salesiana.university.dev.test.api.entities.Poll;

import java.util.List;
import java.util.Optional;

public interface IPollService {
  List<Poll> findAllPolls();
  Optional<Poll> findPollById(Long pollId);
  Poll savePoll(Poll poll);
  Poll updatePoll(Long pollId, Poll poll);
  boolean deletePoll(Long pollId);
}
