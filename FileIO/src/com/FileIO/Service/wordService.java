package com.FileIO.Service;

import org.apache.commons.fileupload.FileItem;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.exceptions.OLE2NotOfficeXmlFileException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

/**
 * 处理word文档的业务类
 */
public class wordService {

    /**
     * 解析普通表单项
     */
    public String parseFormfield(FileItem fileItem) throws Exception{
        return fileItem.getString("UTF-8");
    }

    /**
     * 解析上传的word文档
     */
    public String parseDocument(FileItem fileItem) throws Exception {
        try {
            XWPFWordExtractor xwpfWordExtractor = new XWPFWordExtractor(OPCPackage.open(fileItem.getInputStream()));
            return xwpfWordExtractor.getText().replaceAll("\n", "<br/>");
        } catch (OLE2NotOfficeXmlFileException e) {
            System.out.println("上传文件非07版本，使用03版本解析");
            WordExtractor wordExtractor = new WordExtractor(fileItem.getInputStream());
            StringBuilder builder = new StringBuilder();
            String[] paragraphText = wordExtractor.getParagraphText();
            for(String s : paragraphText) {
                builder.append(s).append("<br/>");
            }
            return builder.toString();
        }
    }

    /**
     * 导出03版的word
     */
    public HWPFDocument export03(Map<String,String> paramMap,String templatePath) throws Exception{
        FileInputStream is = new FileInputStream(templatePath);
        HWPFDocument hwpfDocument = new HWPFDocument(is);
        for(Map.Entry<String,String> entry : paramMap.entrySet()) {
            hwpfDocument.getRange().replaceText(entry.getKey(),entry.getValue());
        }
        return hwpfDocument;
    }

    /**
     * 导出07版的word
     */
    public XWPFDocument export07(Map<String,String> paramMap,String templatePath) throws Exception {
        XWPFDocument xwpfDocument = new XWPFDocument(new FileInputStream(templatePath));
        List<XWPFParagraph> paragraphs = xwpfDocument.getParagraphs();
        for(Map.Entry<String,String> entry : paramMap.entrySet()) {
            for(XWPFParagraph paragraph : paragraphs) {
                for(XWPFRun run : paragraph.getRuns()) {
                    if ((run.toString()).equals(entry.getKey())) {
                        run.setText(entry.getValue(),0);
                        break;
                    }
                }
            }
        }
        return xwpfDocument;
    }
}
