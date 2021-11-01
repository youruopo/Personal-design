package com.ssgl.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @创建日期 2021/9/20
 * 分页用的
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Page {
    private Integer status;
    private Integer pageNum;
    private Integer pageSize;
}
