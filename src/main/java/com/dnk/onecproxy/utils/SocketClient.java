package com.dnk.onecproxy.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

@Component
public class SocketClient {

    @Value("${url}")
    private String url;

    @Value("${port}")
    private Integer port;

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection() {
        try {
            clientSocket = new Socket(url, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String sendMessage(String msg) {
        StringBuilder response = new StringBuilder();
        try {
            out.println(msg);
            out.flush();

            String message = "";
            while ((message = in.readLine()) != null) {
                System.out.println(message);
                response.append(message);
            }

            return response.toString();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return response.toString();
    }

    public void stopConnection() {
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
