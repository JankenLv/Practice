package com.ljs.export.controller;

import com.ljs.export.service.ImportCSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 导入CSV
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/8 22:06 </p>
 */
@Controller
public class ImportCSVController{

    @Autowired
    private ImportCSVService importCSVService;

    @PostMapping("/api/v1/importCSVWithReader")
    @ResponseBody
    public Object importCSVWithReader(MultipartFile file) throws IOException {
        return importCSVService.getCsvContentWithReader(file.getInputStream());
    }

    @PostMapping("/api/v1/importCSV")
    @ResponseBody
    public Object importCsv(MultipartFile file) throws IOException {
        return importCSVService.getCsvContent(file.getInputStream());
    }

}
