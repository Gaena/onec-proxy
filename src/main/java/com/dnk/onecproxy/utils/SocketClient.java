package com.dnk.onecproxy.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.zeromq.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;

@Component
public class SocketClient {

    @Value("${url}")
    private String url;


    public String sendMessage(String msg) {
        try {
            ZMQ.Context context = ZMQ.context(1);

            // Socket to talk to server
            System.out.println("Connecting to KASSA server :  " + url);

            ZMQ.Socket socket = context.socket(SocketType.REQ);
            socket.connect(url);

            System.out.println("Sending request ");
            socket.send(msg.getBytes(), 0);

            byte[] reply = socket.recv(0);
            System.out.println("Received " + new String(reply));

            socket.close();
            context.term();
            return new String(reply);

        } catch (ZMQException e) {
            return e.getErrorCode() + " : " + e.getMessage();
        }

    }


}
