package cn.itheima.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import cn.itheima.domain.Product;

public class ProductAction {

	public String showProduct() {

		// 1.�����ݵõ�List<Product>
		Product p1 = new Product();
		p1.setId(1);
		p1.setName("���ӻ�");
		p1.setPrice(2000);

		Product p2 = new Product();
		p2.setId(2);
		p2.setName("�����");
		p2.setPrice(3000);

		List<Product> ps = new ArrayList<Product>();
		ps.add(p1);
		ps.add(p2);
		// 2.��List<Product>ѹ�뵽valueStackջ��
		ActionContext.getContext().getValueStack().set("ps", ps);

		return "success";
	}
}
