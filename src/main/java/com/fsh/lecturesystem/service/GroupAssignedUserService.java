package com.fsh.lecturesystem.service;

import com.fsh.lecturesystem.dto.GroupAssignedUserDTO;

import java.util.List;

public interface GroupAssignedUserService {
    public GroupAssignedUserDTO saveGroupAssignedUser(GroupAssignedUserDTO groupEnrolledUserDTO);
    public GroupAssignedUserDTO getGroupAssignedUser(Long userId, Long groupId);
    public List<GroupAssignedUserDTO> getAllGroupAssignedUsers();
    public void deleteGroupAssignedUser(Long userId, Long groupId);
}
