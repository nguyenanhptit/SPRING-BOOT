package edu.hanoi.jazz.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.apache.log4j.Logger;
public class UserAuthProvider implements AuthenticationProvider{
	public static final Logger logger = Logger.getLogger(UserAuthProvider.class);

	@Override
	public Authentication authenticate(Authentication arg0) throws AuthenticationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

//	@Autowired
//	private UserDAO userDAO;
//
//	@Override
//	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//		String username = authentication.getName();
//		User user = userDAO.getUserByUsername(username);
//		if (user == null) {
//			return null;
//		}
//		logger.info("---------------> Found" + user + " by " + username);
//		if (!user.getPassword().equals(authentication.getCredentials().toString())) {
//			return null;
//		}
//		return successful(username, authentication.getCredentials().toString(), user.getPassword());
//	}
//
//	private Authentication successful(String username, String role, String password) {
//		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
//		grantedAuthorities.add(new SimpleGrantedAuthority(role));
//		return new UsernamePasswordAuthenticationToken(username, password, grantedAuthorities);
//	}
//
//	@Override
//	public boolean supports(Class<?> authentication) {
//		return authentication.equals(UsernamePasswordAuthenticationToken.class);
//	}
//
//	@Override
//	public Authentication authenticate(Authentication arg0) throws AuthenticationException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
}
