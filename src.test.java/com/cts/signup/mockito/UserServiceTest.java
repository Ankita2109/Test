package com.cts.signup.mockito;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.cts.signup.bean.Language;
import com.cts.signup.bean.Role;
import com.cts.signup.bean.SignupStatus;
import com.cts.signup.bean.User;
import com.cts.signup.repository.ArticleRepository;
import com.cts.signup.repository.LanguageRepository;
import com.cts.signup.repository.RoleRepository;
import com.cts.signup.repository.UserRepository;
import com.cts.signup.service.UserService;

public class UserServiceTest {

	@Mock
	private UserRepository userRepository;
	@Mock
	private RoleRepository roleRepository;
	@Mock
	private LanguageRepository languageRepository;
	@Mock
	private ArticleRepository articleRepository;
	
	@InjectMocks
	private UserService userservice;
	
	
	
    @Before
	    public void setUp() throws Exception {
	         MockitoAnnotations.initMocks(this);
	    }
    
    @Test
    public void testSaveUserDetails() {    
    	User nullUser = null;
        User user = new User();
        Role role = new Role();
        Language language = new Language();
        user.setEmail("Ankita@cogni.com");
        user.setPassword("12345678");
        user.setName("Ankita");
        user.setFavouriteArticle(null);
        user.setBlacklisted("No");
        role.setId(2);
        user.setRole(role);
        language.setId(7);
        user.setLanguage(language);
        Mockito.when(userRepository.findByEmail(user.getEmail()) ).thenReturn(nullUser);
        SignupStatus status=userservice.addUserDetails(user);
        assertEquals(true, status.isSignupStatus() && !status.isEmailExist());
               
    }
    
    @Test
    public void testDuplicateUserEmail() {
        User user = new User();
        Role role = new Role();
        Language language = new Language();
        user.setEmail("anki@gmail.com");
        user.setPassword("12345678");
        user.setName("Ankita");
        user.setFavouriteArticle(null);
        user.setBlacklisted("No");
        role.setId(2);
        user.setRole(role);
        language.setId(7);
        user.setLanguage(language);
        User existedUser = userRepository.findByEmail(user.getEmail());
        Mockito.when(userRepository.findByEmail(user.getEmail()) ).thenReturn(existedUser);
        SignupStatus status=userservice.addUserDetails(user);
        assertEquals(false, !status.isSignupStatus() && status.isEmailExist());
                 
    }
    
    
}
