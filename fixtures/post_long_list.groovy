import org.markomannux.tracer.blog.Post
import org.markomannux.tracer.blog.Author

build {
    pippo(Author, name:"pippo")
    100.times {
    pippoPost"$it"(Post, title: "Post $it", author:pippo) 
    }
}
