package com.sales.swift.service;

import com.sales.swift.entities.FileModal;
import com.sales.swift.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    FileRepository fileRepository;

    @Override
    public List<FileModal> getAllFiles() {
        return fileRepository.findAll();
    }

    @Override
    public void saveAllFilesList(List<FileModal> fileList) {

        for(FileModal fileModal : fileList)
            fileRepository.save(fileModal);

        }




}
