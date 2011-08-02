package org.markomannux.tracer
import org.codehaus.groovy.grails.commons.ApplicationHolder as AH

import org.junit.Rule
import org.codehaus.groovy.grails.plugins.webdriver.WebDriverHelper
import org.openqa.selenium.By

abstract class FunctionalTest extends GroovyTestCase {
    @Rule
    public WebDriverHelper webdriver = new WebDriverHelper()
}

