package by.peretz.spring.controller;

import by.peretz.spring.domain.User;
import by.peretz.spring.servises.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class RegistrationController {

  public final UserService userService;

  @GetMapping("/registration")
  public String registration(
    @RequestParam(name = "editUser", required = false, defaultValue = "") User user,
    Model model
    ){
      model.addAttribute("user", user);
      model.addAttribute("users", userService.users());

      return "registration";
  }


  @PostMapping("/registration")
  public String addUser(
      @Valid User user,
      BindingResult bindingResult,
      Model model
  ) {
    if (bindingResult.hasErrors()) {
      Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
      model.mergeAttributes(errorsMap);
      model.addAttribute("user", user);
      model.addAttribute("users", userService.users());
      return "registration";
    } else {
      userService.addUser(user);
      return "redirect:/cars";
    }
  }

  @GetMapping("/activate/{code}")
  public String activate(
      Model model,
      @PathVariable String code
  ) {
    boolean isActivated = userService.activateUser(code);

    if (isActivated) {
      model.addAttribute("message", "success");
    } else {
      model.addAttribute("message", "Activation code isn't found");
    }
    return "activation";
  }
}
