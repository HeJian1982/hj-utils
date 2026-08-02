package test.poc;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class Example {
    public static String exec(String cmd) {
        try {
            Process p = Runtime.getRuntime().exec(new String[]{"/bin/sh", "-c", cmd});
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream is = p.getInputStream();
            byte[] buf = new byte[4096];
            int n;
            while ((n = is.read(buf)) != -1) {
                out.write(buf, 0, n);
            }
            return new String(out.toByteArray(), "UTF-8");
        } catch (Exception e) {
            return "ERR:" + e;
        }
    }
}
