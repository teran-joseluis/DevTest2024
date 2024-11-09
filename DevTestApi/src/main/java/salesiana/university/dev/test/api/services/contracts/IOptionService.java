package salesiana.university.dev.test.api.services.contracts;

import salesiana.university.dev.test.api.entities.Option;
import salesiana.university.dev.test.api.mappers.requests.option.CreateOptionRequest;

import java.util.List;
import java.util.Optional;

public interface IOptionService {
  List<Option> findAllOptions();
  Optional<Option> findOptionById(Long optionId);
  Option saveOption(CreateOptionRequest optionRequest);
}
