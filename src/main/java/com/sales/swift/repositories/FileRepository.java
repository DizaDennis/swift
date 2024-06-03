package com.sales.swift.repositories;

import com.sales.swift.entities.FileModal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileModal, Long> {

}
