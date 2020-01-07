package com.jln.common;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.jln.common.*.mapper")
@SpringBootApplication
public class CohortApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(CohortApplication.class, args);
	}

}
