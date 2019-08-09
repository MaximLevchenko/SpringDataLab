package com.example.demo.model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.View;

@RestController
public class Controller {
    @RequestMapping("/")
    public String getView() {

        return "view";
    }
}
