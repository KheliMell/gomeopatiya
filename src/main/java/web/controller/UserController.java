package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDao;
import web.model.User;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping()
    public String showAllUsers(Model model) {
        model.addAttribute("users", userDao.getAllUsers());
        return "users/allUsers";
    }

    @GetMapping("/{id}")
    public String showUserById(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userDao.getUserById(id));
        return "users/userById";
    }

    //Create new User
    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "users/createUser";
    }

    @PostMapping()
    public String createNewUser(@ModelAttribute("user") User user) {
        userDao.addUser(user);
        return "redirect:/users";
    }

    //Update User
    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userDao.getUserById(id));
        return "users/editUser";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userDao.updateUser(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userDao.removeUser(id);
        return "redirect:/users";
    }
}
