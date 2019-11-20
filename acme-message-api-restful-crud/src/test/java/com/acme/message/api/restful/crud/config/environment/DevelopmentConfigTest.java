package com.acme.message.api.restful.crud.config.environment;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acme.message.api.restful.crud.config.constant.DefaultSpringConfigConstant;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={DevelopmentConfig.class})
@ActiveProfiles(profiles={DefaultSpringConfigConstant.SPRING_PROFILE_DEVELOPMENT})
public class DevelopmentConfigTest {
	
	@Test
	public void shouldBeInjected() {
		assertTrue(true);
	}
}
