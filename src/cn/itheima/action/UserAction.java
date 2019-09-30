package cn.itheima.action;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;
import org.codehaus.jackson.map.ObjectMapper;

import cn.itheima.domain.Result;

public class UserAction {

	public void checkUsername() {

		// 处理响应数据中文乱码
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");

		// 1.获取请求参数username
		String username = ServletActionContext.getRequest().getParameter("username");

		// 2.判断username是否可用
		// 3.根据上述判断，向浏览器响应json数据
		Result result = new Result();
		if ("tom".equalsIgnoreCase(username)) {
			// 不可以使用
			result.setFlag(false);
			result.setMessage("用户名已经被占用");
		} else {
			// 可以使用
			result.setFlag(true);
			result.setMessage("用户名可以使用");
		}
		// 将result转换成json---合适jackson完成操作
		ObjectMapper mapper = new ObjectMapper();
		try {
			// String json = mapper.writeValueAsString(result);
			// 通过response响应数据到浏览器
			// ServletActionContext.getResponse().getWriter().write(json);

			mapper.writeValue(ServletActionContext.getResponse().getWriter(), result);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
