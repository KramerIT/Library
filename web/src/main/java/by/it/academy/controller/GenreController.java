package by.it.academy.controller;

import by.it.academy.pojos.Genre;
import by.it.academy.pojos.User;
import by.it.academy.services.GenreService;
import by.it.academy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/genre")
public class GenreController {

    //@Autowired
    private GenreService genreService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        List<Genre> genres = genreService.getAll();
        model.addAttribute("genre", new Genre());
        model.addAttribute("allGenre",genres );
        List<User> users = userService.getAll();
        model.addAttribute("user", new User());
        model.addAttribute("allUser",users );
        return "genre/list";
    }
}
