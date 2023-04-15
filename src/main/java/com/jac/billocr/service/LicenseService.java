package com.jac.billocr.service;

import com.alibaba.fastjson.JSONObject;
import com.jac.billocr.entity.License;
import com.jac.billocr.mapper.LicenseMapper;
import com.jac.billocr.util.base64Util;
import com.jac.billocr.util.httpUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;

@Service
public class LicenseService {
    @Autowired
    private LicenseMapper licenseMapper;

    public Boolean add() throws IOException {
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream("C:\\Users\\Lenovo\\Desktop\\ocr\\VIN(2).xlsx"));
        //读取第一个工作表
        XSSFSheet sheet = xssfWorkbook.getSheetAt(2);
        //总行数
        int maxRow = sheet.getLastRowNum();

        License license = new License();

        String url = "http://192.168.19.229:29300/v1.0/ocr/vehicle-license";

        for (int row = 36035; row <= maxRow; row++) {
            String s = sheet.getRow(row).getCell(0) + "";
            System.out.println(s);
            String file = "C:\\Users\\Lenovo\\Desktop\\ocr\\2022\\附件6：车辆行驶证图片\\行驶证VIN-"+s+".jpg";
            JSONObject jsonObject = base64Util.toBase64(file);
            if(jsonObject!=null){
                license = httpUtil.doPost2(url, jsonObject);
                license.setVin(s);
                licenseMapper.add(license);
            }
            System.out.println(row);
        }
        return true;
    }
}
