package com.ssgl.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer id;

    /**
     * 宿舍id
     */
    private Hostel hostel;

    private String username;

    private String password;

    private String nickname;

    /**
     * 考勤打卡：1、待打卡 2、已打卡
     */
    @Builder.Default
    private Integer clockInStatus = 1;

    /**
     * 班级
     */
    private String cla;

    private String phone;

    private String email;
}
