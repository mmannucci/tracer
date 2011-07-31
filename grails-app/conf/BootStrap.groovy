class BootStrap {
    def fixtureLoader

    def init = { servletContext ->
        fixtureLoader.load('posts')
    }
    def destroy = {
    }
}
