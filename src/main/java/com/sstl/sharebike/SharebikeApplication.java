package com.sstl.sharebike;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.sstl.sharebike.mapper")
public class SharebikeApplication {
	public static void main(String[] args) {
		SpringApplication.run(SharebikeApplication.class, args);
	}
}
