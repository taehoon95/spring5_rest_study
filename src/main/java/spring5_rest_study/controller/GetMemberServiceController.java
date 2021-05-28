package spring5_rest_study.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import spring5_rest_study.dto.Member;
import spring5_rest_study.service.GetMemberService;

@RestController
public class GetMemberServiceController {

	@Autowired
	private GetMemberService service;
	
	@GetMapping("/api/members/{id}")
	public ResponseEntity<Object> member(@PathVariable long id,HttpServletResponse response){
		Member member = service.getMember(id);
		if(member == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(member);
	}
	
}
