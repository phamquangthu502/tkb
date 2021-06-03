package com.myproject.junitTest;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import com.myproject.controller.SubjectController;
import com.myproject.model.Subjects;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class SubjectTest {

	@Autowired
	private SubjectController subjectController;
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
	
	//+)hiển thị tên môn ứng với mã môn tồn tại đã nhập
	@Test
	public void getNameSubTest1() {
		Long id = (long) 1;	
		Optional<Subjects> s = subjectController.getNameSubject(id, model);
		String nu = s.get().getName_sub();
		assertEquals(nu,"toán");
		
	}
	
	//+)hiển thị tên môn ứng với mã môn không tồn tại đã nhập(là số)
	@Test
	public void getNameSubTest2() {
		Long id = (long) 9;	
		Optional<Subjects> s = null;
		s = subjectController.getNameSubject(id, model);
		assertEquals(s,Optional.empty());
		
	}
	
	//+) mã môn không là số => bắt ngoại lệ ở client
}
