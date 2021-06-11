package _2_demo_._3_demo_;

import java.io.*;

/**
 * description :
 *
 * @author jinchao.hu
 * @date 2021/6/9  13:38
 */
public class FileDemo {

    public static void main(String[] args) {
        String rootPath = System.getProperty("user.dir");
        // in
        String filePath = "/book/鲸书/test.pdf";
        String url = rootPath + filePath;
        // out
        String filePath2 = "/book/鲸书/test2.pdf";
        String url2 = rootPath + filePath2;
        BufferedReader br = null;
        BufferedWriter bw = null;
        // read by byte stream
        try (FileInputStream in = new FileInputStream(url);
             FileOutputStream out = new FileOutputStream(url2)) {
//
//            byte[] line = new byte[1024];
//            int flg;
//            while ( (flg = in.read(line)) != -1 ) {
//                out.write(line , 0 , line.length);
//                out.flush();
//            }
            br = new BufferedReader(new InputStreamReader(in));
            bw = new BufferedWriter(new FileWriter(url2));
            String line = null;
            while ((line = br.readLine()) != null) {
                System.err.println(line);
                bw.write(line);
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(bw != null)
                    bw.close();
                if (br != null)
                    br.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
