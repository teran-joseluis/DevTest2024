package salesiana.university.dev.test.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "option")
public class Option {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long optionId;

  @NotEmpty(message = "Poll option name must not be empty")
  private String name;

  private int votes;

  @ManyToOne()
  @JoinColumn(name = "poll_id")
  @JsonIgnore()
  private Poll poll;
}
