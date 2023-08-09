package ru.suntcova.diploma.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.suntcova.diploma.entity.File;
import ru.suntcova.diploma.exceprions.InputDataException;
import ru.suntcova.diploma.repositories.CloudRepository;


@Service
@RequiredArgsConstructor
public class StorageService {
    private final CloudRepository cloudRepository;
    private final FileService fileService;

    private static final Logger log = Logger.getLogger(StorageService.class);


    private void checkFileName(String fileName) {
        if (fileName == null) {
            log.error("Error input data: fileName == null");
            throw new InputDataException("Error input data");
        }
    }

    @Transactional
    public void saveFile(String username, byte[] file, String fileName) {
        checkFileName(fileName);
        cloudRepository.saveFileToRepository(file, fileName, username);
        File newFile = new File(fileName, file.length, username);
        fileService.save(newFile);
        log.info("Save new File: " + fileName);
    }

    @Transactional
    public void deleteFile(String username, String fileName) {
        checkFileName(fileName);
        fileService.deleteByFileNameAndUsername(fileName, username);
        log.info("File deleted: " + fileName);
    }


    public byte[] downloadFile(String username, String fileName) {
        checkFileName(fileName);
        return cloudRepository.downloadFileFromRepository(fileName, username);
    }

    @Transactional
    public void renameFile(String username, String fileName, String newFileName) {
        checkFileName(fileName);
        checkFileName(newFileName);
        cloudRepository.renameFile(fileName, newFileName, username);
        fileService.renameFile(fileName, newFileName, username);
        log.info("Rename File: oldName: " + fileName + ", newName: " + newFileName);
    }

}