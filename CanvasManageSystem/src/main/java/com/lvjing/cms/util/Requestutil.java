package com.lvjing.cms.util;

import com.lvjing.cms.entity.Canvas;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * 解析request的工具类
 * 把数据封装到canvas中
 */
public class Requestutil {

    /**
     * 解析request，把数据封装到canvas中
     * @param request request
     * @return canvas
     */
    public static Canvas parseRequest(HttpServletRequest request) {
        String username = (String) request.getSession().getAttribute("username");
        Canvas canvas = new Canvas();
        canvas.setCreateTime(new Date());
        canvas.setCreator(username);

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        try {
            List<FileItem> fileItems = fileUpload.parseRequest(request);
            String value;
            for (FileItem fileItem : fileItems) {
                if (fileItem.isFormField()) {
                    switch (fileItem.getFieldName()) {
                        case "id":
                            value = fileItem.getString("UTF-8");
                            if (value!=null&&!(value.equals(""))) {
                                if (RegexUtil.validateCanvasId(value)) {
                                    canvas.setId(Integer.valueOf(fileItem.getString()));
                                } else {
                                    canvas.setId(null);
                                }
                            } else {
                                canvas.setId(null);
                            }
                            break;
                        case "name":
                            value = fileItem.getString("UTF-8");
                            if (value != null && !(value.equals(""))) {
                                canvas.setName(value);
                            } else {
                                canvas.setName(null);
                            }
                            break;
                        case "categoryId":
                            value = fileItem.getString("UTF-8");
                            if (value!=null&&!(value.equals(""))) {
                                if (RegexUtil.validateCanvasCategoryId(value)) {
                                    canvas.setCategoryId(Integer.valueOf(fileItem.getString()));
                                } else {
                                    canvas.setCategoryId(null);
                                }
                            } else {
                                canvas.setCategoryId(null);
                            }
                            break;
                        case "price":
                            value = fileItem.getString("UTF-8");
                            if (value != null && !(value.equals(""))) {
                                if (RegexUtil.validateCanvasPrice(value)) {
                                    canvas.setPrice(Float.valueOf(fileItem.getString()));
                                } else {
                                    canvas.setPrice(null);
                                }
                            } else {
                                canvas.setPrice(null);
                            }
                            break;
                        case "description":
                            value = fileItem.getString("UTF-8");
                            if (value != null && !(value.equals(""))) {
                                canvas.setDescription(value);
                            } else {
                                canvas.setDescription(null);
                            }
                            break;
                        case "details":
                            value = fileItem.getString("UTF-8");
                            if (value != null && !(value.equals(""))) {
                                canvas.setDetails(value);
                            } else {
                                canvas.setDetails(null);
                            }
                            break;
                    }
                } else {
                    if (fileItem.get().length != 0) {
                        canvas.setSmallImg(fileItem.get());
                    } else {
                        canvas.setSmallImg(null);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("/WEB-INF/views/error/500.jsp");
        }
        return canvas;
    }

}
