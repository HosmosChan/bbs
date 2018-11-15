package com.bbs.post.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:tanglei
 * @Create time:2018年8月23日
 * @ClassName:
 * @Description:
 */
@Controller
@RequestMapping("/img")
public class ImageReadController {
    //	private ConcurrentHashMap<String, byte[]> bufferCache = new ConcurrentHashMap<>();
    private static Logger logger = LogManager.getLogger(ImageReadController.class);
    @Value("${imagepath}")
    private String imagePath;

    @RequestMapping("/read")
    public void readImg(HttpServletRequest request, HttpServletResponse response) {
        String image = request.getParameter("path");
        FileInputStream input = null;
        OutputStream output = null;
        try {
            File imgFile = new File(imagePath + "/" + image);
            if (null == imgFile || !imgFile.exists() || imgFile.isDirectory()) {
                imgFile = new File(imagePath + "/logo.png");
            }
            input = new FileInputStream(imgFile);
//			String key = CodingUtil.md5(imgFile.getAbsolutePath());
//			byte[] imgBuffer = IOUtils.toByteArray(input);
//			bufferCache.put(key, imgBuffer);1
            output = response.getOutputStream();
            IOUtils.copy(input, output);
        } catch (IOException e) {
            //e.printStackTrace();
            logger.info("没有找到对应的图片");
        } finally {
            IOUtils.closeQuietly(input);
            IOUtils.closeQuietly(output);
        }
    }
}