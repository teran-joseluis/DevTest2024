package salesiana.university.dev.test.api.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "poll")
public class Poll {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "poll_id", unique = true, nullable = false)
  private Long pollId;

  private String name;

  @OneToMany(mappedBy = "poll", cascade = CascadeType.ALL)
  private List<Option> options;

  @OneToOne()
  private Vote vote;
}
