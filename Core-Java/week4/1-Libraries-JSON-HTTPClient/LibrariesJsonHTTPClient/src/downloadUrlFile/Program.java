package downloadUrlFile;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Program {
    public static void main(String[] args) throws IOException {
        URL link = new URL("http://d3dsacqprgcsqh.cloudfront.net/photo/aozrdx0_700b.jpg");

        InputStream in = new BufferedInputStream(link.openStream());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        byte[] buf = new byte[1024];
        int n = 0;

        while ((n = in.read(buf)) != -1) {
            out.write(buf, 0, n);
        }

        out.close();
        in.close();
        byte[] response = out.toByteArray();

        FileOutputStream fos = new FileOutputStream("haha.jpg");
        fos.write(response);
        fos.close();
    }
}