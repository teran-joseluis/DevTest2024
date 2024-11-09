package salesiana.university.dev.test.api.services.contracts;

import salesiana.university.dev.test.api.entities.Poll;
import salesiana.university.dev.test.api.mappers.requests.poll.CreatePollRequest;

import java.util.List;
import java.util.Optional;

public interface IPollService {
  List<Poll> findAllPolls();
  Poll savePoll(CreatePollRequest pollRequest);
}
