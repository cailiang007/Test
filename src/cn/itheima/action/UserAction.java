package cn.itheima.action;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;
import org.codehaus.jackson.map.ObjectMapper;

import cn.itheima.domain.Result;

public class UserAction {

	public void checkUsername() {

		// ������Ӧ������������
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");

		// 1.��ȡ�������username
		String username = ServletActionContext.getRequest().getParameter("username");

		// 2.�ж�username�Ƿ����
		// 3.���������жϣ����������Ӧjson����
		Result result = new Result();
		if ("tom".equalsIgnoreCase(username)) {
			// ������ʹ��
			result.setFlag(false);
			result.setMessage("�û����Ѿ���ռ��");
		} else {
			// ����ʹ��
			result.setFlag(true);
			result.setMessage("�û�������ʹ��");
		}
		// ��resultת����json---����jackson��ɲ���
		ObjectMapper mapper = new ObjectMapper();
		try {
			// String json = mapper.writeValueAsString(result);
			// ͨ��response��Ӧ���ݵ������
			// ServletActionContext.getResponse().getWriter().write(json);

			mapper.writeValue(ServletActionContext.getResponse().getWriter(), result);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
