package by.peretz.spring.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
//@RequiredArgsConstructor
@NoArgsConstructor
public class Car extends AbstractEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotEmpty
  @NonNull
  private String cell;
  @NotEmpty
  @NonNull
  private String color;
  @NotEmpty
  @NonNull
  private String name;

  @ManyToOne
  private User carOwner;

  @Override
  public void save(Car car) {

  }
}
