package kr.or.ddit.mvc.view;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

import kr.or.ddit.member.model.MemberVO;

public class fileDownloadview extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
		response.setHeader("Content-Disposition", "attachment; filename=\""+model.get("realfilename")+"\"");
		response.setContentType("application/octet-stream"); 
		
		//파일 입출력을 통해 응답생성
		//파일 읽기 
		//응답생성 - contentType을(img, ..) 지정해주는것이 맞지만 안해줘도 크롬이 알아서 판단(부하가걸림)

		FileInputStream fis = new FileInputStream((String) model.get("filepath"));
	
		
		ServletOutputStream sos = response.getOutputStream();
		
		byte[] buffer = new byte[512];
		
		while(fis.read(buffer)!=-1) {
			sos.write(buffer);
		}
		
		fis.close();
		
		sos.flush();
		sos.close();
	}

}
