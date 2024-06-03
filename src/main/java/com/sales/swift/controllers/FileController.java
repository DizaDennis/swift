package com.sales.swift.controllers;


import com.sales.swift.entities.FileModal;
import com.sales.swift.service.FileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/files")
public class FileController {

    final
    FileServiceImpl fileServiceImpl;

    public FileController(FileServiceImpl fileServiceImpl) {
        this.fileServiceImpl = fileServiceImpl;
    }

    @GetMapping("/getData")
    public String getData(Model model){

        List<FileModal> files = fileServiceImpl.getAllFiles();

        model.addAttribute("files", files);

        return "fileList";
    }

    @GetMapping("/list")
    public String fileList(Model model){

        List<FileModal> files = fileServiceImpl.getAllFiles();

        model.addAttribute("files", files);

        return "fileList";
    }

@GetMapping("/newFile")
public String newFile(Model model){

        FileModal fileModal = new FileModal();
        model.addAttribute("file", fileModal);

        return "file";

}

    @PostMapping("/uploadFile")
    public String uploadMultipartFile(@RequestParam("files") MultipartFile[] files, Model modal){

        try{
            List<FileModal> fileList = new ArrayList<FileModal>();

            for(MultipartFile file : files){
                String fileContentType = file.getContentType();
                String sourceFileContent = new String(file.getBytes(), StandardCharsets.UTF_8);
                String fileName = file.getOriginalFilename();
                FileModal fileModal = new FileModal(fileName, sourceFileContent, fileContentType);

                fileList.add(fileModal);
            }
            fileServiceImpl.saveAllFilesList(fileList);
        } catch(Exception e){
            e.printStackTrace();
        }

        modal.addAttribute("allFiles", fileServiceImpl.getAllFiles());

        return "redirect:/files/list";
    }

}
