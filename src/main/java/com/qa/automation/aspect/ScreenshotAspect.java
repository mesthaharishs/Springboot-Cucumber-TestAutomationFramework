package com.qa.automation.aspect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.qa.automation.annotation.TakeScreenshot;
import com.qa.automation.service.ScreenshotService;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import java.io.IOException;

@Aspect
@Component
public class ScreenshotAspect {

	@Lazy
    @Autowired
    private ScreenshotService screenshotService;

    @After("@annotation(takeScreenshot)")
    public void after(TakeScreenshot takeScreenshot) throws IOException {
        this.screenshotService.takeScreenShot();
    }

}
