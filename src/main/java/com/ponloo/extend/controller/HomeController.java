package com.ponloo.extend.controller;

import com.ponloo.extend.FileToZip;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.*;


@Controller
public class HomeController {

    @RequestMapping("index")
    public String index() {
        return "index";
    }

    @RequestMapping("temp")
    @ResponseBody
    public String temp(){
        return "test";
    }

    @RequestMapping("test")
    @ResponseBody
    public String test(HttpServletRequest request) {
        String user = request.getHeader("user");
        String uppath = request.getServletContext().getRealPath("/upload/");

        File file = new File(uppath + user);
        if (!file.exists()) {
            file.mkdirs();
        }

//        String nm = request.getHeader("name");
        String nm = "name";
        String name;
        try {
            name = java.net.URLDecoder.decode(nm, "utf-8");
            String imgFilePath = file.getPath() + "/" + name + ".png";

            byte[] buffer = new byte[1024 * 1024];

            InputStream input;

            input = request.getInputStream();
            OutputStream output = new FileOutputStream(imgFilePath);
            int bytesRead;
            while ((bytesRead = input.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
            output.close();
            input.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "ok";
    }

    @RequestMapping(value = "zipres",method = RequestMethod.GET)
    @ResponseBody
    public String testZip(HttpServletRequest request) {
        String user = request.getParameter("user");
        String uppath = request.getServletContext().getRealPath("/upload/");
        String updir = uppath + user;
        String downpath = request.getServletContext().getRealPath("/download/");
        String zipname = String.valueOf(System.currentTimeMillis());
        boolean flag = FileToZip.fileToZip(updir, downpath, zipname);
        if (flag) {
            System.out.println("文件打包成功!");
            File filedir = new File(updir);
            if (filedir.exists() && filedir.isDirectory()) {
                String[] children = filedir.list();
                for (int i = 0; i < children.length; i++) {
                    File tmp = new File(updir + "/" + children[i]);
                    if (tmp.exists()) {
                        tmp.delete();
                    }
                }
            }
            // 目录此时为空，可以删除
            filedir.delete();
        } else {
            System.out.println("文件打包失败!");
        }

        return zipname;
    }

}
