package com.lvjing.songlist.servlet;

import com.google.common.base.Objects;
import com.lvjing.songlist.entity.Picture;
import com.lvjing.songlist.service.SongService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 测试保存上传的图片到数据库
 */
@WebServlet(urlPatterns = {"/savePicture","/checkPicture"})
public class SavePictureServlet extends HttpServlet {

    private SongService songService;

    @Override
    public void init() throws ServletException {
        super.init();
        songService = SongService.getInstance();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Objects.equal("/savePicture",request.getServletPath())) {
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
            try {
                List<FileItem> fileItems = fileUpload.parseRequest(request);
                for (FileItem fileItem : fileItems) {
                    if (!fileItem.isFormField()) {
                        byte[] bytes = fileItem.get();
                        int result = songService.savePicture(new Picture(bytes));
                        System.out.println(result);
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
        }else if (Objects.equal("/checkPicture",request.getServletPath())) {
            Picture picture = songService.getPicture(1);
            byte[] bytes = picture.getPicture();
            if (bytes.length!=0) {
//                response.setContentType("multipart/form-data");
//                response.setContentType("image/png");
                ServletOutputStream os = response.getOutputStream();
                response.setContentType("image/jpg");

                InputStream is = new ByteArrayInputStream(bytes);
                byte[] b = new byte[1024];
                int length = is.read(b);
                while (length != -1) {
                    os.write(b);
                    length = is.read(b);
                }

                os.write(bytes);
                os.flush();
                is.close();
                os.close();
            }
        }
    }

    /*@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
        try {
            List<FileItem> fileItems = fileUpload.parseRequest(request);
            for (FileItem fileItem : fileItems) {
                if (!fileItem.isFormField()) {
                    byte[] bytes = fileItem.get();
                    int result = songService.savePicture(new Picture(bytes));
                    System.out.println(result);
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }*/

    @Override
    public void destroy() {
        songService = null;
    }
}
