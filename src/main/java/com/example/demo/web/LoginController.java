package com.example.demo.web;

import com.example.demo.Repositories.UserRepository;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String log(Model model, HttpSession session){
        if(session.getAttribute("utilisateur")!=null)
            return "Home";
        User utilisateur = new User();
        model.addAttribute("utilisateur",utilisateur);
        return "login";
    }
    @RequestMapping(value = "/LoginController",method = RequestMethod.POST)
    public String logIn(Model model, User utilisateurInput, HttpSession session){
        if(utilisateurInput==null){
            return "login";
        }
        User utilisateur = userRepository.findByLoginAndPasswd(utilisateurInput.getLogin(),utilisateurInput.getPasswd());
        if(utilisateur==null)
            return "login";
        session.setAttribute("utilisateur",utilisateur);
        model.addAttribute("utiilisateur",utilisateur);
        return "Home";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logOut(Model model, HttpSession session){
        session.removeAttribute("utilisateur");
        return "Home";
    }


}
