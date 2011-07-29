package org.markomannux.tracer.tokeninput

class Post {

    String title
    String body
    String tags
    static constraints = {
        title(nullable:false, blank:false)
        body(nullable:false, blank:false, maxSize:1000)
        tags(nullable:true)
    }

    def selectedTagsList() {
        tags?.split(',')?.collect {
            it
        }
    }
}
