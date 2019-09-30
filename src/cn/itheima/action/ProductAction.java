package cn.itheima.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import cn.itheima.domain.Product;

public class ProductAction {

	public String showProduct() {

		// 1.将数据得到List<Product>
		Product p1 = new Product();
		p1.setId(1);
		p1.setName("电视机");
		p1.setPrice(2000);

		Product p2 = new Product();
		p2.setId(2);
		p2.setName("电冰箱");
		p2.setPrice(3000);

		List<Product> ps = new ArrayList<Product>();
		ps.add(p1);
		ps.add(p2);
		// 2.将List<Product>压入到valueStack栈顶
		ActionContext.getContext().getValueStack().set("ps", ps);

		return "success";
	}
}
