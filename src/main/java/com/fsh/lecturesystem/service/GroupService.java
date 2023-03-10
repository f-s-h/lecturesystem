package com.fsh.lecturesystem.service;

import com.fsh.lecturesystem.dto.GroupDTO;

import java.util.List;

public interface GroupService {
    public GroupDTO saveGroup(GroupDTO groupDTO);
    public GroupDTO getGroup(Long id);
    public List<GroupDTO> getAllGroups();
    public void deleteGroup(Long id);
}
