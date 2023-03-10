package com.fsh.lecturesystem.service;

import com.fsh.lecturesystem.dto.SubjectDTO;

import java.util.List;

public interface SubjectService {
    public SubjectDTO saveSubject(SubjectDTO subjectDTO);
    public SubjectDTO getSubject(Long id);
    public List<SubjectDTO> getAllSubjects();
    public void deleteSubject(Long id);
}
