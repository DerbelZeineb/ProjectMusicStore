package com.example.demo.web;

import com.example.demo.Repositories.AlbumRepository;
import com.example.demo.Repositories.ArtistRepository;
import com.example.demo.Repositories.CommandeRepository;
import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Controller
public class AlbumController {

    public static String UPLOAD_FOLDER = "src/main/resources/static/img/";

    private void initFolder(){
        File folder = new File(UPLOAD_FOLDER);
        if(!folder.exists())
            folder.mkdir();
    }

    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private CommandeRepository commandeRepository;

    @RequestMapping(value = "/ajoutAlbum", method = RequestMethod.GET)
    public String ajoutAlbumForm(Model model, HttpSession session){
       User utilisateur = (User)session.getAttribute("utilisateur");
        if(utilisateur==null)
            return "redirect:/login";
        Album album = new Album();
        Artist artist= (Artist) session.getAttribute("artist");
        album.setArtist(artist);
        initFolder();
        model.addAttribute("album",album);
        return "AjoutAalbum";
    }
    @RequestMapping(value = "/AlbumController", method = RequestMethod.POST)
    public String ajoutAlbum(Model model, Album album, @RequestParam("file") MultipartFile file, HttpSession session){
        Artist artist= (Artist) session.getAttribute("artist");
        album.setArtist(artist);
        int i=0;
        if (file.isEmpty()) {
            album.setImg("alt.png");
            Song song=new Song();
            model.addAttribute("song",song);
            session.setAttribute("album",album);
            return "AjoutSong";
        }

        try {

            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            album.setImg(file.getOriginalFilename());

        } catch (IOException e) {
            album.setImg("alt.png");
            Song song=new Song();
            model.addAttribute("song",song);
            session.setAttribute("album",album);
            return "AjoutSong";
        }
        Song song=new Song();
        model.addAttribute("song",song);
        session.setAttribute("album",album);
        return "AjoutSong";
    }


    @RequestMapping(value="/albumsUser" , method= RequestMethod.GET)
    public String showAlbumsForNormalUser(@RequestParam(name = "id") int artistID, Model model, HttpSession session)
    {
        User utilisateur =(User) session.getAttribute("utilisateur");
        if(utilisateur==null)
            return "redirect:/login";
        Optional<Artist> artists= artistRepository.findById(artistID);
        Artist artist = artists.get();
        session.setAttribute("artist",artist);
        List<Album> listAlbum=albumRepository.findAlbumsByArtist(artist);
        model.addAttribute("list",listAlbum);
        model.addAttribute("user",utilisateur);
        return "detailAlbumForUser";
    }
    @RequestMapping(value = "/BuyAlbum", method = RequestMethod.GET)
    public String Buy(@RequestParam(name = "id") String albumID,Model model, HttpSession session){
        User utilisateur =(User) session.getAttribute("utilisateur");
        if(utilisateur==null)
            return "redirect:/login";
        Album album=albumRepository.findByName(albumID);
        model.addAttribute("album",album);
        session.setAttribute("albumBought",album);
        return "Payment";
    }
    @RequestMapping(value = "/Receipt", method = RequestMethod.GET)
    public String Receipt(Model model, HttpSession session){
        Album album =(Album) session.getAttribute("albumBought");
        model.addAttribute("album",album);
        User user= (User) session.getAttribute("utilisateur");
        Commande commande= new Commande();
        commande.setUser(user);
        commande.setPrice(60);
        commande.setAchat(album.getName());
        commandeRepository.save(commande);
        return "Receip";
    }

}
