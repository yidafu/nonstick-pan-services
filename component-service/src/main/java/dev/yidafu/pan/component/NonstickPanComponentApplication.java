package dev.yidafu.pan.component;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("dev.yidafu.pan.component")
public class NonstickPanComponentApplication {

	public static void main(String[] args) {
		SpringApplication.run(NonstickPanComponentApplication.class, args);
	}
}
