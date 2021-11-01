package com.ssgl.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Leave {
    private Integer id;

    private Student student;

    private String createTime;

    private String describe;
    /**
     * 请假状态：1、待审核 2、审核通过
     */
    @Builder.Default
    private Integer status = 1;
}
