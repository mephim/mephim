package com.example.mephim.controller;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@RestController
public class AttachmentController {

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        System.out.println(file);
        String downloadURl = "";

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        byte[] fileSize =file.getBytes();
        String contentType = file.getContentType();

        byte[] encoded = Base64.getEncoder().encode(fileSize);

        try {
            File myObj = new File("filename.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write(new String(encoded));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        ResponseData responseData = new ResponseData(fileName, contentType, fileSize);

        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }

    public void write(MultipartFile file, Path dir) {
        Path filepath = Paths.get(dir.toString(), file.getOriginalFilename());

        try (OutputStream os = Files.newOutputStream(filepath)) {
            os.write(file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @PostMapping("/readfile")
    public ResponseEntity<?> readFile(@RequestParam("file") MultipartFile file) throws Exception {
        List<Country> countryList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader((File) file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            countryList = new ArrayList<>();
            while ((line = bufferedReader.readLine())!= null){
                String[] cou = line.split(",");
                countryList.add(new Country(cou[0],cou[1],cou[2],cou[3],cou[4],cou[5]));
            }

            for (Country country: countryList) {
                System.out.println(country);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        return new ResponseEntity<>(countryList,HttpStatus.OK);
    }

    @Data
    @AllArgsConstructor
    static class ResponseData {
        private String fileName;
        private String fileType;
        private byte[] fileSize;
    }

    @Data
    @AllArgsConstructor
    static class Country {
        private String startIp;
        private String endIp;
        private String numStart;
        private String numEnd;
        private String countryCode;
        private String country;
    }
}
