package com.fengzhiwei.photo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/photo")
public class PhotoController {

    @PostMapping("/upload")
    public Map<String, Object> upload(
            @RequestParam("imgFile") MultipartFile file,
            @RequestParam("inch") Integer inch,
            @RequestParam("color") String color
    ) {
        Map<String, Object> result = new HashMap<>();
        Path path = Paths.get("/Users/wei/Documents/learn/temp");
        try {
            // FilenameUtils.getExtension() 这个方法是Apache Commons IO库中的一个工具方法，可以快速、安全地获取文件的扩展名。
            Files.createDirectories(path);
            Path temp = Path.of(path.toString(), "666.jpg");
            file.transferTo(new File(temp.toUri()));

            List<String> command = new ArrayList<>();
            command.add("python3"); // 指定要执行的Python解释器
            command.add("photo/one.py"); // 指定要执行的Python脚本路径
            command.add(temp.toString()); // 传递的第一个参数（临时图片）
            command.add("/Users/wei/Documents/learn/temp/test.jpg"); // 传递的第二个参数（保存路径）
            command.add(color); // 传递的第三个参数（底色：默认红色）

            callPythonGenerate(command);
            result.put("code", 2000);
            result.put("message", "操作成功");
        } catch (IOException e) {
            // 创建文件夹失败，进行相应的处理
            e.printStackTrace();
            result.put("code", 5000);
            result.put("message", e.getMessage());
        }
        return result;
    }

    private void callPythonGenerate(List<String> command) throws IOException {
        ProcessBuilder pb = new ProcessBuilder(command);
        Process process = pb.start();
        try(
                InputStream inputStream = process.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
