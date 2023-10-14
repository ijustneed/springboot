package com.example.springboot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @version 1.0
 * @author： xiaoxu
 * @date： 2022-12-04 19:56
 */

@TableName("sys_dict")
@Data
public class Dict {
    private String name;
    private  String value;
    private String type;
}
