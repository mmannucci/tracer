package org.markomannux.tracer.blog

import grails.test.*

class PostTests extends GroovyTestCase {
    def fixtureLoader
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testCount() {
        fixtureLoader.load('posts')
        assertEquals 2, Post.count()
    }

    void testOrderByAuthor() {
        fixtureLoader['posts'].load('posts_for_ordering')
        def orderedPostList = Post.nestedPropertiesAwareList([sort:'a.name', order:'desc'])
        assertEquals fixtureLoader['posts'].denise, orderedPostList[0].author
    }
}
