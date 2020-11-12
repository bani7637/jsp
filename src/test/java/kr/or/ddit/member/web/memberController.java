package kr.or.ddit.member.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.InputStream;

import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.WebTestConfig;

public class memberController extends WebTestConfig {

	@Test
	public void getMember() throws Exception {
		mockMvc.perform(get("/member/member")
				.param("userid", "brown"))
		.andExpect(status().isOk())
		.andExpect(view().name("tiles/member/member"));
	}
	
	@Test
	public void getMemList() throws Exception {
		mockMvc.perform(get("/member/memberList")
				.param("page", "1")
				.param("pageSize", "5"))
		.andExpect(status().isOk())
		.andExpect(view().name("tiles/member/memberList_content"));
	}
	
	@Test
	public void updateMember_view() throws Exception {
		mockMvc.perform(get("/member/memUpdate")
				.param("userid", "brown"))
		.andExpect(status().isOk())
		.andExpect(view().name("tiles/member/memupdate"));
	}
	
	

	@Test
	public void updateMember() throws Exception {
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("/kr/or/ddit/upload/sally.png");
		MockMultipartFile file = new MockMultipartFile("realfilename", "sally.png", "image/png", is);
		mockMvc.perform(fileUpload("/member/memUpdate")
				.file(file)
				.param("userid", "brown")
				.param("pass", "z")
				.param("usernm", "z")
				.param("alias", "z")
				.param("addr1", "z")
				.param("addr2", "z")
				.param("zipcode", "z")
				)
		.andExpect(view().name("redirect:/member/memberList"));
	}
	
	@Test
	public void regMember_view() throws Exception {
		mockMvc.perform(get("/member/memberRegist"))
		.andExpect(status().isOk())
		.andExpect(view().name("tiles/member/memberRegist"));
	}
	
	@Test
	public void regMember() throws Exception {
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("/kr/or/ddit/upload/sally.png");
		MockMultipartFile file = new MockMultipartFile("realfilename", "sally.png", "image/png", is);
		mockMvc.perform(fileUpload("/member/memberRegist")
				.file(file)
				.param("userid", "bani2")
				.param("pass", "1234")
				.param("usernm", "반이슬")
				.param("alias", "bani")
				.param("addr1", "대전 중구 중앙로 76")
				.param("addr2", "영민빌딩 4층 404호")
				.param("zipcode", "34904")
				)
		.andExpect(view().name("redirect:/member/memberList"));
	}
	
	@Test
	public void memDelete() throws Exception {
		mockMvc.perform(get("/member/memDelete")
				.param("userid", "bani"))
		.andExpect(view().name("redirect:/member/memberList"));
	}
	
}


