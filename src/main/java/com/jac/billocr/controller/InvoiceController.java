package com.jac.billocr.controller;

import com.jac.billocr.service.InvoiceService;
import com.jac.billocr.service.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@RequestMapping("/test")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private LicenseService licenseService;

    @PostMapping("/add")
    public void add(){
        Boolean add = true;
        try {
             add = invoiceService.add();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(add){
            System.out.println("success");
        }else
            System.out.println("fail");
    }


    @PostMapping("/add2")
    public void add2(){
        Boolean add = true;
        try {
            add = licenseService.add();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(add){
            System.out.println("success");
        }else
            System.out.println("fail");
    }
}
