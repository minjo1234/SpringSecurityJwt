package com.example.spring_security_jwt.controller;

import com.example.spring_security_jwt.dto.JoinDTO;
import com.example.spring_security_jwt.service.Joinservice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class JoinController {

    private final Joinservice joinservice;

    public JoinController(Joinservice joinservice){
        this.joinservice = joinservice;

    }
    @PostMapping("/join")
    public String joinProcess(JoinDTO joinDTO){

        System.out.println(joinDTO.getUsername());
        joinservice.joinProcess(joinDTO);
        return "ok";
    }
}
