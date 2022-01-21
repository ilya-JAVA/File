package by.peretz.spring.servises;

import by.peretz.spring.repository.CarRepo;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
class CarServiceTest {

  @Autowired
  CarRepo carRepo;

//  Animal animal = new Animal("sdgfsdf", "sdfsdf", "sdfsdf");
//  Animal animal2 = new Animal("sdgfsdsdf", "sdfsdfsd", "sddsfsdf");


  @org.junit.jupiter.api.Test
  void addCar() {
//    animalRepo.save(animal);
//    animalRepo.save(animal2);
  }

  @org.junit.jupiter.api.Test
  void findAllCar() {
  }
}