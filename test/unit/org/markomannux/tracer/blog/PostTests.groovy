package org.markomannux.tracer.tokeninput

import grails.test.*

class PostTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testSelectedTagList() {
        def post = new Post()
        post.tags = 'pippo,pluto,paperino'
        
        assert post.selectedTagsList().containsAll(['pippo', 'pluto', 'paperino'])
    }
}
