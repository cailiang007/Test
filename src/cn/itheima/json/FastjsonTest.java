package cn.itheima.json;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializeFilter;

import cn.itheima.domain.User;

public class FastjsonTest {
	@Test
	public void test1(){
		User user = new User();
		user.setAge(20);
		user.setBirthday(new Date());
		user.setId(1);
		user.setName("tom");
		
		// 处理属性在json中是否生成

				SerializeFilter filter = new PropertyFilter() {

					@Override
					public boolean apply(Object arg0, String arg1, Object arg2) {
						// System.out.println(arg0); //要转换成json的对象
						// System.out.println(arg1); //属性名称
						// System.out.println(arg2); //属性值
						if (arg1.equals("id")) {
							return false; // 代表不生成在json串中
						}
						return true; // 代表生成在json串中
					}
				};
		String json = JSONObject.toJSONString(user,filter);
		System.out.println(json);
	}

	@Test
	public void test2(){
		User u1 = new User();
		u1.setAge(20);
		u1.setBirthday(new Date());
		u1.setId(1);
		u1.setName("tom");
		
		User u2 = new User();
		u2.setAge(20);
		u2.setBirthday(new Date());
		u2.setId(1);
		u2.setName("fox");
		List<User> users = new ArrayList<User>();
		users.add(u1);
		users.add(u2);
		String json = JSONArray.toJSONString(users);
		System.out.println(json);
	}
}
