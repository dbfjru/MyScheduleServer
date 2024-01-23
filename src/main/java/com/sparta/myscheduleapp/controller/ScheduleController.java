package com.sparta.myscheduleapp.controller;

import com.sparta.myscheduleapp.dto.ScheduleRequestDto;
import com.sparta.myscheduleapp.dto.ScheduleResponseDto;
import com.sparta.myscheduleapp.entity.Schedule;
import com.sparta.myscheduleapp.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ScheduleController {
    private final ScheduleService scheduleService;
    public ScheduleController(ScheduleService scheduleService){
        this.scheduleService = scheduleService;
    }
    @PostMapping("/schedule")
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto scheduleRequestDto){
        return scheduleService.createSchedule(scheduleRequestDto);
    }
    @GetMapping("/schedule")
    public ScheduleResponseDto getSchedule(@RequestParam Long id){
        //Todo
        //어떤 방식으로 특정 일정을 고르지? id 값을 받는 걸로 하자.
        return scheduleService.getSchedule(id);
    }
    @GetMapping("/schedules")
    public List<ScheduleResponseDto> getSchedules(){
        return scheduleService.getSchedules();
    }
    @PutMapping("/schedule")
    public ScheduleResponseDto updateSchedule(@RequestParam Long id, @RequestBody ScheduleRequestDto scheduleRequestDto){
        return scheduleService.updateSchedule(id, scheduleRequestDto);
    }
}
