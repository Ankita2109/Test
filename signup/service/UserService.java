package com.cts.signup.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.signup.bean.FavouriteArticle;
import com.cts.signup.bean.Language;
import com.cts.signup.bean.Role;
import com.cts.signup.bean.SignupStatus;
import com.cts.signup.bean.User;
import com.cts.signup.repository.ArticleRepository;
import com.cts.signup.repository.LanguageRepository;
import com.cts.signup.repository.RoleRepository;
import com.cts.signup.repository.UserRepository;

@Service
public class UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private ArticleRepository articleRepository;

	@Autowired
	private LanguageRepository languageRepository;

	@Transactional
	public SignupStatus addUserDetails(User user) {
		LOGGER.info(" START");

        LOGGER.info("User {} ", user);
        SignupStatus status = new SignupStatus();
        User oldUserList = userRepository.findByEmail(user.getEmail());
        if (oldUserList == null) {
               Role role = roleRepository.findById(2);
               user.setRole(role);
               Language language = languageRepository.getOne(user.getLanguage().getId());
               user.setLanguage(language);
               userRepository.save(user);
               System.out.println("User " + user);
               status.setEmailExist(false);
               status.setMessage("Email Id not found and User Details saved successfully.");
               status.setSignupStatus(true);
               LOGGER.debug("final status is : {} ", status);
        } else {
               status.setEmailExist(true);
               status.setMessage("Email Id already exists and User Details cannot be saved.");
               status.setSignupStatus(false);
               LOGGER.debug("final status is : {} ", status);
        }

        LOGGER.info("END");

        return status;
 }


	public List<User> getEveryUser() {
		List<User> user = userRepository.findAll();
		return user;
	}

	public List<Language> getEveryLanguage() {
		List<Language> language = languageRepository.findAll();
		return language;
	}

	@Transactional
	public User saveAnalystStatus(String email) {
		User user = userRepository.findByEmail(email);
		LOGGER.info("email");
		if (user.getRole().getId() == 2) {
			if (user.getBlacklisted().equals("No")) {
				user.setBlacklisted("Yes");
			} else {
				user.setBlacklisted("No");
			}
			userRepository.save(user);

			return userRepository.findByEmail(email);
		}

		else
			return null;
	}

	public boolean checkUserByEmail(User user) {

		User existedUser = null;

		// List<User> userList = userRepository.findAll();
		/*
		 * for (User users : userList) { existedUser = users; }
		 */

		existedUser = userRepository.findByEmail(user.getEmail());
		if (existedUser != null) {

			return true;
		}

		return false;

	}

	@Transactional
	public User findAnalyst(String email) {
		LOGGER.info("START");

		User user = userRepository.findByEmail(email);
		if (user.getRole().getId() == 2) {
			LOGGER.debug("news Reporter details: {} ", user);
			LOGGER.info("END");
			return user;
		} else
			return null;

	}

	@Transactional
	public void getArticleList(User user) {
		LOGGER.info("UserService addArticle() starts ");
		LOGGER.debug("Incoming User details ; " + user);
		FavouriteArticle newArticle = user.getFavouriteArticle().get(0);
		List<FavouriteArticle> privousArticles = new ArrayList<FavouriteArticle>();
		//List<FavouriteArticle> newArticles = user.getFavouriteArticle();
		user = userRepository.findByEmail(user.getEmail());
		LOGGER.debug("Incoming user new article" + newArticle);
		privousArticles = user.getFavouriteArticle();
		//for (FavouriteArticle article : newArticles) {
		newArticle.setLanguage(languageRepository.getOne(newArticle.getLanguage().getId()));
			if (articleRepository.findByTitle(newArticle.getTitle()) == null) {
				articleRepository.save(newArticle);
			}
			newArticle = articleRepository.findByTitle(newArticle.getTitle());
			LOGGER.debug("New article is : " + newArticle);
			privousArticles.add(newArticle);
		//}
		user.setFavouriteArticle(privousArticles);
		LOGGER.debug("User favourite article{}", user);
		userRepository.save(user);
		LOGGER.info("UserService addArticle() ends ");
	}

	@Transactional
	public User articleListforOneUser(String email) {
		User user = userRepository.findByEmail(email);

		return user;
	}

	@Transactional
	public void removeArticle(User user) {
		LOGGER.info("Start");
		FavouriteArticle article = user.getFavouriteArticle().get(0);
		LOGGER.debug("Incoming delete request for article is  : {} ", article);
		user = userRepository.findByEmail(user.getEmail());
		LOGGER.debug("actual user is  : {} ", user);
		
		

		for (int i = 0; i < user.getFavouriteArticle().size(); i++) {
			if (user.getFavouriteArticle().get(i).getTitle().equals(article.getTitle())) {
				user.getFavouriteArticle().remove(user.getFavouriteArticle().get(i));
			}
		}

	}

}
/*
 * @Transactional public void selectedFavouriteArticle(){ User
 * user=userRepository.fetchUserByEmail(email); if(user.getRole().getId()==2) {
 * String userLanguage=user.getLanguage().getName(); } }
 */
/*
 * private static final Logger LOGGER =
 * LoggerFactory.getLogger(SignupService.class);
 * 
 * @Autowired private userRepository signupDao;
 * 
 * @Transactional public SignupStatus addUserDetails(User user) {
 * 
 * LOGGER.info("SignupService addUserDetails() starts ");
 * LOGGER.debug("User Details from frontend : {} ", user); SignupStatus
 * signupStatus= new SignupStatus(); if (!signupDao.checkUserByEmail(user)) {
 * signupDao.add(user); signupStatus.setSignupStatus(true);
 * signupStatus.setEmailExist(false);
 * signupStatus.setMessage("User details added sucessfully.");
 * LOGGER.info("User details added sucessfully."); } else {
 * signupStatus.setSignupStatus(false); signupStatus.setEmailExist(true);
 * signupStatus.setMessage("Email Id already Exists. ");
 * LOGGER.info("Email Id already Exists. "); }
 * LOGGER.info("signupDao addUserDetails() execution completed!!!"); return
 * signupStatus; }
 */
