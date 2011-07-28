package org.markomannux.tracer.tokeninput

class Post {

    String title
    String body
    String tags
    static constraints = {
        title(nullable:false, blank:false)
        body(nullable:false, blank:false)
        tags(nullable:true)
    }
}
