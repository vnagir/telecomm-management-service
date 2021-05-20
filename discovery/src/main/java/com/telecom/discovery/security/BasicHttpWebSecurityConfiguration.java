/**
 * Copyright (C) 2020 Securonix, Inc. All rights reserved.
 * <p>
 * All information contained herein is, and remains the property of SECURONIX and
 * its suppliers, if any. The intellectual and technical concepts contained herein are
 * proprietary to SECURONIX and are protected by trade secret or copyright law.
 */
package com.telecom.discovery.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * BasicHttpWebSecurityConfiguration
 *
 * @author : Dattatray Gund
 * @since  : v6.4 - 12 May 2020
 *
 */
@Configuration
@EnableWebSecurity
public class BasicHttpWebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().ignoringAntMatchers("/actuator/**", "/eureka/**").disable().authorizeRequests().anyRequest()
//				.authenticated().and().httpBasic();
        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/actuator/**", "/eureka/**");
    }
}
