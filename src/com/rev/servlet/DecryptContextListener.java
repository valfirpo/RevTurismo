package com.rev.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;
import org.jasypt.hibernate3.encryptor.HibernatePBEEncryptorRegistry;

public class DecryptContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
		config.setPasswordEnvName("MY_SECRET");
		
		StandardPBEStringEncryptor strongEncryptor = new StandardPBEStringEncryptor();
		strongEncryptor.setAlgorithm("PBEWITHMD5ANDDES");
		strongEncryptor.setConfig(config);
		HibernatePBEEncryptorRegistry registry = HibernatePBEEncryptorRegistry.getInstance();
		registry.registerPBEStringEncryptor("hibernateEncyptor", strongEncryptor);

	}

}
