package salesiana.university.dev.test.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import salesiana.university.dev.test.api.entities.Vote;

public interface IVoteRepository extends JpaRepository<Vote, Long> {

}
