package com.sparta.myscheduleapp.controller;

import com.sparta.myscheduleapp.dto.ScheduleRequestDto;
import com.sparta.myscheduleapp.dto.ScheduleResponseDto;
import com.sparta.myscheduleapp.service.ScheduleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ScheduleController {
    private final ScheduleService scheduleService;
    public ScheduleController(ScheduleService scheduleService){
        this.scheduleService = scheduleService;
    }
    @PostMapping("/schedules")
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto scheduleRequestDto){
        return scheduleService.createSchedule(scheduleRequestDto);
    }
}
