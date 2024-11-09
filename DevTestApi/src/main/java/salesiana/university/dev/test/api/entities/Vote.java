package salesiana.university.dev.test.api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vote")
public class Vote {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "vote_id", nullable = false, updatable = false)
  private Long voteId;

  @OneToOne()
  @JoinColumn(name = "poll_id")
  private Poll poll;

  @OneToOne()
  @JoinColumn(name = "option_id")
  private Option option;

  @Column(name = "voter_email", unique = true, nullable = false)
  private String voterEmail;
}
