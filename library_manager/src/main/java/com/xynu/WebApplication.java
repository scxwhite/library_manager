package com.xynu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = "com.xynu")
@MapperScan(basePackages = "com.xynu.mapper")
@EnableTransactionManagement
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}


	@RequestMapping("/")
	public String login() {
		return "redirect:page/model/index";
	}
}
