package com.kszpakowski.cdc;

import com.kszpakowski.cdc.entity.User;
import com.kszpakowski.cdc.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Transactional
@EnableJpaRepositories(repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
@SpringBootApplication
public class CdcApplication implements CommandLineRunner {

	private final UserRepository userRepository;

	public CdcApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CdcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var user = new User();
		user.setFirstname("Roger");
		user.setLastname("Bloom");

		userRepository.save(user);

		userRepository.findById(1L)
				.map(u -> { u.setFirstname("Michael"); return u; })
				.ifPresent(userRepository::save);
	}
}
