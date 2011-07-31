import org.markomannux.tracer.blog.Post
build {
    100.times {
    pippo"$it"(Post, title: "Post $it") 
    }
}
