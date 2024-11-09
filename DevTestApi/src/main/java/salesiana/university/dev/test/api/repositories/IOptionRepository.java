package salesiana.university.dev.test.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import salesiana.university.dev.test.api.entities.Option;

public interface IOptionRepository extends JpaRepository<Option, Long> {
}
