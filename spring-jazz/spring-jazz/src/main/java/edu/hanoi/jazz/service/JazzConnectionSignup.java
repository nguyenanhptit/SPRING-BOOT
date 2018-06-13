package edu.hanoi.jazz.service;
import org.apache.log4j.Logger;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;

public class JazzConnectionSignup implements ConnectionSignUp {


	public static final Logger logger = Logger.getLogger(JazzConnectionSignup.class);
	
	@Override
	public String execute(Connection<?> connection) {
		// TODO Auto-generated method stub
		UserProfile userProfile = connection.fetchUserProfile();
		logger.info("----------> id " +userProfile.getId() + "name" +userProfile.getName());
		return null;
	}

}
