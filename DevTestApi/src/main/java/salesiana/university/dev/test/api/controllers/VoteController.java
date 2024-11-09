package salesiana.university.dev.test.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import salesiana.university.dev.test.api.entities.Vote;
import salesiana.university.dev.test.api.mappers.requests.vote.CreateVoteRequest;
import salesiana.university.dev.test.api.mappers.responses.VoteResponse;
import salesiana.university.dev.test.api.services.concretes.VoteService;

@RestController()
@RequestMapping("/api/v1/polls")
public class VoteController {
  private final VoteService voteService;

  @Autowired
  private VoteController(VoteService voteService) {
    this.voteService = voteService;
  }

  @PostMapping("optionId/votes")
  public ResponseEntity<VoteResponse> createVote(@RequestBody CreateVoteRequest voteRequest) {
    return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(voteService.saveVote(voteRequest.optionId(), voteRequest));
  }
}
