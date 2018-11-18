package com.FileIO.Utils;

import com.FileIO.Dto.fileItemDto;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
/**
 * 解析 request 的工具类
 * 解析 request，并把 fileItem 保存到 paramDto
 */
public class ParseRequestUtil {
    public static fileItemDto parse(HttpServletRequest request) throws Exception{
        fileItemDto fileItemDto = new fileItemDto();
        ServletFileUpload fileUpload = new ServletFileUpload(new DiskFileItemFactory());
        List<FileItem> fileItems = fileUpload.parseRequest(request);
        for(FileItem fileItem : fileItems) {
            if (!fileItem.isFormField()) {
                fileItemDto.addFileItem(fileItem.getFieldName(), fileItem);
            } else {
                fileItemDto.addFileItem(fileItem.getFieldName(),fileItem);
            }
        }
        return fileItemDto;
    }
}
