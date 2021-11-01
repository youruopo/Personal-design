package com.ssgl.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Hostel {
    private Integer id;

    /**
     * 宿舍号
     */
    private String name;

    /**
     * 宿舍人数
     */
    @Builder.Default
    private Integer amount = 0;
}
