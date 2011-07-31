class BootStrap {
    def fixtureLoader

    def init = { servletContext ->
        fixtureLoader.load('posts')
        fixtureLoader.load('post_long_list')
    }
    def destroy = {
    }
}
