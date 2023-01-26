package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showMainPage(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    //For feature
//    @GetMapping()
//    public String showAllUsers(Model model) {
//        model.addAttribute("users", userService.getAllUsers());
//        return "users/allUsers";
//    }
//
//    @GetMapping("/{id}")
//    public String showUserById(@PathVariable("id") int id, Model model) {
//        model.addAttribute("user", userService.getUserById(id));
//        return "users/userById";
//    }
//
//    //Create new User
//    @GetMapping("/new")
//    public String newUser(Model model) {
//        model.addAttribute("user", new User());
//        return "users/createUser";
//    }
//
//    @PostMapping()
//    public String createNewUser(@ModelAttribute("user") User user) {
//        userService.addUser(user);
//        return "redirect:/users";
//    }
//
//    //Update User
//    @GetMapping("/{id}/edit")
//    public String editUser(Model model, @PathVariable("id") int id) {
//        model.addAttribute("user", userService.getUserById(id));
//        return "users/editUser";
//    }
//
//    @PatchMapping("/{id}")
//    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
//        userService.updateUser(id, user);
//        return "redirect:/users";
//    }
//
//    @DeleteMapping("/{id}")
//    public String deleteUser(@PathVariable("id") int id) {
//        userService.removeUser(id);
//        return "redirect:/users";
//    }
}
