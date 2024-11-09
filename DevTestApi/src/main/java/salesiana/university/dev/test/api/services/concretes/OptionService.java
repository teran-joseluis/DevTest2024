package salesiana.university.dev.test.api.services.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import salesiana.university.dev.test.api.entities.Option;
import salesiana.university.dev.test.api.mappers.requests.option.CreateOptionRequest;
import salesiana.university.dev.test.api.repositories.IOptionRepository;
import salesiana.university.dev.test.api.services.contracts.IOptionService;

import java.util.List;
import java.util.Optional;

@Service
public class OptionService implements IOptionService {
  private final IOptionRepository optionRepository;

  @Autowired
  public OptionService(IOptionRepository optionRepository) {
    this.optionRepository = optionRepository;
  }

  @Override
  public List<Option> findAllOptions() {
    return optionRepository.findAll();
  }

  @Override
  public Optional<Option> findOptionById(Long optionId) {
    return optionRepository.findById(optionId);
  }

  @Override
  public Option saveOption(CreateOptionRequest optionRequest) {
    Option option = new Option();
    option.setName(optionRequest.name());

    Option savedOption = optionRepository.save(option);

    return new Option(
            savedOption.getOptionId(),
            savedOption.getName(),
            savedOption.getVotes(),
            savedOption.getPoll()
    );
  }
}
