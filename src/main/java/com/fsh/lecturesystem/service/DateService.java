package com.fsh.lecturesystem.service;

import com.fsh.lecturesystem.dto.DateDTO;

import java.util.List;

public interface DateService {
    public DateDTO saveDate(DateDTO dateDTO);
    public DateDTO getDate(Long id);
    public List<DateDTO> getAllDates();
    public void deleteDate(Long id);
}
