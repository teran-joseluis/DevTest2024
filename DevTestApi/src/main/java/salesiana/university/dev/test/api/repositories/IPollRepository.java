package salesiana.university.dev.test.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import salesiana.university.dev.test.api.entities.Poll;

public interface IPollRepository extends JpaRepository<Poll, Long> {

}
