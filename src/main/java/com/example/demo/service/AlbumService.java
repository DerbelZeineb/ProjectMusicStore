package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class AlbumService {
     public static String UPLOAD_FOLDER = "src/main/resources/static/img/";

    public void initFolder(){
        File folder = new File(UPLOAD_FOLDER);
        if(!folder.exists())
            folder.mkdir();
    }

}
