package com.cts.signup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.signup.bean.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language,Integer> {
	Language findById(int id);
	
	}

//private static final Logger LOGGER = LoggerFactory.getLogger(LanguageRepository.class);
	
	/*private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(EntityManagerFactory emFactory) {
		this.sessionFactory = emFactory.unwrap(SessionFactory.class);
	}
	
	public List<Language> getLanguages(){		
		LOGGER.info("Start");
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Language> languages = (List<Language>) session.createQuery("from Language").list();		
		session.close();
		LOGGER.debug("Languages are:{}",languages);
		LOGGER.info("End");
		return languages;
	}*/
	
	