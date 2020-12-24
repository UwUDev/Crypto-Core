package me.uwu.xchanger;

import me.uwu.xchanger.utils.Crypto;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        Crypto crypto = new Crypto("ﮄﮫﭽꜺḖᴙ۞ՖҢӪїῦ̤ȾǱ×ݭࢭἳὬἄ﷽ﭿﻦԫ֏Ҏз");

        System.out.print("enter host port: ");
        Scanner in = new Scanner(System.in);
        int port = in.nextInt();
        System.out.print("\n");

        while (true){
            ServerSocket ss = new ServerSocket(port);
            System.out.println("Awaiting connection...");
            Socket socket = ss.accept();
            System.out.println("Message from " + socket.getInetAddress() + ":" + socket.getPort() + "  :)");

            InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);

            ByteArrayOutputStream buffer = new ByteArrayOutputStream();

            int nRead;
            byte[] data = new byte[69420]; //c'est drole hein

            while ((nRead = dataInputStream.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }

            byte[] bytes = buffer.toByteArray();
            //for (byte b : bytes) System.out.println(b);

            System.out.println(Crypto.decodeUTF8(bytes));
            System.out.println("Decrypted result: " + Crypto.decodeUTF8(crypto.decrypt(bytes)));

            ss.close();
            socket.close();

            if (Crypto.decodeUTF8(crypto.decrypt(bytes)).equals("kill"))
                break;
        }
    }
}
