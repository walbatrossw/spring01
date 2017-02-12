package com.example.spring01.sample;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller // 컨트롤러 bean으로 로딩(현재 클래스를 컨트롤러로 메모리에 로딩시켜준다)
public class SampleController {
	// 로그 객체 생성
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping("sample/doA") // url pattern
	// 리턴타입 없이 void일 경우, mapping된 url의 pattern이름과 동일한 jsp로 포워드한다.
	//public void doA(Model model){
	public String doA(Model model){
		logger.info("doA called...."); // 로그 출력
		// model.addAttribute(key, value);
		// map과 같이 key, value구조로 되어있다.
		model.addAttribute("message", "홈페이지 방문을 환영합니다.");
		// 리턴타입이 void이면, 메서드가 종료된 후에 doA.jsp로 포워드
		return "sample/doA"; // doB.jsp로 포워드
	}
	
	@RequestMapping("sample/doB") // url pattern
	public void doB(){
		logger.info("doB called....");
		// 메서드가 종료된 후에 doB.jsp로 포워드
	}
	
	// ModelAndView : Model - 데이터저장소, View화면
	// 데이터와 포워드할 페이지의 정보
	// forward : 주소변경X , 화면전환, 대량의 데이터 전달
	// redirect : 주소변경O, 화면전환, 소량의 데이터 전달(get방식만 가능)
	@RequestMapping("sample/doC") // url pattern
	public ModelAndView doC(){
		logger.info("doC called....");
		// 메서드가 종료된 후에 doC.jsp로 포워드
		// 맵에 객체를 저장
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("product", new ProductVO("연필", 1000));
		// new ModelAndView("view의 이름", "map변수명", 맵);
		return new ModelAndView("sample/doC", "map", map);
	}
	@RequestMapping("sample/doD")
	public String doD(){
		
		// redirect의 경우, return type을 String으로 설정
		// doE.jsp로 리다이렉트
		return "redirect:/sample/doE";
		//return "sample/doE"; // 포워드
	}
	
	@RequestMapping("sample/doE")
	public void doE(){
		//doE.jsp로 포워드
	}
	
}
