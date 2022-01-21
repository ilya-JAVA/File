package by.peretz.spring.controller;

import by.peretz.spring.domain.Car;
import by.peretz.spring.domain.User;
import by.peretz.spring.servises.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

  public final CarService carService;

  @GetMapping
  public String getCars(
      @RequestParam(required = false) String nameFilter,
      @RequestParam(required = false) String cellFilter,
      @RequestParam(required = false, name = "editCar") Car car,
      @RequestParam(name = "removeId", required = false) Car removeCar,
      @RequestParam(name = "repairId", required = false) Car repairCar,
      @PageableDefault(sort = {"id", "name"}, direction = Sort.Direction.ASC) Pageable pageable,
      Model model
  ) {
//    model.addAttribute("animals", animalService.findAllAnimal());
    Page<Car> page = carService.findAllCars(nameFilter, cellFilter, pageable);
    model.addAttribute("page", page);

    model.addAttribute("hasContent", page.hasContent());

    model.addAttribute("url", "/cars");
    model.addAttribute("nameFilter", nameFilter);
    model.addAttribute("cellFilter", cellFilter);
    if (car != null) {
      model.addAttribute("car", car);
    }
    if (removeCar != null) {
      carService.removeCar(removeCar);
      return "redirect:/cars";
    }

    if (repairCar != null) {
      carService.repairCar(repairCar);
      return "redirect:/cars";
    }

    return "cars";
  }

  @GetMapping("/addcar/{carOwner}")
  public String addOrEditCar(
    Model model,
    @PathVariable User carOwner
  ) {
    model.addAttribute("cars", carService.findAllCarsByOwner(carOwner));
    model.addAttribute("user", carOwner);
    return "addcar";
  }

//  @PreAuthorize("hasAuthority('ADMIN')")
  @PostMapping("/addcar/{id}")
  public String addCar(
//      @PageableDefault(sort = {"name", "species", "sex"}, direction = Sort.Direction.ASC) Pageable pageable,
      @PathVariable("id") User carOwner,
      @Valid Car car,
      BindingResult bindingResult,
      Model model
  ) {
    if (bindingResult.hasErrors()) {
      Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
      model.mergeAttributes(errorsMap);
      model.addAttribute("user", carOwner);
      model.addAttribute("car", car);
      model.addAttribute("cars", carService.findAllCarsByOwner(carOwner));

//      model.addAttribute("animals", animalService.findAllAnimal());
//      Page<Animal> page = animalService.findAllAnimals(pageable);
//      model.addAttribute("page", page);
//      model.addAttribute("url", "/animals");

      return "addcar";
    } else {
      carService.addCar(car);
      return "redirect:/cars/addcar/{id}";
    }
  }
}
