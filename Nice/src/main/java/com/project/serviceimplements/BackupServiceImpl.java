package com.project.serviceimplements;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.models.Backup;
import com.project.repository.BackupRepository;
import com.project.service.BackupService;


@Service
public class BackupServiceImpl implements BackupService {
	
	
	@Autowired
	private BackupRepository backupRepository;
	
	@Override
    public List<Backup> getAllCustomerBackupData() {
        // Retrieve all backup data from the database
        return backupRepository.findAll();
    }
}
