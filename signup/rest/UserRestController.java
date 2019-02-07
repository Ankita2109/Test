package com.cts.signup.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.signup.bean.Language;
import com.cts.signup.bean.SignupStatus;
import com.cts.signup.bean.User;
import com.cts.signup.service.UserService;



@RestController
@RequestMapping("/signup")
public class UserRestController extends ExceptionController{
	private static final Logger LOGGER = LoggerFactory.getLogger(UserRestController.class);
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/user")
	public List<User> getAllUsers(){
		List<User> user= userService.getEveryUser();
		return user;
	}
	
	@PostMapping("/add")
	public SignupStatus signupUser(@RequestBody User user) {
		
		LOGGER.info("UserController saveUserOnSignup() Start");
        LOGGER.debug("User Status : {} ", user);
        SignupStatus status = new SignupStatus();
        status = userService.addUserDetails(user);
        LOGGER.debug("Status: {} ", status);
        LOGGER.info("UserController saveUserOnSignup() End");
        return status;

	}
	
	@GetMapping("/language")
	public List<Language> getAllLanguages(){
		List<Language> language= userService.getEveryLanguage();
		return language;
	}
	
	@GetMapping("/analystDetail/{email}")
	public User findAnalyst(@PathVariable("email") String email) {
		LOGGER.info(" START");
		User user = new User();
		user = userService.findAnalyst(email);
		LOGGER.debug("employee : {} ", user);
		LOGGER.info("END");
		return user;

	}
	
	@GetMapping("/saveUserStatus/{email}")
	public User saveAnalyst(@PathVariable("email") String email) {
		LOGGER.info("email");
		User user = userService.saveAnalystStatus(email);

		LOGGER.info("seat");
		return user;
	}
	
	@PostMapping("/articleList")
	public void saveArticleList(@RequestBody User user) {
	
		userService.getArticleList(user);	
		
	}
	
	@GetMapping("/getArticleList/{email}")
	public User getArticleList(@PathVariable("email") String email) {
		LOGGER.info("email");
		User user = userService.articleListforOneUser(email);

		LOGGER.info("seat");
		return user;
	}
	
	@PostMapping("/deleteArticles")
	public void deleteArticle(@RequestBody User user) {
	
		userService.removeArticle(user);	
		
	}
		/*@Autowired
		private SignupService signupService;

		
		 * @Autowired private RedeemCouponService redeemCouponService;
		 

		@PostMapping("/add")
		public SignupStatus signupUser(@RequestBody User user) {

			LOGGER.info("UserController signupUser() start");
			SignupStatus status = signupService.addUserDetails(user);
			LOGGER.debug("Status : {}", status);
			System.out.println("Status:\n\n"+status);
			return status;

		}*/
	
	
	}

