package salesiana.university.dev.test.api.services.contracts;

import salesiana.university.dev.test.api.entities.Option;

import java.util.List;
import java.util.Optional;

public interface IOptionService {
  List<Option> findAllOptions();
  Optional<Option> findOptionById(Long id);
  Option saveOption(Option option);
  Option updateOption(Option option);
  boolean deleteOption(Long id);
}
