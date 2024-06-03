package com.sales.swift.service;

import com.sales.swift.entities.FileModal;

import java.util.List;

public interface FileService {

    List<FileModal> getAllFiles();

    void saveAllFilesList(List<FileModal> fileList);
}
