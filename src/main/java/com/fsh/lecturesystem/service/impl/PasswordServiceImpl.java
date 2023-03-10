package com.fsh.lecturesystem.service.impl;

import com.fsh.lecturesystem.converter.PasswordConverter;
import com.fsh.lecturesystem.dto.PasswordDTO;
import com.fsh.lecturesystem.entity.PasswordEntity;
import com.fsh.lecturesystem.repository.PasswordRepository;
import com.fsh.lecturesystem.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PasswordServiceImpl implements PasswordService {

    @Autowired
    PasswordConverter passwordConverter;

    @Autowired
    PasswordRepository passwordRepository;


    @Override
    public PasswordDTO savePassword(PasswordDTO passwordDTO) {
        PasswordEntity passwordEntity = passwordConverter.convertDTOtoEntity(passwordDTO);
        passwordEntity = passwordRepository.save(passwordEntity);
        return passwordConverter.convertEntityToDTO(passwordEntity);
    }

    @Override
    public PasswordDTO getPassword(Long id) {
        Optional<PasswordEntity> passwordEntity = passwordRepository.findById(id);
        PasswordDTO passwordDto = null;
        if(passwordEntity.isPresent()){
            passwordDto = passwordConverter.convertEntityToDTO(passwordEntity.get());
        }
        return passwordDto;
    }

    @Override
    public List<PasswordDTO> getAllPasswords() {
        List<PasswordEntity> passwordEntityList = (List<PasswordEntity>) passwordRepository.findAll();
        List<PasswordDTO> passwordDTOList = new ArrayList<>();
        for(PasswordEntity passwordEntity : passwordEntityList){
            PasswordDTO passwordDTO = passwordConverter.convertEntityToDTO(passwordEntity);
            passwordDTOList.add(passwordDTO);
        }
        return passwordDTOList;
    }

    @Override
    public void deletePassword(Long id) {
        passwordRepository.deleteById(id);
    }
}
