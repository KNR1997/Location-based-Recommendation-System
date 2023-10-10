package Locationbased.Recommendation.System.Neo4j;

import Locationbased.Recommendation.System.Neo4j.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Neo4jApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	void contextLoads() {
	}
	@Test
	void test1(){
		assertEquals(4, userService.add(2, 2));
	}

}
