package com.fengzhiwei.photo.controller;

import com.fengzhiwei.photo.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/photo")
@Slf4j
public class PhotoController {

    @PostMapping("/verify")
    public Result<Map<String, Object>> verify(@RequestParam("imgFile") MultipartFile file) {
        if (file.getSize() > 3145728) {
            return Result.OK(2002, "图片超过限制大小");
        }

        try {
            // 获取当前日期，用作保存文件夹
            String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            Path path = Path.of("../images/temp", date);

            // 获取毫秒级时间用作临时图片名称
            long tempName = Instant.now().toEpochMilli();
            String extension = FilenameUtils.getExtension(file.getOriginalFilename());

            Files.createDirectories(path);
            Path temp = Path.of(path.toString(), tempName + "." + extension);
            file.transferTo(new File(temp.toUri()));
            List<String> command = new ArrayList<>();
            command.add("python3"); // 指定要执行的Python解释器
            command.add("verify.py"); // 指定要执行的Python脚本路径
            command.add(temp.toString()); // 传递的第一个参数（临时图片）
            int called = callPythonGenerate(command);
            if (called == 0) {
                // 获取毫秒级时间用作用作证件照名称
                long saveName = Instant.now().toEpochMilli();
                String savePath = path + "/" + saveName + "." + extension;
                Map<String, Object> map = new HashMap<>();
                map.put("temp", temp.toString());
                map.put("savePath", savePath);
                return Result.OK(map);
            } else {
                Files.deleteIfExists(Path.of(temp.toUri()));
                return Result.error(4003, "图像验证失败，未检测到人脸");
            }
        } catch (Exception e) {
            log.error("verify ----- {}", e.getMessage());
            return Result.error(5000, "系统异常，联系开发人员");
        }
    }

    @PostMapping("/upload")
    public Result<Void> upload(
            @RequestParam("inch") String inch,
            @RequestParam("color") String color,
            @RequestParam("temp") String temp,
            @RequestParam("savePath") String savePath
    ) {
        try {
            List<String> command = new ArrayList<>();
            command.add("python3"); // 指定要执行的Python解释器
            command.add("one.py"); // 指定要执行的Python脚本路径
            command.add(temp); // 传递的第一个参数（临时图片）
            command.add(savePath); // 传递的第二个参数（保存路径）
            command.add(color); // 传递的第三个参数（底色：默认红色）
            command.add(inch); // 传递的第四个参数（尺寸：295,413）

            int called = callPythonGenerate(command);
            if (called == 0) {
                return Result.OK(2000, "操作成功");
            } else {
                return Result.error(2001, "操作失败");
            }
        } catch (IOException | InterruptedException e) {
            log.error("verify ----- {}", e.getMessage());
            // 创建文件夹失败，进行相应的处理
            return Result.error(5000, "系统异常，联系开发人员");
        }
    }

    private int callPythonGenerate(List<String> command) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder(command);
        Process process = pb.start();

        BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        String error;
        while ((error = stdError.readLine()) != null) {
            log.error(error);
        }
        int exitCode = process.waitFor();
        if (exitCode != 0) {
            log.error("Python script failed with exit code {}", exitCode);
        }
        return exitCode;
    }

}
