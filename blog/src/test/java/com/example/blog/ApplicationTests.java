package com.example.blog;

import com.example.blog.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void repositoryTest(){
		String className = this.userRepository.getClass().getName();
		System.out.println(className);
		String packageName = this.userRepository.getClass().getPackageName();
		System.out.println(packageName);
	}

}
