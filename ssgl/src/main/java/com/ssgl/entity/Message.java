package com.ssgl.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @创建日期 2021/9/20
 * 返回给前端的信息
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private int status;
    private String message;
    @Builder.Default
    private Object data = "";
}
