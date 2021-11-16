package com.dnk.onecproxy.service;

import com.dnk.onecproxy.utils.Sockets;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OneCService {

    private final Sockets sockets;

    public OneCService(Sockets sockets) {
        this.sockets = sockets;
    }

    public String processRequest(String request) throws IOException {
        System.out.println("Incoming request : " + request);
        return sockets.sendRequest(request);
    }
}
