package com.code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 代码生成启动类
 *
 * 启动后访问：http://localhost:4000/code-generator
 *
 * 选择要生成的表，输入如下参数：
 * 主目录：如com.tufire.user
 * 模块名：如user
 * 包名：如com.tufire.user
 * 
 * @author wuhoujian
 *
 */
@SpringBootApplication
public class GeneratorApplication {
	public static void main(String[] args) {
		SpringApplication.run(GeneratorApplication.class, args);
	}
}
