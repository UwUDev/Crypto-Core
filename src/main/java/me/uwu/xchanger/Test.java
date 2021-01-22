package me.uwu.xchanger;

import me.uwu.xchanger.utils.Crypto;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        //String key = Crypto.genkey();
        String key = "Lmao this key is not so strong";
        System.out.println("Key: " + key);

        Crypto crypto = new Crypto(key);
        Crypto crypto2 = new Crypto(key);
        File image = new File("test.png");

        crypto.printDebug(false); // false by default just for the example
        crypto2.printDebug(false);

        crypto.crypt(image); // also returns byte array

        FileUtils.copyFile(image, new File(image.getAbsolutePath().replace(".png", ".crypto")));

        crypto2.decrypt(image);
    }
}
