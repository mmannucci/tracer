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
        author(nullable:true)
        title(nullable:false, blank:false)
        body(nullable:false, blank:false, maxSize:1000)
        tags(nullable:true)
    }

    static def nestedPropertiesAwareList(params) {
        def criteria = Post.createCriteria()

        /*
         * Dimostrazione di come sia possibile ordinare rispetto a proprietà
         * innestate.
         * Il createAlias permette di definire il nome dell'associazione in modo
         * che sia lo stesso che viene richiesto dalla pagina.
         * NOTA: viene effettuta una inner join. Il comportamento può essere
         * modificato utilizzando la forma a tre parametri.
         * I parametri di ordinamento vanno gestiti esplicitamente nei criteria
         * e non possono essere passati come parametri al metodo list.
         */
        def postList = criteria.list(max:params.max, offset:params.offset) {
           createAlias "author", "a"

           if (params.sort) {
                order "${params.sort}" , params.order?:"asc"
           }
        }
    }

    def selectedTagsList() {
        tags?.split(',')?.collect {
            it
        }
    }
}
