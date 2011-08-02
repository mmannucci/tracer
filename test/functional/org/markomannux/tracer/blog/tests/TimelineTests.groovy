package org.markomannux.tracer.blog.tests
import org.junit.Test
import org.codehaus.groovy.grails.commons.ApplicationHolder as AH

import org.codehaus.groovy.grails.plugins.webdriver.WebDriverHelper
import org.junit.Rule
import org.junit.Before
import org.openqa.selenium.By

import org.markomannux.tracer.blog.pages.TimelinePage

class TimelineTests extends GroovyTestCase {
    def fixtureLoader

    @Rule
    public WebDriverHelper webdriver = new WebDriverHelper()

    private TimelinePage timelinePage

    @Before
    public void openTimelinePage() {
        def ctx = AH.application.mainContext
        fixtureLoader = ctx.fixtureLoader
        fixtureLoader.load('posts')
        timelinePage = webdriver.open('/timeline', TimelinePage.class)
    }

    @Test
    public void testOpenTimeLine() {

    }
    
    @Test
    public void testShowPost() {
		webdriver.driver.findElement(By.linkText("About fixtures")).click();
		assertEquals("Show Post", webdriver.driver.getTitle());
	}
}

