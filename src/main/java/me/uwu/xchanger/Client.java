package me.uwu.xchanger;

import me.uwu.xchanger.utils.Crypto;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Crypto crypto = new Crypto("abcde");

        Socket socket = new Socket("localhost", 7777);
        System.out.println("Connected!");

        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        System.out.println("Sending string to the ServerSocket");

        /*byte[] msg = Crypto.encodeUTF8("salut");

        dataOutputStream.write(msg);*/
        byte[] msg = crypto.crypt("Omelette");

        dataOutputStream.write(msg);
        dataOutputStream.flush();
        dataOutputStream.close();

        System.out.println("Closing socket and terminating program.");
        socket.close();
    }
}
