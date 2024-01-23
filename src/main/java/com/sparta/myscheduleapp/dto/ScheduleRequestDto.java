package com.sparta.myscheduleapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleRequestDto {
    private String title;
    private String contents;
    private String manager;
    private String password;
    private int date;
}
