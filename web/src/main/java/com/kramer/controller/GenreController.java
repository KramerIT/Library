package com.kramer.controller;

import com.kramer.pojos.Genre;
import com.kramer.pojos.User;
import com.kramer.services.GenreService;
import com.kramer.services.UserService;
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
