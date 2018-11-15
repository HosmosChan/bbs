package com.bbs.post.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import com.bbs.utils.GETuuid;

/**
 * @author:tanglei
 * @Create time:2018年8月23日
 * @ClassName:
 * @Description:
 */
@Component
public class ImageUploader {
    @Value("${imagepath}")
    private String imagePath;

    public String uploadImage(MultipartFile file) {
        String fileName = GETuuid.getUUID();
        String dayDir = DateFormatUtils.format(Calendar.getInstance(), "yyyyMMdd");
        File target = new File(imagePath + "/" + dayDir);
        if (!target.exists() || !target.isDirectory()) {
            target.mkdirs();
        }
        File imageFile = new File(imagePath + "/" + dayDir
                + "/" + fileName);
        try {
            IOUtils.copy(file.getInputStream(), new FileOutputStream(imageFile));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dayDir + "/" + fileName;
    }
}