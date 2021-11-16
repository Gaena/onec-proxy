package com.dnk.onecproxy.controller;

import com.dnk.onecproxy.service.OneCService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController("process")
public class OneCController {

    private final OneCService service;

    public OneCController(OneCService service) {
        this.service = service;
    }

    @PostMapping
    public String processRequest(@RequestBody String request) throws IOException {
        return service.processRequest(request);
    }
}
