package com.fsh.lecturesystem.service.impl;

import com.fsh.lecturesystem.converter.GroupAssignedUserConverter;
import com.fsh.lecturesystem.dto.GroupAssignedUserDTO;
import com.fsh.lecturesystem.entity.GroupAssignedUserEntity;
import com.fsh.lecturesystem.repository.GroupAssignedUserRepository;
import com.fsh.lecturesystem.service.GroupAssignedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroupAssignedUserServiceImpl implements GroupAssignedUserService {

    @Autowired
    GroupAssignedUserConverter groupAssignedUserConverter;

    @Autowired
    GroupAssignedUserRepository groupAssignedUserRepository;


    @Override
    public GroupAssignedUserDTO saveGroupAssignedUser(GroupAssignedUserDTO groupAssignedUserDTO) {
        GroupAssignedUserEntity groupAssignedUserEntity = groupAssignedUserConverter.convertDTOtoEntity(groupAssignedUserDTO);
        groupAssignedUserEntity = groupAssignedUserRepository.save(groupAssignedUserEntity);
        return groupAssignedUserConverter.convertEntityToDTO(groupAssignedUserEntity);
    }

    @Override
    public GroupAssignedUserDTO getGroupAssignedUser(Long userId, Long groupId) {
        Optional<GroupAssignedUserEntity> groupAssignedUserEntity = groupAssignedUserRepository.getGroupAssignedUserEntity(userId, groupId);
        GroupAssignedUserDTO groupAssignedUserDto = null;
        if(groupAssignedUserEntity.isPresent()){
            groupAssignedUserDto = groupAssignedUserConverter.convertEntityToDTO(groupAssignedUserEntity.get());
        }
        return groupAssignedUserDto;
    }

    @Override
    public List<GroupAssignedUserDTO> getAllGroupAssignedUsers() {
        List<GroupAssignedUserEntity> groupAssignedUserEntityList = (List<GroupAssignedUserEntity>) groupAssignedUserRepository.findAll();
        List<GroupAssignedUserDTO> groupAssignedUserDTOList = new ArrayList<>();
        for(GroupAssignedUserEntity groupAssignedUserEntity : groupAssignedUserEntityList){
            GroupAssignedUserDTO groupAssignedUserDTO = groupAssignedUserConverter.convertEntityToDTO(groupAssignedUserEntity);
            groupAssignedUserDTOList.add(groupAssignedUserDTO);
        }
        return groupAssignedUserDTOList;
    }

    @Override
    public void deleteGroupAssignedUser(Long userId, Long groupId) {
        groupAssignedUserRepository.deleteGroupAssignedUserEntity(userId, groupId);
    }
}
