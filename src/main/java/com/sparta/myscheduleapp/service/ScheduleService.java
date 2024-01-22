package com.sparta.myscheduleapp.service;

import com.sparta.myscheduleapp.dto.ScheduleRequestDto;
import com.sparta.myscheduleapp.dto.ScheduleResponseDto;
import com.sparta.myscheduleapp.entity.Schedule;
import com.sparta.myscheduleapp.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    public ScheduleService(ScheduleRepository scheduleRepository){
        this.scheduleRepository = scheduleRepository;
    }

    public ScheduleResponseDto createSchedule(ScheduleRequestDto scheduleRequestDto) {
        //RequestDto -> Entity
        Schedule schedule = new Schedule(scheduleRequestDto);
        //DB 저장
        Schedule saveSchedule = scheduleRepository.save(schedule);
        //Entity -> ResopnseDto
        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(saveSchedule);

        return scheduleResponseDto;
    }
}
