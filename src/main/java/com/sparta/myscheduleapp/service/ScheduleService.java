package com.sparta.myscheduleapp.service;

import com.sparta.myscheduleapp.dto.ScheduleRequestDto;
import com.sparta.myscheduleapp.dto.ScheduleResponseDto;
import com.sparta.myscheduleapp.entity.Schedule;
import com.sparta.myscheduleapp.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
        //Entity -> ResponseDto
        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(saveSchedule);

        return scheduleResponseDto;
    }

    public ScheduleResponseDto getSchedule(Long id) {
        return new ScheduleResponseDto(scheduleRepository.findById(id));
        //Todo : id 값에 해당하는 일정이 없는 경우 처리 문제 ;; NullPointerException 처리 필요
        //정상적인 경우는 동작함
    }

    public List<ScheduleResponseDto> getSchedules() {

        return scheduleRepository.findAll();
    }


    public ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto scheduleRequestDto) {
        Schedule schedule = scheduleRepository.findById(id);
        if(schedule != null){
            if(schedule.getPassword().equals(scheduleRequestDto.getPassword())){
                scheduleRepository.update(id,scheduleRequestDto);
            }else {
                System.out.println("Wrong password");
            }
        }else {
            System.out.println("Wrong id");
            return null;
        }
        return new ScheduleResponseDto(scheduleRepository.findById(id));
    }

    public Long deleteSchedule(Long id, String password) {
        Schedule schedule = scheduleRepository.findById(id);
        if(schedule != null){
            if(password.equals(schedule.getPassword())){
                scheduleRepository.delete(id);
                return id;
            }else{
                //Wrong password!
                return 0L;
            }
        }else{
            //해당 하는 id 없는 경우
            return -1L;
        }
    }
}
