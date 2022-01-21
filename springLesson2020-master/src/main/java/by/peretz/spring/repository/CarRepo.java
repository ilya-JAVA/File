package by.peretz.spring.repository;

import by.peretz.spring.domain.Car;
import by.peretz.spring.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepo extends JpaRepository<Car, Long> {
  @Override
  Page<Car> findAll(Pageable pageable);
  Page<Car> findByNameStartingWithIgnoreCaseAndCellStartsWithIgnoreCase(
      @Param("name") String name,
      @Param("cell") String cell,
      Pageable pageable
  );
  List<Car> findByCarOwner(User user);
}
