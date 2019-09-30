package cn.itheima.json;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ser.impl.SimpleBeanPropertyFilter;
import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;
import org.junit.Test;

import cn.itheima.domain.Product;

public class JacksonTest {
	@Test
	public void test1() throws JsonGenerationException, JsonMappingException, IOException{
		Product p = new Product();
		p.setId(1);
		p.setName("电视机");
		p.setPrice(2000);
		p.setReleaseDate(new Date());
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
		String json = mapper.writeValueAsString(p);
		System.out.println(json);
	}
	
	@Test
	public void test2() throws JsonGenerationException, JsonMappingException, IOException{
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
		ObjectMapper mapper = new ObjectMapper();
		SimpleFilterProvider fp = new SimpleFilterProvider().addFilter("productFilter",
				          SimpleBeanPropertyFilter.filterOutAllExcept("id","name"));
		/*SimpleFilterProvider fp = new SimpleFilterProvider().addFilter("productFilter",
		          SimpleBeanPropertyFilter.serializeAllExcept("id","name"));*/
		mapper.setFilters(fp);
		
		String json = mapper.writeValueAsString(ps);
		System.out.println(json);
		
	}

}
