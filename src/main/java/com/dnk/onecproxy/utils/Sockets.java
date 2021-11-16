package com.dnk.onecproxy.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.Socket;

@Component
public class Sockets {

    @Value("${url}")
    private String url;

    @Value("${port}")
    private Integer port;

    public String sendRequest(String request) throws IOException {
        Socket socket = new Socket(url, port);

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        dataOutputStream.writeUTF(request);
        dataOutputStream.flush();

        String response = dataInputStream.readUTF();

        dataInputStream.close();
        socket.close();

        System.out.println("Response : " + response);
        return response;
    }
}
