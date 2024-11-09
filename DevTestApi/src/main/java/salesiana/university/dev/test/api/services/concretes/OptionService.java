package salesiana.university.dev.test.api.services.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import salesiana.university.dev.test.api.entities.Option;
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
  public Optional<Option> findOptionById(Long id) {
    return optionRepository.findById(id);
  }

  @Override
  public Option saveOption(Option option) {
    return null;
  }

  @Override
  public Option updateOption(Option option) {
    return optionRepository.save(option);
  }

  @Override
  public boolean deleteOption(Long id) {
    return false;
  }
}
