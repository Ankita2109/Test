package com.cts.signup.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.signup.bean.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	User findByEmail(String email);
	//List<User> findAll();
	
	/*private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(EntityManagerFactory emFactory) {
		this.sessionFactory = emFactory.unwrap(SessionFactory.class);
	}

	public void add(User user) {

		LOGGER.info("SignupDao add() starts");
		Session session = sessionFactory.openSession();
		session.save(user);
		session.close();
		

	}

	public boolean checkUserByEmail(User user) {
		LOGGER.info("SignupDao checkUserByEmail() starts ");
		User existedUser = null;
		Session session = sessionFactory.openSession();
		List<User> userList = (List<User>) session.createQuery("select u from User u where u.email = :emailid")
				.setParameter("emailid", user.getEmail()).list();
		LOGGER.debug("Pre User List : " + userList);
		session.close();
		for (User users : userList) {
			existedUser = users;
		}
		if (existedUser != null) {
			LOGGER.info("User Details By Email {}", existedUser);
			return true;
		}
		LOGGER.info("SignupDao checkUserByEmail() exceution ends !!!");
		return false;

	}*/
}
