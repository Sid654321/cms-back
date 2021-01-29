package com.sst.controller;

import com.sst.utils.RequestUtils;
import com.sst.utils.Result;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {

    @PostMapping("uploadFile")
    public Result upload(@RequestParam("file")MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        //获取文件名
        String originalFilename = multipartFile.getOriginalFilename();
        //获取文件名后缀
        String ext = originalFilename.substring(originalFilename.lastIndexOf(".") + 1, originalFilename.length());
        //创建新文件名
        String newFileName = UUID.randomUUID().toString()+"."+ext;

        File targetFile = new File("//usr//local//upload//",newFileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }

        String esxfd = null;
        try {
            multipartFile.transferTo(targetFile);
        }catch (Exception e){
            esxfd = targetFile.getPath()+"|||||"+e.getLocalizedMessage();
        }


        //返回可访问的全路径
        return Result.success(RequestUtils.getBasePath(request)+"upload/"+newFileName);
    }
}
