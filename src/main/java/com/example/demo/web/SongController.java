package com.example.demo.web;

import com.example.demo.Repositories.AlbumRepository;
import com.example.demo.Repositories.ArtistRepository;
import com.example.demo.Repositories.SongRepository;
import com.example.demo.model.Album;
import com.example.demo.model.Artist;
import com.example.demo.model.Song;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class SongController {
    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private SongRepository songRepository;


    @RequestMapping(value= "/ajoutSong", method = RequestMethod.GET)
    public String detailAlbum(Model model, HttpSession session){
        User utilisateur =(User) session.getAttribute("utilisateur");
        if(utilisateur==null)
            return "login";
        Song song = new Song();
        model.addAttribute("song",song);
        return "AjoutSong";
    }
    @RequestMapping(value = "/SongController", method = RequestMethod.POST)
    public String ajoutSong(Model model, Song song, HttpSession session) {
        User utilisateur =(User) session.getAttribute("utilisateur");
        if(utilisateur==null)
            return "redirect:/login";
        model.addAttribute("user",utilisateur);
        Album album = (Album) session.getAttribute("album");
        Artist artist = (Artist) session.getAttribute("artist");
        song.setAlbum(album);
        artistRepository.save(artist);
        albumRepository.save(album);
        songRepository.save(song);
        return "Artists";
    }
    @RequestMapping(value="/addsong" , method= RequestMethod.GET)
    public String showAlbums(@RequestParam(name = "id") String id, Model model, HttpSession session)
    {
        User utilisateur =(User) session.getAttribute("utilisateur");
        if(utilisateur==null)
            return "redirect:/login";
        Album album= albumRepository.findByName(id);
        Song song = new Song();
        song.setAlbum(album);
        model.addAttribute("song",song);
        session.setAttribute("album",album);
        return "AjoutSong";

    }
}

