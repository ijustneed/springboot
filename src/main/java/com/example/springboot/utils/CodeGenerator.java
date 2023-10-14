package com.example.springboot.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @version 1.0
 * @author： xiaoxu
 * @date： 2022-12-03 18:28
 */

public class CodeGenerator {
    public static void main(String[] args) {
        generate();

    }
    private static void generate() {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/school?serverTimezone=GMT%2b8", "root", "xt0415")
                .globalConfig(builder -> {
                    builder.author("xu") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("D:\\reStart\\springboot\\src\\main\\java\\"); // 指定输出目录
                })
                .packageConfig(builder -> {

                    builder.parent("com.example.springboot") // 设置父包名
                            .moduleName(null) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D:\\reStart\\springboot\\src\\main\\resources\\mapper\\")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.entityBuilder().enableLombok();
                    builder.controllerBuilder().enableHyphenStyle()  // 开启驼峰转连字符
                            .enableRestStyle();  // 开启生成@RestController 控制器

                    builder.addInclude("sys_menu") // 设置需要生成的表名
                            .addTablePrefix("tb_", "sys_"); // 设置过滤表前缀
                })
                //.templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
