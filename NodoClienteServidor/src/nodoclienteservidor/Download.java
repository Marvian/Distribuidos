/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodoclienteservidor;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author genio
 */
public class Download {
    public static void downloadFileLocal(String from, String fileName) throws IOException{
        InputStream is = null;
        OutputStream os = null;
        try {
            File miDir = new File ("");
            String path = miDir.getAbsolutePath() + File.separator + "downloads" + File.separator + fileName;
            is = new FileInputStream(from + File.separator + fileName);
            os = new FileOutputStream(path);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }
}
