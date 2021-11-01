package com.ssgl.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Declare {
    private Integer id;

    /**
     * 宿舍
     */
    private Hostel hostel;

    /**
     * 申报状态：1、已申报 2、已处理
     */
    @Builder.Default
    private Integer status = 1;

    /**
     * 申报原因
     */
    private String describe;

    /**
     * 申报时间
     */
    private String createTime;
}
