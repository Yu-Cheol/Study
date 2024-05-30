package net.daum.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import lombok.extern.java.Log;

@Log
@EnableWebSecurity //이 애노테이션은 스프링 웹 시큐리티로 인식되게 한다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  //스프링 웹 시큐리티 설정을 담당하는 WebSecurityConfigurerAdapter 클래스를 상속받는다.
	
	@Autowired
	DataSource dataSource; //DBCP 커넥션 풀 관리 DataSource를 통한 sql문 처리
	
	@Autowired
	ZerockUsersService zerockUsersService;
	
	@Bean //스프링 빈등록
	public PasswordEncoder passwordEncoder() {//비번 암호화 빈등록
		return new BCryptPasswordEncoder();
	}//PasswordEncoder 빈등록하고 다른클래스에서 의존성 주입해야 에러 안나고 사용가능함.	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	 //HttpSecurity는 웹과 관련된 다양한 보안설정을 걸어 줄 수 있다.
		
		log.info("security config 시작.......");
		
		http.authorizeRequests().antMatchers("/guest/**").permitAll();
		/* authorizeRequests()는 시큐리티 처리에서 HttpServletRequest에 해당한다.
		 * antMatchers()에서는 특정한 경로를 지정한다. permitAll()은 모든 사용자가
		 * 접근할 수 있다는 것을 의미한다.
		 */
		http.authorizeRequests().antMatchers("/manager/**")
		.hasRole("MANAGER");//hasRole()은 특정권한을 가진 사람만이 접근할 수 있다는 것을
		//의미한다.
		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");// /admin 매핑주소로
		//접근할 때는 'ADMIN'이라는 권한이 있어야만 하는 설정 추가
		
		http.formLogin().loginPage("/login");
		/* http.formLogin()을 추가하면 스프링 시큐리티에서 제공하는 기본 로그인 페이지가 나
		 * 오게 한다.이때 사용하는 매핑주소는 /login이 된다. 
		 * 
		 * loginPage("/login")을 사용하면 매핑주소가 login인 사용자 즉 커스텀 로그인
		 * 페이지를 만들 수 있다.
		 */
		
		http.exceptionHandling().accessDeniedPage("/accessDenied");//403 접근금지 에러가 났을 때 실행
		http.logout().logoutUrl("/logout").invalidateHttpSession(true);//세션 무효화=>로그아웃
		
		http.rememberMe().key("zerock").userDetailsService(zerockUsersService)
		//rememberMe() 자동로그인에서 쿠키값을 암호화 해서 전달하므로 암호의 '키(key)'를 지정하여 사용
		.tokenRepository(getJDBCRepository())
		.tokenValiditySeconds(60*60*24);//쿠키 유효시간을 초단위로 설정=>60초*60분*24시간 즉 하루 쿠키유효시간
		//설정
    }//configure() 메서드	
	
	  private PersistentTokenRepository getJDBCRepository() {
		  /* SecurityConfig 에서 rememberMe()를 처리할 때 JdbcTokenRepositoryImpl를 지정해 주어야 하는대
		   * 기본적으로 DataSource가 필요함으로 의존성을 주입
		   */
		  JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
		  repo.setDataSource(dataSource);
		  return repo;
	  }//getJDBCRepository()
	
	//@Autowired
	/* 로그인 페이지에서 어떤 아이디나 비번을 입력해도 로그인 실패가 띄워진다. 이런 경우 로그인 되게
	 * 만들기 위해서 AuthenticationManagerBuilder를 주입해서 인증에 대한 처리를 해야 한다
	 */
	//public void configureGlobal(AuthenticationManagerBuilder auth)
	//throws Exception{//AuthenticationManagerBuilder는 인증에 대한 다양한 설정을
		//할수가 있다. 예를 들어 메모리상의 정보만을 이용한다든지, jdbc등을 이용해서 인증 처리가
		//가능하다. 여기서는 메모리 상의 인증 정보를 활용한다.
		
	//	log.info("메모리상의 아이디 manager,비번 1111로 로그인 인증 연습");
		
		//auth.inMemoryAuthentication().withUser("manager")
		//.password("{noop}1111").roles("MANAGER");
		/* 아이디 manager,비번 1111,권한 MANAGER 지정
		 * Spring 시큐리티 4에서는 메모리 내 인증을 사용하여 암호를  인코딩 즉 암호화 하지 않고
		 * 일반 텍스트로 저장할 수 있다.
		 * Spring 시큐리티 5부터는 비번을 인코딩 즉 암호화 해서 저장한다. 그러므로 There
		 * is no PasswordEncoder mapped for the id "null" 에러를 내지 않기 위해서
		 * 는 {noop}를 사용해서 비번을 암호화 해서 처리해야 한다.
		 */
	//}//configureGlobal()
}












