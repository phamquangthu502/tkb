package com.myproject.junitTest;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Map;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import com.myproject.controller.UserController;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserTest {

	@Autowired 
	private UserController userController;
	
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
	
	//_________LOGIN_________
		
		
		//check login
		//1. test taikhoan, mat khau hop le => giao dien indexx.html
		@Test
		void testLogin1() {
			String username = "thupq";
			String password = "123456";
			String rs = userController.Login(username, password, model);
			assertEquals(rs, "indexx");
		}
		
		//2. test taikhoan dung, mat khau sai => giao dien login.html
		@Test
		void testLogin2() {
			String username = "thupq";
			String password = "1234";
			String rs = userController.Login(username, password, model);
			assertEquals(rs, "login");
		}
		
		//3. test taikhoan sai, mat khau dung => giao dien login.html
		@Test
		void testLogin3() {
			String username = "thupqp";
			String password = "123456";
			String rs = userController.Login(username, password, model);
			assertEquals(rs, "login");
		}
		//4. test taikhoan, mat khau null (login thành công)=> giao dien indexx.html
		@Test
		void testLogin4() {
			String username = "thinhpq";
			String password = null;
			String rs = userController.Login(username, password, model);
			assertEquals(rs, "login");
		}
		//5. test taikhoan null, mat khau null( login fail) => giao dien login.html
		@Test
		void testLogin5() {
			String username = null;
			String password = null;
			String rs = userController.Login(username, password, model);
			assertEquals(rs, "login");
		}
		//6. test taikhoan null, mat khau dung => giao dien login.html
		@Test
		void testLogin6() {
			String username = null;
			String password = "123456";
			String rs = userController.Login(username, password, model);
			assertEquals(rs, "login");
		}
		//________Xong Login__________
}
