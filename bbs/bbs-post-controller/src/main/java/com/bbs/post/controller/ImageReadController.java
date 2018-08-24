package com.bbs.post.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbs.utils.CodingUtil;

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
	
	@Value("${imagepath}")
	private String imagePath;

	@RequestMapping("/read")
	public void readImg(HttpServletRequest request, HttpServletResponse response) {
		String image = request.getParameter("path");
		FileInputStream input = null;
		OutputStream output = null;
		try {
			File imgFile = new File(imagePath + "/" + image);
			if(null == imgFile || !imgFile.exists() || imgFile.isDirectory()) {
				imgFile = new File(imagePath + "/logo.png");
			}
			
			input = new FileInputStream(imgFile);
//			String key = CodingUtil.md5(imgFile.getAbsolutePath());
//			byte[] imgBuffer = IOUtils.toByteArray(input);
//			bufferCache.put(key, imgBuffer);1
			output = response.getOutputStream();
			IOUtils.copy(input, output);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			IOUtils.closeQuietly(input);
			IOUtils.closeQuietly(output);
		}
	}
	
}
