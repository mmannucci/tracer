package org.markomannux.tracer.blog

class Post {

    Author author
    String title
    String body
    String tags

    /*
     * autotimestamp
     */
    Date dateCreated
    Date lastUpdated
    
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
