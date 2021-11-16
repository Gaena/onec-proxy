package com.dnk.onecproxy.service;

import com.dnk.onecproxy.utils.SocketClient;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OneCService {

    private final SocketClient socketClient;

    public OneCService(SocketClient socketClient) {
        this.socketClient = socketClient;
    }

    public String processRequest(String request) throws IOException {
        System.out.println("Incoming request : " + request);
        return socketClient.sendMessage(request);
    }
}
