package com.myproject.junitTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import com.myproject.controller.SchuleController;
import com.myproject.model.Schule;
import com.myproject.service.SchuleService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class SelectTbdRSchuleTest {
	
	@Autowired
	private SchuleService schuleService;
	
	@Autowired
	private SchuleController schuleController;

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
	
	//+)hiển thị danh sách tiết bắt đầu tương ứng với mã giảng viên, thời gian(thứ) và tên học kỳ
	@Test
	public void getListTbd() {
		Long idl = (long) 1;
		String thu ="Monday";
		String hk = "Học kỳ 1 năm học 2020-2021";	
		List<Schule> s = null;
		s = schuleService.listlt(idl, thu, hk);
		
		assertEquals(s.size(),2);// hiện ra 2 tiết giảng viên mã 1 dạy thứ 2 => tiết có thể chọn = listtbd - s 
	}
	
	//+)hiển thị danh sách tiết bắt đầu tương ứng với mã giảng viên, thời gian(thứ) và tên học kỳ(GV chưa có lịch trong ngày)
	@Test
	public void getListTbd1() {
		Long idl = (long) 1;
		String thu ="Thusday";
		String hk = "Học kỳ 1 năm học 2020-2021";	
		List<Schule> s = null;
		s = schuleService.listlt(idl, thu, hk);
		
		assertEquals(s.size(),0);// hiện ra 0 tiết bd giảng viên mã 1 dạy thứ 2 => tiết có thể chọn = listtbd - s 
	}
	
	//+)hiển thị danh sách tiết bắt đầu tương ứng với mã giảng viên, thời gian(thứ) và tên học kỳ ,
	//giảng viên này đã dạy kín ngày //// hiện ra các tiết giảng viên mã 2 dạy thứ 2 => tiết có thể chọn = listtbd - s 
	@Test
	public void getListTbd2() {
		Long idl = (long) 2;
		String thu ="Monday";
		String hk = "Học kỳ 1 năm học 2020-2021";	
		List<Schule> s = null;
		s = schuleService.listlt(idl, thu, hk);		
		assertEquals(s.size(),6);	
	}
	
	
	//+)hiển thị danh sách phòng đã đc dùng tương ứng với thời gian(thứ), tiết bắt đầu và tên học kỳ
	// hiện ra 1 phòng đã đc sử dụng tại kíp 2 thứ 2 => phòng có thể chọn = listr - s 
	@Test
	public void getListR() {
		String thu ="Monday";
		int tbd = 3;
		String hk = "Học kỳ 1 năm học 2020-2021";	
		List<Schule> s = null;
		s = schuleService.getr(thu, tbd, hk);		
		assertEquals(s.size(),1);
	}
	
	//+)hiển thị danh sách phòng đã đc dùng tương ứng với thời gian(thứ), tiết bắt đầu và tên học kỳ(chưa phòng nào đc dùng)
	@Test
	public void getListR1() {
		String thu ="Thusday";
		int tbd = 1;
		String hk = "Học kỳ 1 năm học 2020-2021";	
		List<Schule> s = null;
		s = schuleService.getr(thu, tbd, hk);		
		assertEquals(s.size(),0);
	}
	
	//+)hiển thị danh sách phòng tương ứng với thời gian(thứ), tiết bắt đầu và tên học kỳ (tất cả các phòng đã được dùng)
	@Test
	public void getListR2() {
		String thu ="Monday";
		int tbd = 1;
		String hk = "Học kỳ 1 năm học 2020-2021";	
		List<Schule> s = null;
		s = schuleService.getr(thu, tbd, hk);		
		assertEquals(s.size(),9);
	}
	
	//+Check ma lop
	//dau vao la ma lop đúng, chưa từng ton tai 
	@Test
	public void checkMaL1() {
		String malop = "thu1";
	    String hk = "Học kỳ 1 năm học 2020-2021";
	    String x = schuleController.checkMalop(malop, hk, model);
		assertEquals(x,null);// check ko co
	}
	//dau vao ma lop sai ( da ton tai)
	@Test
	public void checkMaL2() {
		String malop = "12b";
	    String hk = "Học kỳ 1 năm học 2020-2021";
	    String x = schuleController.checkMalop(malop, hk, model);
		assertEquals(x,malop);// check ko co
	}
	//dau vao ma lop null
	@Test
	public void checkMaL3() {
		String malop = null;
	    String hk = "Học kỳ 1 năm học 2020-2021";
	    String x = schuleController.checkMalop(malop, hk, model);
		assertEquals(x,null);// check ko co
	}
		
}
