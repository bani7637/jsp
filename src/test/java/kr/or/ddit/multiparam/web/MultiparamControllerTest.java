package kr.or.ddit.multiparam.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.WebTestConfig;

public class MultiparamControllerTest extends WebTestConfig{

	@Test
	public void multiParamViewTest() throws Exception {
		MvcResult res = mockMvc.perform(get("/multi/view")).andReturn();
		ModelAndView mav= res.getModelAndView();
		assertEquals("multi/view", mav.getViewName());
	}

	@Test
	public void multiParamSubmitTest() throws Exception {
		MvcResult res = mockMvc.perform(get("/multi/submit")
				.param("userid", "brown", "sally", "cony"))
				.andDo(print())
				.andReturn();
		ModelAndView mav= res.getModelAndView();
		assertEquals("multi/view", mav.getViewName());
	}

}
