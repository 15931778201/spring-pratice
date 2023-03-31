package cn.wusx.springboot;

import java.io.Serializable;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import cn.wusx.springboot.model.UserEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRedisApplicationTests {

	@Autowired
	private RedisTemplate<String, String> strRedisTemplate;
	@Autowired
	private RedisTemplate<String, Serializable> serializableRedisTemplate;
	
	@Test
	public void testString() {
		strRedisTemplate.opsForValue().set("strKey", "wusx");
		System.out.println(strRedisTemplate.opsForValue().get("strKey"));
	}
	
	@Test
	public void testSerializable() {
		UserEntity user=new UserEntity();
		user.setId(1L);
		user.setUserName("wusx");
		user.setUserSex("女");
		serializableRedisTemplate.opsForValue().set("user", user);		
		UserEntity user2 = (UserEntity) serializableRedisTemplate.opsForValue().get("user");
		System.out.println("user:"+user2.getId()+","+user2.getUserName()+","+user2.getUserSex());
	}

}
