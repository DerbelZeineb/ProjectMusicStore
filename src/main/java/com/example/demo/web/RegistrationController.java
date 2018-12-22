package com.example.demo.web;


import com.example.demo.model.User;
import com.example.demo.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;
    @RequestMapping(value = "/inscription", method = RequestMethod.GET)
    public String registration(Model model) {
        String errorMsg="";
        model.addAttribute("errorMsg",errorMsg);
        model.addAttribute("userForm", new User());
        return "inscription";
    }

    @RequestMapping(value = "/RegistrationController", method = RequestMethod.POST)
    public String registration(@ModelAttribute("errorMsg") String errorMsg, @ModelAttribute("userForm")@Valid User userForm, BindingResult bindingResult, Model model, HttpSession session) {
        model.addAttribute("userForm", new User());
        if (registrationService.findByLogin(userForm.getLogin())!=null)
        {   errorMsg="Existing login, please choose another one.";
            model.addAttribute("errorMsg",errorMsg);
            return "inscription";
        }

        if(bindingResult.hasErrors())
        {
             return"inscription";
        }
        session.setAttribute("utilisateur",userForm);
        model.addAttribute("user",userForm);
        registrationService.save(userForm);

        return "redirect:/";
    }
}
