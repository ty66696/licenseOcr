package com.jac.billocr.util;

import com.huaweicloud.sdk.core.auth.BasicCredentials;
import com.huaweicloud.sdk.core.auth.ICredential;
import com.huaweicloud.sdk.core.exception.ConnectionException;
import com.huaweicloud.sdk.core.exception.RequestTimeoutException;
import com.huaweicloud.sdk.core.exception.ServiceResponseException;
import com.huaweicloud.sdk.core.http.HttpConfig;
import com.huaweicloud.sdk.ocr.v1.OcrClient;
import com.huaweicloud.sdk.ocr.v1.model.InvoiceVerificationRequestBody;
import com.huaweicloud.sdk.ocr.v1.model.RecognizeInvoiceVerificationRequest;
import com.huaweicloud.sdk.ocr.v1.model.RecognizeInvoiceVerificationResponse;
import com.huaweicloud.sdk.ocr.v1.region.OcrRegion;


import java.util.Map;

public class verificationUtil {
    private static final String ak="M0VFLWQO2ZJ9GXB3DADQ";
    private static final String sk="0a0BvPdwGhJl7nXXYicx6SM5eFIsvIL44q5OezGc";
    public static boolean Verification(Map map){
        HttpConfig config = HttpConfig.getDefaultHttpConfig();
        // 初始化客户端认证信息，使用当前客户端初始化方式可不填 projectId/domainId
        ICredential auth = new BasicCredentials()
                .withAk(ak)
                .withSk(sk);
        // 初始化指定云服务的客户端 {Service}Client ，以初始化OCR服务的 OcrClient 为例
        OcrClient client = OcrClient.newBuilder()
                .withHttpConfig(config)
                .withCredential(auth)
                .withRegion(OcrRegion.valueOf("cn-north-4"))
                .build();

        RecognizeInvoiceVerificationRequest request = new RecognizeInvoiceVerificationRequest();
        InvoiceVerificationRequestBody body=new InvoiceVerificationRequestBody();
        //System.out.println(map);
        if(map.get("code")!=null&&map.get("code").toString().length()>0)
            body.setCode(map.get("code").toString());
        else
            body.setCode("-1");
        if(map.get("number")!=null&&map.get("number").toString().length()>0)
            body.setNumber(map.get("number").toString());
        else
            body.setNumber("-1");
        if(map.get("issue_date")!=null&&map.get("issue_date").toString().length()>0)
            body.setIssueDate(map.get("issue_date").toString());
        else
            body.setIssueDate("-1");
        //body.setCheckCode("");
        if (map.get("tax_exclusive_price")!=null&&map.get("tax_exclusive_price").toString().length()>0)
            body.setSubtotalAmount(map.get("tax_exclusive_price").toString().substring(1));
        else
            body.setSubtotalAmount("-1");

        //System.out.println("----------------------------");
        //System.out.println(body);
        request.withBody(body);
        String result_code = null;
        String type = null;
        try {
            RecognizeInvoiceVerificationResponse response = client.recognizeInvoiceVerification(request);
            Map<String,String> m=(Map<String,String>)response.getResult();
            //System.out.println("------------------------");
            //System.out.println(m.getClass());
            //System.out.println(m);
            result_code= m.get("result_code");
            type = m.get("type");
            //System.out.println("result_code="+result_code+"  "+"type="+type);
        } catch (ConnectionException e) {
            e.printStackTrace();
        } catch (RequestTimeoutException e) {
            e.printStackTrace();
        } catch (ServiceResponseException e) {
            e.printStackTrace();
            System.out.println(e.getHttpStatusCode());
            System.out.println(e.getErrorCode());
            System.out.println(e.getErrorMsg());
        }
        if("1000".equals(result_code)&&"motor_vehicle_sales".equals(type))
            return true;
        else
            return false;
    }
}
