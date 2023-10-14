package com.example.springboot.controller.dto;

/**
 * @version 1.0
 * @author： xiaoxu
 * @date： 2022-12-03 22:23
 */

import com.example.springboot.entity.Menu;
import lombok.Data;

import java.util.List;

/**
 * 接受前端登录请求的参数
 */
@Data
public class UserDTO {
    private String username;
    private String password;
    private String nickname;
    private String avatarUrl;
    private String token;
    private String role;
    private List<Menu> menus;
}
