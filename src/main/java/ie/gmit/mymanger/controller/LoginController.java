package ie.gmit.mymanger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * The Class LoginController.
 */
@Controller
@RequestMapping
public class LoginController {

	/**
	 * Login.
	 *
	 * @return the string the login page
	 */
	@GetMapping("/login")
	public String login() {
		return "login";
	}

}
