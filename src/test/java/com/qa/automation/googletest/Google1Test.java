package com.qa.automation.googletest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.automation.annotation.LazyAutowired;
import com.qa.automation.pages.GooglePage;
import com.qa.automation.runner.SpringBaseTestNGTest;
import com.qa.automation.service.ScreenshotService;

import java.io.IOException;

public class Google1Test extends SpringBaseTestNGTest {

    @LazyAutowired
    private GooglePage googlePage;

    @LazyAutowired
    private ScreenshotService screenshotService;

    @Test
    public void googleTest() throws IOException {
        this.googlePage.goTo();
        Assert.assertTrue(this.googlePage.isAt());
        this.googlePage.getSearchComponent().search("spring boot");
        Assert.assertTrue(this.googlePage.getSearchResult().isAt());
        Assert.assertTrue(this.googlePage.getSearchResult().getCount() > 2);
        this.screenshotService.takeScreenShot();
//        this.googlePage.close();
    }

}
