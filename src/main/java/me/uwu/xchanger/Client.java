package me.uwu.xchanger;

import me.uwu.xchanger.utils.Crypto;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        //Crypto crypto = new Crypto("ﮄﮫﭽꜺḖᴙ۞ՖҢӪїῦ̤ȾǱ×ݭࢭἳὬἄ﷽ﭿﻦԫ֏Ҏз");
        Crypto crypto = new Crypto(Crypto.genkey());
        System.out.print("enter host ip: ");
        Scanner in = new Scanner(System.in);
        String host = in.nextLine();
        System.out.print("\n");
        System.out.print("enter host port: ");
        int port = in.nextInt();
        System.out.print("\n");
        Socket socketKey = new Socket(host, port);
        OutputStream outputStreamKey = socketKey.getOutputStream();
        DataOutputStream dataOutputStreamKey = new DataOutputStream(outputStreamKey);
        byte[] key = Crypto.encodeUTF8(crypto.getKey());
        dataOutputStreamKey.write(Crypto.encodeUTF8("New key is:"));
        dataOutputStreamKey.flush();
        dataOutputStreamKey.write(key);
        dataOutputStreamKey.flush();
        dataOutputStreamKey.close();
        socketKey.close();



        while (true) {
            System.out.print("Send message: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String message = reader.readLine();

            Socket socket = new Socket(host, port);
            //System.out.println("Connected!");

            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            //System.out.println("Sending string to the ServerSocket");

        /*byte[] msg = Crypto.encodeUTF8("salut");

        dataOutputStream.write(msg);*/
            byte[] msg = crypto.crypt(message);

            dataOutputStream.write(msg);
            dataOutputStream.flush();
            dataOutputStream.close();
            socket.close();

            if (message.equals("kill"))
                break;
        }
    }
}
