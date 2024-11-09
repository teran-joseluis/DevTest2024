package salesiana.university.dev.test.api.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import salesiana.university.dev.test.api.entities.Poll;
import salesiana.university.dev.test.api.mappers.requests.poll.CreatePollRequest;
import salesiana.university.dev.test.api.services.concretes.PollService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/polls")
public class PollController {
  private final PollService pollService;

  @Autowired
  private PollController(PollService pollService) {
    this.pollService = pollService;
  }

  @GetMapping
  public ResponseEntity<List<Poll>> getAllPolls() {
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(pollService.findAllPolls());
  }

  @PostMapping
  public ResponseEntity<Poll> createPoll(@RequestBody @Valid CreatePollRequest poll) {
    return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(pollService.savePoll(poll));
  }
}
