package com.myproject.junitTest;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import com.myproject.controller.SchuleController;
import com.myproject.model.Schule;
import com.myproject.repository.SchuleRepository;
import com.myproject.repository.SemesterRepository;
import com.myproject.service.SchuleService;
import com.myproject.service.SemesterService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class SchuleSearchTest {

	@Autowired
	private SchuleController schuleController;
	
	@Autowired
	private SchuleService schuleService;
	
	private Model model = new Model() {

		@Override
		public Model mergeAttributes(Map<String, ?> attributes) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object getAttribute(String attributeName) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean containsAttribute(String attributeName) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Map<String, Object> asMap() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Model addAttribute(String attributeName, Object attributeValue) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Model addAttribute(Object attributeValue) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Model addAllAttributes(Map<String, ?> attributes) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Model addAllAttributes(Collection<?> attributeValues) {
			// TODO Auto-generated method stub
			return null;
		}
	};
	
	//_______SEARCH________
	//+)Chuc nang tim kiem lich: Sau khi chọn được kỳ học mới enable nút tìm kiếm
	
	
	//1.truyền vào kỳ học tồn tại và tên môn tồn tại(có dấu) => danh sách tất cả các môn trong kỳ đó có tên tương ứng trả về giao diện 
	@Test
	void testSearch1() {
		String ky = "Học kỳ 1 năm học 2020-2021";
		String key = "toán";		
		String rs = schuleController.viewHomepage(key, ky, model);
		assertEquals(rs, "lenlich");
		assertEquals(schuleService.getByName(key, ky).size(),8);
	}
	
	//2.truyền vào kỳ học tồn tại và tên môn tồn tại(không dấu) => danh sách tất cả các môn trong kỳ đó có tên tương ứng trả về giao diện 
	@Test
	void testSearch2() {
		String ky = "Học kỳ 1 năm học 2020-2021";
		String key = "toan";	
		String rs = schuleController.viewHomepage(key, ky, model);
		assertEquals(rs, "lenlich");
		assertEquals(8, schuleService.getByName(key, ky).size());
	}

	//3.truyền vào kỳ học tồn tại và tên môn trống => danh sách tất cả các môn trong kỳ đó trả về giao diện 
	@Test
	void testSearch3() {
		String ky = "Học kỳ 1 năm học 2020-2021";
		String key = null;		
		String rs = schuleController.viewHomepage(key, ky, model);
		assertEquals(rs, "lenlich");
		assertEquals(16, schuleService.findAll(ky).size());
	}
	
	//4.truyền vào kỳ học tồn tại và tên môn sai => danh sách các môn trống trong kỳ đó trả về giao diện 
	@Test
	void testSearch4() {
		String ky = "Học kỳ 1 năm học 2020-2021";
		String key = "toanss";
		String rs = schuleController.viewHomepage(key, ky, model);
		assertEquals(rs, "lenlich");
		assertEquals(0, schuleService.getByName(key, ky).size());
	}
		
}
