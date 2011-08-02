package org.markomannux.tracer.blog.pages
import org.codehaus.groovy.grails.plugins.webdriver.WebDriverPage
import org.codehaus.groovy.grails.plugins.webdriver.ButtonElement

class CreatePostPage extends WebDriverPage {
    static expectedTitle = "Create Post"

    String title
    String body
    String tags

    String errors

    ButtonElement<ShowPostPage> create

    static elements = {
        errors(By.cssSelector("div.error"))
    }

}
