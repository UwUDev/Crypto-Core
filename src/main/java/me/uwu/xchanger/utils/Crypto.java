/*
*
* © UwUDev 2020-2021
*
* i made it with love for you guys.
* its free tu use <3
*
*/

package me.uwu.xchanger.utils;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Crypto {

    private String key;
    private boolean print = false;

    public Crypto(String key) {
        this.key = key;
    }
    
    public void printDebug(boolean b){
        this.print = b;
    }

    public byte[] decrypt(byte[] message){

        byte[] keyBytes = this.key.getBytes(StandardCharsets.US_ASCII);

        ArrayList<Byte> byteArray = new ArrayList<>();

        int state = 0;
        coder(keyBytes, message, byteArray, state);

        return getBytes(byteArray);
    }

    public byte[] decrypt(File file) throws IOException {

        byte[] keyBytes = this.key.getBytes(StandardCharsets.US_ASCII);
        byte[] bytes = FileUtils.readFileToByteArray(file);

        ArrayList<Byte> byteArray = new ArrayList<>();

        int state = 0;
        coder(keyBytes, bytes, byteArray, state);
        FileUtils.writeByteArrayToFile(file, getBytes(byteArray));

        return getBytes(byteArray);
    }

    public byte[] crypt(String message){
        byte[] keyBytes = this.key.getBytes(StandardCharsets.US_ASCII);
        byte[] bytes = message.getBytes(StandardCharsets.UTF_8);

        ArrayList<Byte> byteArray = new ArrayList<>();

        int state = 0;
        for (byte b : bytes) {
            if(state >= keyBytes.length)
                state = 0;
            if(this.print)
                System.out.println(b);
            byte oof = (byte) (b + keyBytes[state]);
            byteArray.add(oof);
            state++;
        }

        return getBytes(byteArray);
    }

    public byte[] crypt(File file) throws IOException {
        byte[] keyBytes = this.key.getBytes(StandardCharsets.US_ASCII);
        byte[] bytes = FileUtils.readFileToByteArray(file);


        ArrayList<Byte> byteArray = new ArrayList<>();

        int state = 0;
        for (byte b : bytes) {
            if(state >= keyBytes.length)
                state = 0;
            if(this.print)
                System.out.println(b);
            byte oof = (byte) (b + keyBytes[state]);
            byteArray.add(oof);
            state++;
        }
        FileUtils.writeByteArrayToFile(file, getBytes(byteArray));

        return getBytes(byteArray);
    }

    private byte[] getBytes(ArrayList<Byte> byteArray) {
        if(this.print) {
            System.out.println("\n\n");

            for (byte b : byteArray) {
                System.out.println(b);
            }
        }

        byte[] result = new byte[byteArray.size()];
        for(int i = 0; i < byteArray.size(); i++) {
            result[i] = byteArray.get(i);
        }

        return result;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    private static final Charset UTF8_CHARSET = StandardCharsets.UTF_8;

    public static String decodeUTF8(byte[] bytes) {
        return new String(bytes, UTF8_CHARSET);
    }

    public static byte[] encodeUTF8(String string) {
        return string.getBytes(UTF8_CHARSET);
    }

    public static String genkey(){
        return genkeyWithLength(32);
    }

    public static String genkeyWithLength(int length){
        byte[] array = new byte[length];
        new Random().nextBytes(array);

        return new String(array, StandardCharsets.UTF_8);
    }

    public void saveKeyBytesToFile(File file) throws IOException {
        if (file.createNewFile())
            System.out.println("File created: " + file.getName());
        else System.out.println("File already exists, this will erase old key...");


        try (Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8))) {
            out.write(this.key);
            System.out.println("Successfully saved key bytes to " + file.getName());
        } catch (IOException e) {
            System.out.println("Unable to save key");
            e.printStackTrace();
        }
    }

    public void loadKeyBytesToFile(File file){
        StringBuilder sb = new StringBuilder();
        try {
            List<String> list = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
            for (String line : list)
                sb.append(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.key = sb.toString();
    }

    private void coder(byte[] keyBytes, byte[] bytes, ArrayList<Byte> byteArray, int state) {
        for (byte b : bytes) {
            if(state >= keyBytes.length)
                state = 0;
            if(this.print)
                System.out.println(b);
            byte oof = (byte) (b - keyBytes[state]);
            byteArray.add(oof);
            state++;
        }
    }
}
