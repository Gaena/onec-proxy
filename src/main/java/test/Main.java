package test;

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

public class Main {

    ZContext context = new ZContext(1);
    ZMQ.Socket socket = context.createSocket(SocketType.DEALER);

    public void sendMessage() {
        ZMQ.Context context = ZMQ.context(1);

        // Socket to talk to server
        System.out.println("Connecting to hello world server");

        ZMQ.Socket socket = context.socket(ZMQ.REQ);
        socket.connect ("tcp://81.21.87.10:6739");

        for(int requestNbr = 0; requestNbr != 10; requestNbr++) {
            String request = "{\"operationId\":\"getInfo\",\"version\":1}" ;
            System.out.println("Sending request " + requestNbr );
            socket.send(request.getBytes (), 0);

            byte[] reply = socket.recv(0);
            System.out.println("Received " + new String (reply) + " " + requestNbr);
        }

        socket.close();
        context.term();
    }

    public static void main(String args[]) {
        Main client = new Main();
        client.sendMessage();
    }
}
