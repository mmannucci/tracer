package org.markomannux.tracer.blog

import grails.converters.*

class PostController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        def postList = Post.nestedPropertiesAwareList(params)
        [postInstanceList: postList, postInstanceTotal: postList.totalCount]
    }

    def timeline = {
        params.max = Math.min(params.max ? params.int('max') : 5, 100)
        params.sort = 'dateCreated'
        params.order = 'desc'
        [postInstanceList: Post.list(params), postInstanceTotal: Post.count()]
    }

    def create = {
        def postInstance = new Post()
        postInstance.properties = params
        def selectedTags = selectedTags(postInstance)
        return [postInstance: postInstance, selectedTags:selectedTags]
    }

    def save = {
        def postInstance = new Post(params)
        if (postInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'post.label', default: 'Post'), postInstance.id])}"
            redirect(action: "show", id: postInstance.id)
        }
        else {
            render(view: "create", model: [postInstance: postInstance, selectedTags:selectedTags(postInstance)])
        }
    }

    def show = {
        def postInstance = Post.get(params.id)
        if (!postInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'post.label', default: 'Post'), params.id])}"
            redirect(action: "list")
        }
        else {
            [postInstance: postInstance]
        }
    }

    def edit = {
        def postInstance = Post.get(params.id)
        if (!postInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'post.label', default: 'Post'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [postInstance: postInstance, selectedTags:selectedTags(postInstance)]
        }
    }

    def update = {
        def postInstance = Post.get(params.id)
        if (postInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (postInstance.version > version) {
                    
                    postInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'post.label', default: 'Post')] as Object[], "Another user has updated this Post while you were editing")
                    render(view: "edit", model: [postInstance: postInstance])
                    return
                }
            }
            postInstance.properties = params
            if (!postInstance.hasErrors() && postInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'post.label', default: 'Post'), postInstance.id])}"
                redirect(action: "show", id: postInstance.id)
            }
            else {
                render(view: "edit", model: [postInstance: postInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'post.label', default: 'Post'), params.id])}"
            redirect(action: "list")
        }
    }

    /*
     * Crea il JSON necessario al prepopolamento del token input
     */
    private selectedTags(postInstance) {
        postInstance?.selectedTagsList().collect {
            [id:it, name:it]
        } as JSON
    }

    def delete = {
        def postInstance = Post.get(params.id)
        if (postInstance) {
            try {
                postInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'post.label', default: 'Post'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'post.label', default: 'Post'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'post.label', default: 'Post'), params.id])}"
            redirect(action: "list")
        }
    }
}
