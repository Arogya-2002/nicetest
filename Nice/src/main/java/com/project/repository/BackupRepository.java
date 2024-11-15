package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.models.Backup;

public interface BackupRepository extends JpaRepository<Backup, Long> {

}
