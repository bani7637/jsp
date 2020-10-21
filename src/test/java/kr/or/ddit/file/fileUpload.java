package kr.or.ddit.file;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.or.ddit.FileUpload.FileUploadUtil;
import kr.or.ddit.cookie.CookieSplit;

public class fileUpload {

	@Test
	public void getFileNameTest() {
		/***Given***/
		String contentDisposition = "form-data; name=\"img\"; filename=\"pixaday.jpg\"";

		/***When***/
		String filename = FileUploadUtil.getFilename(contentDisposition);
		
		/***Then***/
		assertEquals("pixaday.jpg", filename);
	}

}
