package com.jac.billocr;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Base64;

public class test {
    public static void main(String[] args) {
        String url = "http://192.168.19.229:29200/v1.0/ocr/mvs-invoice";
        try (InputStream in = new FileInputStream("C:\\Users\\20220572\\Documents\\WeChat Files\\wxid_crnulw86i02f12\\FileStorage\\File\\2023-04\\2020\\附件5：车辆发票图片\\车辆发票VIN-LJ1EEASP0L4714551.jpg");
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            //建一个空的字节数组
            byte[] result = null;
            byte[] buf = new byte[1024];
            //用来定义一个准备接收图片总长度的局部变量
            int len;
            //将流的内容读取到buf内存中
            while ((len = in.read(buf)) > 0) {
                //将buf内存中的内容从0开始到总长度输出出去
                out.write(buf, 0, len);
            }
            //将out中的流内容拷贝到一开始定义的字节数组中
            result = out.toByteArray();
            //通过util包中的Base64类对字节数组进行base64编码
            String base64 = Base64.getEncoder().encodeToString(result);
            //System.out.println(base64);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
