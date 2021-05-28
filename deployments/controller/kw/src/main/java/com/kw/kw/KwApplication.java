package com.kw.kw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing //JPA 내부에서 엔티티 객체가 생성/변경되는 것을 감지하기 위해 추가
public class KwApplication {

	public static void main(String[] args) {
		SpringApplication.run(KwApplication.class, args);
	}

}
