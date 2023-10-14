package com.example.springboot.service;

import com.example.springboot.controller.dto.UserDTO;
import com.example.springboot.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xu
 * @since 2022-12-03
 */
public interface IUserService extends IService<User> {

    UserDTO login(UserDTO userDTO);
    User register(UserDTO userDTO);
}
