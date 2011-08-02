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
        assertEquals fixtureLoader['posts'].charlie, orderedPostList[1].author
        assertEquals fixtureLoader['posts'].bob, orderedPostList[2].author
        assertEquals fixtureLoader['posts'].alice, orderedPostList[3].author

        orderedPostList = Post.nestedPropertiesAwareList([sort:'a.name', order:'asc'])
        assertEquals fixtureLoader['posts'].alice, orderedPostList[0].author
        assertEquals fixtureLoader['posts'].bob, orderedPostList[1].author
        assertEquals fixtureLoader['posts'].charlie, orderedPostList[2].author
        assertEquals fixtureLoader['posts'].denise, orderedPostList[3].author
    }
}
