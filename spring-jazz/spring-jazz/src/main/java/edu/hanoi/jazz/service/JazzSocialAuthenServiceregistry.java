package edu.hanoi.jazz.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.social.security.SocialAuthenticationServiceRegistry;
import org.springframework.social.security.provider.SocialAuthenticationService;

public class JazzSocialAuthenServiceregistry extends SocialAuthenticationServiceRegistry{

	private List<SocialAuthenticationService<?>> authenticationServices;
	

	public JazzSocialAuthenServiceregistry(List<SocialAuthenticationService<?>> authenticationServices) {
		super();
		this.authenticationServices = authenticationServices;
	}
	@PostConstruct
	public void init() {
		if(authenticationServices==null) {
			return;
		}
		authenticationServices.forEach(auth->{
			super.addAuthenticationService(auth);
		});
	}
}
