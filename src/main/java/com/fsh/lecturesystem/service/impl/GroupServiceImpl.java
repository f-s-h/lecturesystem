package com.fsh.lecturesystem.service.impl;

import com.fsh.lecturesystem.converter.GroupConverter;
import com.fsh.lecturesystem.dto.GroupDTO;
import com.fsh.lecturesystem.entity.GroupEntity;
import com.fsh.lecturesystem.repository.GroupRepository;
import com.fsh.lecturesystem.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupConverter groupConverter;

    @Autowired
    GroupRepository groupRepository;


    @Override
    public GroupDTO saveGroup(GroupDTO groupDTO) {
        GroupEntity groupEntity = groupConverter.convertDTOtoEntity(groupDTO);
        groupEntity = groupRepository.save(groupEntity);
        return groupConverter.convertEntityToDTO(groupEntity);
    }

    @Override
    public GroupDTO getGroup(Long id) {
        Optional<GroupEntity> groupEntity = groupRepository.findById(id);
        GroupDTO groupDto = null;
        if(groupEntity.isPresent()){
            groupDto = groupConverter.convertEntityToDTO(groupEntity.get());
        }
        return groupDto;
    }

    @Override
    public List<GroupDTO> getAllGroups() {
        List<GroupEntity> groupEntityList = (List<GroupEntity>) groupRepository.findAll();
        List<GroupDTO> groupDTOList = new ArrayList<>();
        for(GroupEntity groupEntity : groupEntityList){
            GroupDTO groupDTO = groupConverter.convertEntityToDTO(groupEntity);
            groupDTOList.add(groupDTO);
        }
        return groupDTOList;
    }

    @Override
    public void deleteGroup(Long id) {
        groupRepository.deleteById(id);
    }
}
