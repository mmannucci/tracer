package org.markomannux.tracer.blog.pages
import org.codehaus.groovy.grails.plugins.webdriver.WebDriverPage
import org.codehaus.groovy.grails.plugins.webdriver.ButtonElement

class ShowPostPage extends WebDriverPage {
    static expectedTitle = "Show Post"

    String title
    String body
    String tags

    String errors

    static elements = {
        errors(By.cssSelector("div.error"))
    }

}

