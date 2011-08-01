package org.markomannux.tracer.blog

class Author {

    String name

    static constraints = {
        name(blank:false)
    }
}
