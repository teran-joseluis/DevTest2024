package salesiana.university.dev.test.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import salesiana.university.dev.test.api.entities.Option;
import salesiana.university.dev.test.api.services.concretes.OptionService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/options")
public class OptionController {
  private final OptionService optionService;

  @Autowired
  public OptionController(OptionService optionService) {
    this.optionService = optionService;
  }

  @GetMapping
  public ResponseEntity<List<Option>> getAllOptions() {
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(optionService.findAllOptions());
  }

  @PostMapping
  public ResponseEntity<Option> createOption(@RequestBody Option option) {
    return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(optionService.saveOption(option));
  }

}
