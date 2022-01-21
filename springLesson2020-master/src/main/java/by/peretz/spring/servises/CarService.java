package by.peretz.spring.servises;

import by.peretz.spring.domain.Car;
import by.peretz.spring.domain.User;
import by.peretz.spring.repository.CarRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

  public final CarRepo carRepo;

  public void addCar(Car car) {
    carRepo.save(car);
  }

  public List<Car> findAllCar() {
    Iterable<Car> cars = carRepo.findAll();
    List<Car> carList = new ArrayList<>();
    cars.forEach(carList::add);
    return carList;
  }


  public void removeCar(Car car) {

    if(car != null) {
      car.setDeleted(true);
      car.save(car);
    }
  }

  public void repairCar(Car car) {
    if(car != null) {
      car.setDeleted(false);
      carRepo.save(car);
    }
  }

  public Page<Car> findAllCars(Pageable pageable) {
    return carRepo.findAll(pageable);
  }

  public Page<Car> findAllCars(String nameFilter, String cellFilter, Pageable pageable) {

    if (StringUtils.isEmpty(nameFilter) && StringUtils.isEmpty(cellFilter)) {
      return carRepo.findAll(pageable);
    } else {
      return carRepo.findByNameStartingWithIgnoreCaseAndCellStartsWithIgnoreCase(nameFilter, cellFilter, pageable);
    }
  }

  public List<Car> findAllCarsByOwner(User user) {
    return carRepo.findByCarOwner(user);
  }

}
