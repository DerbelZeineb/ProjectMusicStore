package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashController {
    @GetMapping(value="/profile")
    public String profile()
    {
        return "profile";
    }
    @GetMapping(value="/general")
    public String gen()
    {
        return "general";
    }
    @GetMapping(value="/buttons")
    public String buttons()
    {
        return "buttons";
    }
    @GetMapping(value="/panels")
    public String panels()
    {
        return "panels";
    }
    @GetMapping(value="/calendar")
    public String ca()
    {
        return "calendar";
    }
    @GetMapping(value="gallery")
    public String gal()
    {
        return "gallery";
    }
    @GetMapping(value="/todo_list")
    public String todo()
    {
        return "todo_list";
    }
    @GetMapping(value="/blank")
    public String blank()
    {
        return "blank";
    }
    @GetMapping(value="/lock_screen")
    public String lock()
    {
        return "lock_screen";
    }
    @GetMapping(value="/form_component")
    public String form()
    {
        return "form_component";
    }

    @GetMapping(value="/basic_table")
    public String table()
    {
        return "basic_table";
    }
    @GetMapping(value="/responsive_table")
    public String resp()
    {
        return "responsive_table";
    }
    @GetMapping(value="/morris")
    public String morris()
    {
        return "morris";
    }
    @GetMapping(value="/chartjs")
    public String chartjs()
    {
        return "chartjs";
    }
}
