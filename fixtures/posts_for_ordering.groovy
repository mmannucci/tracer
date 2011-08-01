import org.markomannux.tracer.blog.Post
import org.markomannux.tracer.blog.Author

build {
    alice(Author, name:"Alice")
    bob(Author, name:"Bob")
    charlie(Author, name:"Charlie")
    denise(Author, name:"Denise")

    post1(Post, title: "Post 1", author:alice) 
    post2(Post, title: "Post 2", author:bob) 
    post3(Post, title: "Post 3", author:charlie) 
    post4(Post, title: "Post 4", author:denise) 
}
