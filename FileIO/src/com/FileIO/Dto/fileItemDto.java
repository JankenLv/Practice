package com.FileIO.Dto;

import org.apache.commons.fileupload.FileItem;

import java.util.HashMap;
import java.util.Map;

/**
 * 保存FileItem的Dto
 */
public class fileItemDto {
    private Map<String,FileItem> fileItemMap;

    public fileItemDto() {
        fileItemMap = new HashMap<>();
    }

    public Map<String, FileItem> getFileItemMap() {
        return fileItemMap;
    }

    public void addFileItem(String name, FileItem fileItem) {
        fileItemMap.put(name,fileItem);
    }

}
