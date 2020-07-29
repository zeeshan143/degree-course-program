package zee.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CMSHome {

	@GetMapping("/")
	public String homePage() { return "/users/home"; }

	@GetMapping("/collegeStaff")
	public String staff() { return "/staff/staff-admin"; }

}
