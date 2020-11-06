package kr.or.ddit.member.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class MemberVoValidator implements Validator{

	// 검증하려고 하는 객체가 MemberVoValidator에서 검증이 가능한
	// 객체인지 boolean으로 리턴하는 메소드
	@Override
	public boolean supports(Class<?> clazz) {
		return MemberVO.class.isAssignableFrom(clazz);
		//인자로 들어온 클래스로부터 할당이 가능한지 검사 프레임워크가 호출, 개발자가 체크
	}

	// 검증 로직 작성
	// Object target : command객체 (검증로직을 태울 command객체)
	// bindingResult는 errors를 상속받음
	@Override
	public void validate(Object target, Errors errors) {
		MemberVO memberVO = (MemberVO)target;
		
		// 사용자 이름 체크 로직
		// usernm 값이 null이거나 empty 문자열이면 안됨
		if(memberVO.getUsernm() == null || memberVO.getUsernm().equals("")) {
			errors.rejectValue("usernm", "required"); //필드와 에러코드	
		}
	}

}
