package com.ivo.onlineshopping.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

public class FileUploadUtil {

    private static final String ABS_PATH = "F:\\Programming\\Java\\Projects-Web\\Spring framework\\OnlineShopping\\ProjectOnlineShopping\\src\\main\\webapp\\resources\\assets\\images\\";
    private static String REAL_PATH = "";

    private static final Logger logger = LoggerFactory.getLogger(FileUploadUtil.class);

    public static void uploadFile(HttpServletRequest request,
                                  MultipartFile file,
                                  String code)
    {
        // get real path
        REAL_PATH = request.getSession().getServletContext().getRealPath("/resources/assets/images/");
        logger.info(REAL_PATH);

        // directories exists
        // another, create the directories
        File abs_file = new File(ABS_PATH);
        if (!abs_file.exists()) {
            // create the directories
            abs_file.mkdirs();
        }

        File real_file = new File(REAL_PATH);
        if (!real_file.exists()) {
            // create the directories
            real_file.mkdirs();
        }

        try {
            // server upload
            file.transferTo(new File(REAL_PATH + code + ".jpg"));
            // project directory upload
            file.transferTo(new File(ABS_PATH + code + ".jpg"));
        } catch (IOException ex) {

        }

    }
}
