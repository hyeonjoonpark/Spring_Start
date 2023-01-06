package com.example.springstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringStartApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringStartApplication.class, args);
		try {
			String str = null;
			System.out.println(str.toString());
		}catch (NullPointerException e) {
			System.out.println("--NullPointerException 발생--");
			System.out.println("기존 코드를 체크해 주세요!!");
		}finally {
			System.out.println("예외처리 코드가 오류없이 진행되었습니다.");
		}
	}

}
