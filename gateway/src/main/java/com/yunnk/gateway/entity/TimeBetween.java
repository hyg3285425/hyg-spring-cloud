package com.yunnk.gateway.entity;

import lombok.Data;

import java.time.LocalTime;

/**
 * @author huangyigang
 */
@Data
public class TimeBetween {
    private LocalTime start;
    private LocalTime end;
}
