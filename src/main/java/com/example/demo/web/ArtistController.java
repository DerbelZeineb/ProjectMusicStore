package com.example.demo.web;

import com.example.demo.Repositories.ArtistRepository;
import com.example.demo.model.Album;
import com.example.demo.model.Artist;
import com.example.demo.model.User;
import com.example.demo.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ArtistController {
    @Autowired
    AlbumService albumService;
    @Autowired
    private ArtistRepository artistRepository;

    @RequestMapping(value = "/ajoutArtist", method = RequestMethod.GET)
    public String ajoutArtistForm(Model model, HttpSession session){
        User utilisateur = (User)session.getAttribute("utilisateur");
        if(utilisateur==null)
            return "login";
       Artist artist = new Artist();
        model.addAttribute("artist",artist);
        return "ajoutArtiste";
    }
    @RequestMapping(value = "/ArtistController", method = RequestMethod.POST)
    public String ajoutAlbum(HttpSession session, Model model, @ModelAttribute("artist") Artist artist){
        albumService.initFolder();
        Album album=new Album();
        model.addAttribute("album",album);
        session.setAttribute("artist",artist);
        return "ajoutAalbum";
    }

    @RequestMapping(value = "/artists", method = RequestMethod.GET)
    public String artistUsers(Model model,/*@RequestParam(name = "id") int id,*/ HttpSession session){
        User utilisateur = (User)session.getAttribute("utilisateur");
        List<Artist> artists = (List<Artist>)artistRepository.findAll();
        model.addAttribute("artists",artists);
        session.setAttribute("user",utilisateur);
        model.addAttribute("user",utilisateur);
        return "Artists";
    }



}
