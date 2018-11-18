package net.xdclass.demo.controller;

import net.xdclass.demo.bean.ResponseDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Controller
public class IndexController {

    private static final String path = "C:\\Users\\lvjin\\Desktop\\";

    @RequestMapping("/index")
    public String home(){
        return "index";
    }

    @RequestMapping(path = "to_upload",method = RequestMethod.GET)
    public String toUploadFile(){
        return "upload";
    }


    @RequestMapping(method = RequestMethod.POST,value = "upload")
    @ResponseBody
    public ResponseDTO uploadFile(@RequestParam("upload_file") MultipartFile file) {
        System.out.println("文件大小：" + file.getSize()/1024);
        /*if (file.getSize()/1024 > 10240) {
            return new ResponseDTO("文件大于1024KB，无法上传！");
        }*/

        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = UUID.randomUUID() + suffix;
        System.out.println("文件名：" + fileName);

        File desk = new File(path + fileName);
        System.out.println("文件保存路径：" + desk);
        try {
            file.transferTo(desk);
            return new ResponseDTO("file name: " + fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseDTO("fail to save!");
    }
}
