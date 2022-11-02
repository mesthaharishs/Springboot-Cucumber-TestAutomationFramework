package com.qa.automation.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import com.qa.automation.annotation.LazyConfiguration;
import com.qa.automation.annotation.ThreadScopeBean;

import io.github.bonigarcia.wdm.WebDriverManager;

@LazyConfiguration
public class WebdriverConfig {

	@Value("${default.timeout:300}")
	private int timeout;
	
	@ThreadScopeBean
	@ConditionalOnProperty(name = "browser", havingValue = "edge")
	protected WebDriver firefoxdriver() {
		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver();
	}
	
	@ThreadScopeBean
	@ConditionalOnProperty(name = "browser", havingValue = "edge")
	protected WebDriver edgedriver() {
		WebDriverManager.edgedriver().setup();
		return new EdgeDriver();
	}
	
	@ThreadScopeBean
	@ConditionalOnMissingBean
	protected WebDriver chromedriver() {
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver();
	}
	
}
