package com.krisbijan.fitit.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

 @Configuration
 @EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
	 

		@Override
		public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
			resources.resourceId(AuthorizationServerConfiguration.RESOURCE_ID);
		}
		
		@Override
		public void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().
			antMatchers("/test/admin").hasRole("ADMIN").
			antMatchers("/test/user").hasAnyRole("ADMIN","USER").
			antMatchers("/test/guest").permitAll();
		}


}