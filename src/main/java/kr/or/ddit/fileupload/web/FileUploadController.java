package kr.or.ddit.fileupload.web;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/Fileupload")
@Controller
public class FileUploadController {
	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

	/*
	 * localhost/Fileupload/view 요청시 jsp로 응답생성 jsp에서는 파일을 선택할 수 있는 input태그 1개
	 * userid파라미터를 보낼 수 있는 input태그 1개 전송을 담당하는submit input태그 1개를 작성 jsp :
	 * WEB-INF/views/fileupload/fileupload.jsp 테스트 코드까지 작성
	 * 
	 */
	@RequestMapping(path = "/view", method = { RequestMethod.GET })
	public String getView() {

		return "fileupload/input";
	}
	
	//파일 업로드 처리 메소드
	@RequestMapping("/fileupload")
	public String fileupload(String userid, @RequestPart("realFilename") MultipartFile multipartFile) {
		logger.debug("userid : {}", userid);
		logger.debug("realfile.getName(파라미터이름) : {}", multipartFile.getName());
		logger.debug("realfile.getOriginalFilename(진짜파일이름) : {}", multipartFile.getOriginalFilename());
		logger.debug("realfile.getContentType(파일타입) : {}", multipartFile.getContentType());
		logger.debug("realfile.getSize(파일크기) : {}", multipartFile.getSize());
		
		// 파일 데이터를 지정한 file로 저장
		File uploadFile = new File("d:\\upload_Spring\\"+multipartFile.getOriginalFilename());
		try {
			multipartFile.transferTo(uploadFile);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "fileupload/fileupload";
	}

}
