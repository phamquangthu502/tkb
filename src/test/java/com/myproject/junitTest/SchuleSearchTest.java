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
	//+)Chuc nang tim kiem lich: Sau khi ch???n ???????c k??? h???c m???i enable n??t t??m ki???m
	
	
	//1.truy???n v??o k??? h???c t???n t???i v?? t??n m??n t???n t???i(c?? d???u) => danh s??ch t???t c??? c??c m??n trong k??? ???? c?? t??n t????ng ???ng tr??? v??? giao di???n 
	@Test
	void testSearch1() {
		String ky = "H???c k??? 1 n??m h???c 2020-2021";
		String key = "to??n";		
		String rs = schuleController.viewHomepage(key, ky, model);
		assertEquals(rs, "lenlich");
		assertEquals(schuleService.getByName(key, ky).size(),8);
	}
	
	//2.truy???n v??o k??? h???c t???n t???i v?? t??n m??n t???n t???i(kh??ng d???u) => danh s??ch t???t c??? c??c m??n trong k??? ???? c?? t??n t????ng ???ng tr??? v??? giao di???n 
	@Test
	void testSearch2() {
		String ky = "H???c k??? 1 n??m h???c 2020-2021";
		String key = "toan";	
		String rs = schuleController.viewHomepage(key, ky, model);
		assertEquals(rs, "lenlich");
		assertEquals(8, schuleService.getByName(key, ky).size());
	}

	//3.truy???n v??o k??? h???c t???n t???i v?? t??n m??n tr???ng => danh s??ch t???t c??? c??c m??n trong k??? ???? tr??? v??? giao di???n 
	@Test
	void testSearch3() {
		String ky = "H???c k??? 1 n??m h???c 2020-2021";
		String key = null;		
		String rs = schuleController.viewHomepage(key, ky, model);
		assertEquals(rs, "lenlich");
		assertEquals(16, schuleService.findAll(ky).size());
	}
	
	//4.truy???n v??o k??? h???c t???n t???i v?? t??n m??n sai => danh s??ch c??c m??n tr???ng trong k??? ???? tr??? v??? giao di???n 
	@Test
	void testSearch4() {
		String ky = "H???c k??? 1 n??m h???c 2020-2021";
		String key = "toanss";
		String rs = schuleController.viewHomepage(key, ky, model);
		assertEquals(rs, "lenlich");
		assertEquals(0, schuleService.getByName(key, ky).size());
	}
		
}
