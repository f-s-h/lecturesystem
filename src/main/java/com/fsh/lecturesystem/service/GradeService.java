package com.fsh.lecturesystem.service;

import com.fsh.lecturesystem.dto.GradeDTO;

import java.util.List;

public interface GradeService {
    public GradeDTO saveGrade(GradeDTO gradeDTO);
    public GradeDTO getGrade(Long id);
    public List<GradeDTO> getAllGrades();
    public void deleteGrade(Long id);
}
