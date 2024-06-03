package com.sales.swift.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "filemodal")
public class FileModal {

    private Long id;
    private String name;
    private String content;
    private String fileType;

    public FileModal(){
        super();
    }

    public FileModal(String fileName, String content, String fileType){

        super();
        this.name = fileName;
        this.content = content;
        this.fileType = fileType;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Lob
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
