package com.ssgl.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private Integer id;

    private String username;

    private String password;

    private String nickname;

    private String phone;

    private String email;

}
