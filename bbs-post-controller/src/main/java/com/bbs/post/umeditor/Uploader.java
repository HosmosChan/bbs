package com.bbs.post.umeditor;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.commons.fileupload.util.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * UEditor文件上传辅助类
 */
@Component
public class Uploader {
    @Value("${imagepath}")
    private String imagePath;
    // 输出文件地址
    private String url = "";
    // 上传文件名
    private String fileName = "";
    // 状态
    private String state = "";
    // 文件类型
    private String type = "";
    // 原始文件名
    private String originalName = "";
    // 文件大小
    private long size = 0;
    private String title = "";
    // 保存路径
    private String savePath = "upload";
    // 文件允许格式
    private String[] allowFiles = {".rar", ".doc", ".docx", ".zip", ".pdf", ".txt", ".swf", ".wmv", ".gif", ".png", ".jpg", ".jpeg", ".bmp"};
    // 文件大小限制，单位KB
    private int maxSize = 10000;
    private HashMap<String, String> errorInfo = new HashMap<String, String>();

    public Uploader() {
        HashMap<String, String> tmp = this.errorInfo;
        tmp.put("SUCCESS", "SUCCESS"); //默认成功
        tmp.put("NOFILE", "未包含文件上传域");
        tmp.put("TYPE", "不允许的文件格式");
        tmp.put("SIZE", "文件大小超出限制");
        tmp.put("ENTYPE", "请求类型ENTYPE错误");
        tmp.put("REQUEST", "上传请求异常");
        tmp.put("IO", "IO异常");
        tmp.put("DIR", "目录创建失败");
        tmp.put("UNKNOWN", "未知错误");
    }

    /**
     * 重写upload方法，解决访问controller中的上传方法时获取不到上传文件的问题
     *
     * @param upfile
     * @throws Exception
     */
    public void upload(MultipartFile upfile) throws Exception {
        if (upfile == null) {
            this.state = this.errorInfo.get("NOFILE");
            return;
        }
        String savePath = this.getFolder(this.savePath);
        try {
            this.originalName = upfile.getOriginalFilename().substring(upfile.getOriginalFilename().lastIndexOf(System.getProperty("file.separator")) + 1);
            if (!this.checkFileType(this.originalName)) {
                this.state = this.errorInfo.get("TYPE");
                return;
            }
            this.fileName = this.getName(this.originalName);
            this.type = this.getFileExt(this.fileName);
            this.url = savePath + "/" + this.fileName;
            BufferedInputStream in = new BufferedInputStream(upfile.getInputStream());
            File file = new File(this.getPhysicalPath(this.url));
            FileOutputStream out = new FileOutputStream(file);
            BufferedOutputStream output = new BufferedOutputStream(out);
            Streams.copy(in, output, true);
            this.state = this.errorInfo.get("SUCCESS");
            this.size = file.length();
        } catch (Exception e) {
            this.state = this.errorInfo.get("UNKNOWN");
        }
    }

    /**
     * 文件类型判断
     *
     * @param fileName
     * @return
     */
    private boolean checkFileType(String fileName) {
        Iterator<String> type = Arrays.asList(this.allowFiles).iterator();
        while (type.hasNext()) {
            String ext = type.next();
            if (fileName.toLowerCase().endsWith(ext)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取文件扩展名
     *
     * @return string
     */
    private String getFileExt(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 依据原始文件名生成新文件名
     *
     * @return
     */
    private String getName(String fileName) {
        Random random = new Random();
        return this.fileName = "" + random.nextInt(10000)
                + System.currentTimeMillis() + this.getFileExt(fileName);
    }

    /**
     * 根据字符串创建本地目录 并按照日期建立子目录返回
     *
     * @param path
     * @return
     */
    private String getFolder(String path) {
        SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
        path += "/" + formater.format(new Date());
        File dir = new File(this.getPhysicalPath(path));
        if (!dir.exists()) {
            try {
                dir.mkdirs();
            } catch (Exception e) {
                this.state = this.errorInfo.get("DIR");
                return "";
            }
        }
        return path;
    }

    /**
     * 根据传入的虚拟路径获取物理路径
     *
     * @param path
     * @return
     */
    private String getPhysicalPath(String path) {
        /*String servletPath = this.request.getServletPath();
        String realPath = this.request.getSession().getServletContext()
                .getRealPath(servletPath);
        return new File(realPath).getParent() +"/" +path;*/
        //return this.request.getSession().getServletContext().getRealPath("/") + path;
        return imagePath + "/" + path;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public void setAllowFiles(String[] allowFiles) {
        this.allowFiles = allowFiles;
    }

    public void setMaxSize(int size) {
        this.maxSize = size;
    }

    public long getSize() {
        return this.size;
    }

    public String getUrl() {
        return this.url;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getState() {
        return this.state;
    }

    public String getTitle() {
        return this.title;
    }

    public String getType() {
        return this.type;
    }

    public String getOriginalName() {
        return this.originalName;
    }
}