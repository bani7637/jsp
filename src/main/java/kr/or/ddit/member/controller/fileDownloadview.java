package kr.or.ddit.member.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

public class fileDownloadview extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//사진 파일명 속성
		String filename =(String)model.get("filenm");
		
		//application 객체를 통해 url에 해당하는 컴퓨터상의 절대 경로를 알아낸다.
		ServletContext sc = request.getServletContext();
		String filepath = sc.getRealPath("/upload");
		
		File file = new File(filepath+File.separator+filename);
		response.setHeader("content-disposition", "attachment;filename="+filename);
		response.setContentType("application/octet-stream");
		
		FileInputStream fis = new FileInputStream(file);
		byte[] buff = new byte[512];
		int len = -1;
		ServletOutputStream sos = response.getOutputStream();
		
		while((len=fis.read(buff))!=-1) {
			sos.write(buff);
		}
		fis.close();
		sos.close();
		
	}

}
