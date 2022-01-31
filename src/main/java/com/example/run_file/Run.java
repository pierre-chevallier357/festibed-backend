package com.example.run_file; 

import java.sql.Connection;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Tools;

@RestController
@CrossOrigin
@RequestMapping("/")
public class Run {

    static Connection conn;    

    @GetMapping("/")
    public String index() {
      return "ceci est le serveur";
    }

    @GetMapping("/connection-close")
    void connectionClose(){
      Tools.connClose(conn);
    }
}
