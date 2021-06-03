package com.myproject.junitTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.Map;

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
import com.myproject.repository.SubjectsRepository;
import com.myproject.service.SchuleService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class SchuleControllerTest {
	
	@Autowired
	private SchuleController schuleController;
	
	@Autowired
	private SchuleService schuleService;
	
	@MockBean
	private SchuleRepository schuleRepository;
	
	@MockBean
	private SemesterRepository semesterRepository;
	
	@MockBean
	private SubjectsRepository subjectsRepository;

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
	
	//hien thi trang chu
	@Test
	public void testhomePage() {
		String rs = schuleController.viewHomePage(model);
		assertEquals(rs,"index");
	}
	
	//hien thi giao dien len lich
	@Test
	public void testlenlichPage() {
		String rs = schuleController.viewLenlich(model);
		assertEquals(rs,"lenlich");
	}
	
	//hien thi giao dien login khi bam dang nhap
	@Test
	public void testloginPage() {
		String rs = schuleController.viewLogin(model);
		assertEquals(rs,"login");
	}
	
	//test Log out
	@Test
	public void testlogout() {
		String rs = schuleController.Logout(model);
		assertEquals(rs,"index");
	}
	
	//__________Chuc nang len lich tkb:__________
	
	//+)Chuc nang them moi lich:_______ sau khi chọn học kỳ thì enable nút thêm
	@Test
	public void addSchulerTest() {
		Schule sc = new Schule((long)1, "Học kỳ 1 năm học 2020-2021", (long)1, 
				"toan", (long)1, "Thu", 12, 1, 3, "d23", 45, "Monday", 1, 2, "202-A2");
		when(schuleRepository.save(sc)).thenReturn(sc);
		assertEquals(sc, schuleService.save(sc));
	}
	
	
	
	//+)Chuc nang sua thong tin lich:__
	@Test
	public void saveSchulerTest() {
		Schule sc = new Schule((long)1, "Học kỳ 2 năm học 2020-2021", (long)1, "toan", (long)1, 
				"Thu", 12, 1, 3, "d23", 45, "Monday", 1, 2, "202-A2");
		when(schuleRepository.save(sc)).thenReturn(sc);
		assertEquals(sc, schuleService.update(sc));
		assertEquals(schuleController.updateSchule(sc), "redirect:/");
	}
	
	//+)Chuc nang xoa lich:____________
	
	@Test
	public void deleteSchuleTest() {
		Long id = (long) 1;
		Schule sc = new Schule((long)1, "Học kỳ 2 năm học 2020-2021", (long)1, "toan", 
				(long)1, "Thu", 12, 1, 3, "d23", 45, "Monday", 1, 2, "202-A2");
		schuleController.deleteSchule(id);
		verify(schuleRepository, times(1)).deleteById(id);
	}
	
}
