package com.jac.billocr.service;

import com.alibaba.fastjson.JSONObject;
import com.jac.billocr.entity.Invoice;
import com.jac.billocr.mapper.InvoiceMapper;
import com.jac.billocr.util.base64Util;
import com.jac.billocr.util.httpUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceMapper invoiceMapper;

    public Boolean add() throws IOException {
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream("C:\\Users\\Lenovo\\Desktop\\ocr\\VIN(2).xlsx"));
        //读取第一个工作表
        XSSFSheet sheet = xssfWorkbook.getSheetAt(2);
        //总行数
        int maxRow = sheet.getLastRowNum();

        Invoice invoice = new Invoice();
        String url = "http://192.168.19.229:29200/v1.0/ocr/mvs-invoice";

        for (int row = 32195; row <= maxRow; row++) {
            String s = sheet.getRow(row).getCell(0) + "";
            System.out.println(s);
            String file = "C:\\Users\\Lenovo\\Desktop\\ocr\\2022\\附件5：车辆发票图片\\车辆发票VIN-"+s+".jpg";
            JSONObject jsonObject = base64Util.toBase64(file);
            if(jsonObject!=null){
                invoice = httpUtil.doPost(url, jsonObject);
                invoice.setVin(s);
                invoiceMapper.add(invoice);
            }
            System.out.println(row);
        }
        return true;
    }
}
