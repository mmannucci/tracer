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

    void testList() {
        fixtureLoader.load('posts')
        assertEquals 2, Post.count()
    }
}
