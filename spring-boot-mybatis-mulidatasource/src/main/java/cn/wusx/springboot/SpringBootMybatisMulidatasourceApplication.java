package cn.wusx.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.wusx.springboot.dao")
public class SpringBootMybatisMulidatasourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMybatisMulidatasourceApplication.class, args);
	}

}
