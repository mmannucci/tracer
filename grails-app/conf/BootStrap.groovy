import org.codehaus.groovy.grails.commons.GrailsApplication
import grails.util.GrailsUtil

class BootStrap {
    def fixtureLoader

    def init = { servletContext ->
        switch (GrailsUtil.environment) {
            case GrailsApplication.ENV_DEVELOPMENT:
                   fixtureLoader.load('posts')
                   fixtureLoader.load('post_long_list')
            break
        }
    }
    def destroy = {
    }
}
