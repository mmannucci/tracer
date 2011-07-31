import org.markomannux.tracer.tokeninput.Post
build {
    100.times {
    pippo"$it"(Post, title: "Post $it") 
    }
}
