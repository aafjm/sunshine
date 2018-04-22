package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by fengjiamin on 2018/4/22.
 */
@Controller
@RequestMapping(value = "/extra")
public class ExtraController {


    private String path = "E:\\sunshine\\upload\\";

    @RequestMapping("/upload-file")
    @ResponseBody
    public void uploadFile() {

    }

    @RequestMapping("/load-file")
    @ResponseBody
    public void loadFile(String key) throws Exception {


    }


}
