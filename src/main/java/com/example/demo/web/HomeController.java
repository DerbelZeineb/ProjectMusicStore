package com.example.demo.web;

import com.example.demo.Repositories.UserRepository;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @Autowired
    UserRepository userRepository;
@GetMapping(value="/")
    public String home(HttpSession session, Model model)
    {
        User user = (User)session.getAttribute("user");
        model.addAttribute("user",user);
        return"Home";

    }
    @GetMapping(value="/Contact")
    public String contact(HttpSession session, Model model)
    {

            return"Contact";

    }
    @GetMapping(value="/dashboard")
    public String admin(HttpSession session, Model model)
    {   User utilisateur = (User)session.getAttribute("utilisateur");
        model.addAttribute("user",utilisateur);
        return"index";

    }


}
