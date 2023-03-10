package com.fsh.lecturesystem.converter;

import com.fsh.lecturesystem.dto.PasswordDTO;
import com.fsh.lecturesystem.entity.PasswordEntity;
import org.springframework.stereotype.Component;

@Component
public class PasswordConverter {
    public PasswordEntity convertDTOtoEntity(PasswordDTO passwordDTO){
        return new PasswordEntity(passwordDTO.getPasswordHash());
    }

    public PasswordDTO convertEntityToDTO(PasswordEntity passwordEntity){
        return new PasswordDTO(passwordEntity.getUserId(), passwordEntity.getPasswordHash());
    }

}
