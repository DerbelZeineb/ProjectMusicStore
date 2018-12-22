package com.example.demo.web;

import com.example.demo.Repositories.ArtistRepository;
import com.example.demo.Repositories.ConcertRepository;
import com.example.demo.model.Artist;
import com.example.demo.model.Concert;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class ConcertController {
    @Autowired
    ArtistRepository artistRepository;
    @Autowired
    ConcertRepository concertRepository;
    @RequestMapping(value="/concerts" , method= RequestMethod.GET)
    public String showAlbumsForNormalUser(@RequestParam(name = "id") int artistID, Model model, HttpSession session)
    {   User utilisateur =(User) session.getAttribute("utilisateur");
        if(utilisateur==null)
            return "redirect:/login";
        Optional<Artist> artists= artistRepository.findById(artistID);
        Artist artist = artists.get();
        session.setAttribute("artist",artist);
        List<Concert> list=concertRepository.findConcertsByArtist(artist);
        model.addAttribute("list",list);
        model.addAttribute("user",utilisateur);
        return "ArtistConcerts";
    }
    @RequestMapping(value = "/ajoutConcert", method = RequestMethod.GET)
    public String ajoutConcertForm(Model model, HttpSession session){
        User utilisateur = (User)session.getAttribute("utilisateur");
        if(utilisateur==null)
            return "redirect:/login";
        Concert concert = new Concert();
        Artist artist=(Artist) session.getAttribute("artist");
        concert.setArtist(artist);
        System.out.println(artist.getId());
        model.addAttribute("concert",concert);
        return "ajoutConcert";
    }
    @RequestMapping(value="/ConcertController" , method= RequestMethod.POST)
    public String postForm(Model model, @ModelAttribute("concert")Concert concert, HttpSession session)
    {
        User utilisateur =(User) session.getAttribute("utilisateur");
        if(utilisateur==null)
            return "redirect:/login";
        Artist artist=(Artist) session.getAttribute("artist");
        concert.setArtist(artist);
        model.addAttribute("concertForm",concert);
        concertRepository.save(concert);
        return"Home";

    }
    @RequestMapping(value="/delete")
    public String delete(@RequestParam(name = "id") int id, Model model, HttpSession session)
    {   User utilisateur =(User) session.getAttribute("utilisateur");
        if(utilisateur==null)
            return "redirect:/login";
        Optional<Concert> concerts=concertRepository.findById(id);
        Concert concert = concerts.get();
        concertRepository.delete(concert);
        return "Home";
    }
    @RequestMapping(value = "/AllConcerts", method = RequestMethod.GET)
    public String artistUsers(Model model, HttpSession session){
        User utilisateur =(User) session.getAttribute("utilisateur");
        List<Concert> concerts = (List<Concert>)concertRepository.findAll();
        model.addAttribute("concerts",concerts);
        model.addAttribute("user",utilisateur);
        return "Concerts02";
    }
    @RequestMapping(value = "/BuyTicket", method = RequestMethod.GET)
    public String Buy(Model model, HttpSession session){
        User utilisateur =(User) session.getAttribute("utilisateur");
        if(utilisateur==null)
            return "redirect:/login";

        return "Payment";
    }

}
