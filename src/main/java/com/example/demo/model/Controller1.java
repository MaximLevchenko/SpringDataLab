package com.example.demo.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.View;

@Controller
public class Controller1
{
    @RequestMapping("/")
    public String   getView()
    {
        return "view";
    }
}