package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @version 1.0
 * @author： xiaoxu
 * @date： 2022-12-04 20:22
 */

@Data
@TableName("sys_role_menu")
public class RoleMenu {
    private Integer roleId;
    private Integer menuId;
}
