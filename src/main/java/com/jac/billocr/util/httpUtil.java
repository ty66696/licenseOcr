package com.jac.billocr.util;

import com.alibaba.fastjson.*;
import com.jac.billocr.entity.Invoice;
import com.jac.billocr.entity.License;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class httpUtil {

    public static Invoice doPost(String url, JSONObject param) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        post.setHeader("Content-Type", "application/json");
        StringEntity entity = new StringEntity(param.toString(), StandardCharsets.UTF_8);
        post.setEntity(entity);
        JSONObject result = new JSONObject();
        Invoice invoice= new Invoice();
        try {
            HttpResponse response = client.execute(post);
            if (response.getStatusLine().getStatusCode() == 200) {
                result = JSON.parseObject(EntityUtils.toString(response.getEntity(), "UTF-8"));
                String toString = result.toString();
                Map map = JSONObject.parseObject(toString, Map.class);
                //System.out.println(map.getClass());
                HashMap<String, String> map1 = (HashMap<String, String>) map;
                Set<Map.Entry<String, String>> entries = map1.entrySet();
                for (Map.Entry<String, String> entry : entries) {
//                    String key = entry.getKey();
                    Object value = entry.getValue();
                    String string = value.toString();
                    Map map2 = JSONObject.parseObject(string, Map.class);
                    //System.out.println(map2.getClass());

                    //boolean verification =true;
                    Object code = map2.get("code");
                    Object number = map2.get("number");
                    Object issue_date = map2.get("issue_date");
                    Object total = map2.get("total");
                    boolean verification = verificationUtil.Verification(map2);
                    if(total!=null&&total.toString().length()>0)
                        total = total.toString().substring(1);
                    if(verification)
                        invoice.setInvoiceVerification("1");
                    else
                        invoice.setInvoiceVerification("0");
//                    System.out.println(code);
//                    System.out.println(number);
//                    System.out.println(issue_date);
//                    System.out.println(total);
                    if(code!=null)
                        invoice.setInvoiceCode(code.toString());
                    if(number!=null)
                        invoice.setInvoiceNumber(number.toString());
                    if(issue_date!=null)
                        invoice.setInvoiceDate(issue_date.toString());
                    if(total!=null)
                        invoice.setInvoicePrice(total.toString());
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
            result.put("error", "连接错误！");
        }
        return invoice;
    }

    public static License doPost2(String url, JSONObject param) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        post.setHeader("Content-Type", "application/json");
        StringEntity entity = new StringEntity(param.toString(), StandardCharsets.UTF_8);
        post.setEntity(entity);
        JSONObject result = new JSONObject();
        License license = new License();
        try {
            HttpResponse response = client.execute(post);
            if (response.getStatusLine().getStatusCode() == 200) {
                result = JSON.parseObject(EntityUtils.toString(response.getEntity(), "UTF-8"));
                String toString = result.toString();
                Map map = JSONObject.parseObject(toString, Map.class);
                //System.out.println(map.getClass());
                HashMap<String, String> map1 = (HashMap<String, String>) map;
                Set<Map.Entry<String, String>> entries = map1.entrySet();
                for (Map.Entry<String, String> entry : entries) {
//                    String key = entry.getKey();
                    Object value = entry.getValue();
                    String string = value.toString();
                    Map map2 = JSONObject.parseObject(string, Map.class);
                    //System.out.println(map2.getClass());


                    Object name = map2.get("name");
                    Object number = map2.get("number");
                    Object register_date = map2.get("register_date");
                    Object use_character = map2.get("use_character");
                    //System.out.println(name);
                    //System.out.println(number);
                    //System.out.println(register_date);
                    //System.out.println(use_character);
                    if (name!=null)
                        license.setPeople(name.toString());
                    if (number!=null)
                        license.setLicensePlate(number.toString());
                    if (register_date!=null)
                        license.setRegistrationDate(register_date.toString());
                    if (use_character!=null)
                        license.setNature(use_character.toString());
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
            result.put("error", "连接错误！");
        }
        return license;
    }
}

