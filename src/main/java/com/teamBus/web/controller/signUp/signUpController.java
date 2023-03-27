package com.teamBus.web.controller.signUp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.teamBus.web.entity.Employee;
import com.teamBus.web.service.EmployeeService;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@Controller
@RequestMapping("/sign-up")
public class signUpController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("user-info")
	public String userInfo() {
		return "/sign-up/user-info";
	}
	
	@PostMapping("user-info")
	public String userInfo(
		RedirectAttributes redirectAttr,
		@RequestParam(name = "user-name")	String userName,
		@RequestParam(name = "user-email")	String userEmail,
		@RequestParam(name = "user-pw")		String userPw,
		@RequestParam(name = "user-pw-check")	String userPwCheck,
		@RequestParam(name = "user-phone-number")	String userPhoneNumber,
		@RequestParam(name = "user-certification")	String userCertification,
		HttpSession session
		)
		{
		
		System.out.printf("%s,%s,%s,%s,%s,%s \n", 
				userName, 
				userEmail, 
				userPw, 
				userPwCheck, 
				userPhoneNumber, 
				userCertification);
		
		if(!userPw.equals(userPwCheck)) {
			System.out.println("비밀번호가 다름");
			redirectAttr.addFlashAttribute("errorMessage","암호가 다릅니다.");
			return "/sign-up/user-info";
		}
		
		Employee tmpEmp = new Employee(
				null,
				null,
				
				userPw,
				userName,
				userPhoneNumber,
				userEmail,
				
				null,
				null,
				null,
				null,
				null,
				null);
		
		session.setAttribute("tmpEmp", tmpEmp);
		
		return "redirect:/sign-up/select";
	}
	
	
	@GetMapping("select")
	public String select() {
		return "/sign-up/select";
		
	}
	
	@GetMapping("create-company")
	public String createCompany() {
		return "/sign-up/create-company";
	}
	
	@GetMapping("find-company")
	public String findCompany() {
		
		return "/sign-up/find-company";
	}
	
	@PostMapping("find-company")
	public String findCompany(
			@RequestParam(name = "user-company") Integer userCompany,
			HttpSession session
			) {
		
		System.out.println(userCompany);
		Employee newEmp = (Employee) session.getAttribute("tmpEmp");
		System.out.println(newEmp);
		newEmp.setCompanyId(userCompany);
		System.out.println(newEmp);
		
		service.signUp(newEmp);
		
		
		return "redirect:/sign-up/waiting";
	}
	
	@GetMapping("waiting")
	public String wating() {
		return "/sign-up/waiting";
	}
}
