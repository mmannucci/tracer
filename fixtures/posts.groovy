import org.markomannux.tracer.blog.Post
import org.markomannux.tracer.blog.Author

fixture {
    bob(Author, name:"Bob")
    alice(Author, name:"Alice")

    post1(Post, title: "About fixtures", author:bob) {
        body = """Fixtures are a way to define data in tests.
            Data in tests must be predictable and reproducible.
            There are many frameworks that deals with fixtures."""
            tags="Fixtures,Testing"
    }
    post2(Post, title: "About Grails testing", author:alice) {
        body = "Testing in Grails is much easier with fixtures"
            tags="Fixtures,Testing,Grails"
    }
}
