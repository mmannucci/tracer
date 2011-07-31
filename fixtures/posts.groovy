import org.markomannux.tracer.blog.Post
fixture {
    post1(Post, title: "About fixtures") {
        body = """Fixtures are a way to define data in tests.
            Data in tests must be predictable and reproducible.
            There are many frameworks that deals with fixtures."""
            tags="Fixtures,Testing"
    }
    post2(Post, title: "About Grails testing") {
        body = "Testing in Grails is much easier with fixtures"
            tags="Fixtures,Testing,Grails"
    }
}
