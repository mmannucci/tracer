package org.markomannux.tracer.blog.pages
import org.codehaus.groovy.grails.plugins.webdriver.WebDriverPage
import org.codehaus.groovy.grails.plugins.webdriver.ButtonElement
import org.openqa.selenium.RenderedWebElement
import org.openqa.selenium.WebElement

class ShowPostPage extends WebDriverPage {
    static expectedTitle = "Show Post"

    String title
    String body
    String tags

    String errors

    public void enterTagQuery() {
        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("token-input-tags"))

        // Enter something to search for
        element.sendKeys("ja")
    } 


 public void waitForAsyncContent() {
 // Get a RenderedWebElement corresponding to our div
   RenderedWebElement e = (RenderedWebElement) driver.findElement(By.cssSelector("div.token-input-dropdown ul"));
 // Up to 10 times
 for( int i=0; i<10; i++ ) {
   // Check whether our element is visible yet
   if( e.isDisplayed() ) {
     return;
   }

   try {
     Thread.sleep(1000);
   } catch( InterruptedException ex ) {
     // Try again
   }
   }
 }




    static elements = {
        errors(By.cssSelector("div.error"))
    }

}

