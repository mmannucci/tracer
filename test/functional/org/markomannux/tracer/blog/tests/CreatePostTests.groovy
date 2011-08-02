package org.markomannux.tracer.blog.tests
import org.junit.Test
import org.markomannux.tracer.FunctionalTest
import org.codehaus.groovy.grails.commons.ApplicationHolder as AH

import org.codehaus.groovy.grails.plugins.webdriver.WebDriverHelper
 
import org.junit.Before
import org.openqa.selenium.By

import org.markomannux.tracer.blog.pages.CreatePostPage
import org.markomannux.tracer.blog.pages.ShowPostPage

class CreatePostTests extends FunctionalTest {
    def fixtureLoader

    private CreatePostPage createPostPage

    @Before
    public void openCreatePage() {
        def ctx = AH.application.mainContext
        fixtureLoader = ctx.fixtureLoader
        fixtureLoader.load('posts')
        createPostPage = webdriver.open('/post/create', CreatePostPage.class)
    }

    @Test
    public void testCreatePostWithEmptyField() {
        createPostPage.create.clickStay()
        assertTrue(createPostPage.errors.matches(/.*title.*/))
	}

    @Test
    public void testSuccesfulCreate() {
        createPostPage.title = 'A good test'
        createPostPage.body = 'Finger crossed'
        ShowPostPage showPage = createPostPage.create.click()

        assertEquals 'A good test', showPage.title 
    }
}

