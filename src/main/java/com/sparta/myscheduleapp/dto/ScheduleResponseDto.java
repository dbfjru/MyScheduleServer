package com.sparta.myscheduleapp.dto;

import com.sparta.myscheduleapp.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {
    private Long id;
    private String title;
    private String contents;
    private String manager;
//    private String password; 비밀번호는 반환하지 않는다!
    private int date;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.manager = schedule.getManager();
//        this.password = schedule.getPassword();
        this.date = schedule.getDate();
    }

}
