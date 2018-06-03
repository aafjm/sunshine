package com.example.demo.controller;

import com.example.demo.bean.jo.ReturnJo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;


/**
 * Created by fengjiamin on 2018/4/22.
 */
@Controller
@RequestMapping(value = "/extra")
public class ExtraController {


    //private String filePath = "/Users/fengjiamin/Desktop/little/";
    private String filePath = "E:\\web\\sillydog\\";
    private String fileUrl = "localhost:8888git s/image/";

    @RequestMapping(value = "/ajax-upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    @ResponseBody
    public Object uploadFile(@RequestParam(value = "file") MultipartFile file) {
        if (file.isEmpty()) {
            return new ReturnJo(false, "文件不能为空", 503, null);
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取文件的后缀名
        // String suffixName = fileName.substring(fileName.lastIndexOf("."));

        // 解决中文问题，liunx下中文路径，图片显示问题
        File dest = new File(filePath + fileName);

        try {
            file.transferTo(dest);
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return new ReturnJo(false, "添加失败", 501, null);
        } catch (IOException e) {
            e.printStackTrace();
            return new ReturnJo(false, "添加失败", 502, null);
        }
        return new ReturnJo(true, "添加成功", 200, fileUrl + fileName);
    }

    @RequestMapping("/ajax-test")
    @ResponseBody
    public Object test() {
        return new ReturnJo(true, "添加成功", 200, 1);
    }

    @RequestMapping("/ajax-load")
    @ResponseBody
    public void loadFile(String key, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // String realPath = request.getServletContext().getRealPath(filePath);
        File file = new File(filePath, key);

        if (file.exists()) {
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition",
                    "attachment;fileName=" + key);// 设置文件名
            byte[] buffer = new byte[10240];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
                System.out.println("success");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}



