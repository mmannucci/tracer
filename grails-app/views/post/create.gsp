

<%@ page import="org.markomannux.tracer.tokeninput.Post" %>
<%@ page import="grails.converters.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'post.label', default: 'Post')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
        <link rel="stylesheet" href="${resource(dir:'css/ui-lightness',file:'jquery-ui-1.8.12.custom.css')}" />
        <link rel="stylesheet" href="${resource(dir:'css/token-input',file:'token-input.css')}" />
        <script type="text/javascript" src="${resource(dir:'js/jquery',file:'jquery-1.5.1.min.js')}" ></script>
        <script type="text/javascript" src="${resource(dir:'js/jquery',file:'jquery-ui-1.8.12.custom.min.js')}" ></script>
        <script type="text/javascript" src="${resource(dir:'js/jquery',file:'jquery.tokeninput.js')}" ></script>
        
         <script type="text/javascript"> 
        $(document).ready(function() {

            var selected = ${selectedTags}
            $("#tags").tokenInput([
                {id: "Ruby", name: "Ruby"},
                {id: "Python", name: "Python"},
                {id: "JavaScript", name: "JavaScript"},
                {id: "ActionScript", name: "ActionScript"},
                {id: "Scheme", name: "Scheme"},
                {id: "Lisp", name: "Lisp"},
                {id: "C#", name: "C#"},
                {id: "Java", name: "Java"}
            ],
            {preventDuplicates: true,
             prePopulate: selected});
        });
        </script>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${postInstance}">
            <div class="error">
                <g:renderErrors bean="${postInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" >
            <fieldset>  
            <legend>Insert post data</legend>
            <p>
            <label for="title"><g:message code="post.title.label" default="Title" /></label><br />
            <g:textField name="title" class="title ${hasErrors(bean: postInstance, field: 'title', 'errors')}" value="${postInstance?.title}" />
            </p>
            <p>
            <label for="body"><g:message code="post.body.label" default="Body" /></label><br />
            <g:textArea name="body" cols="40" rows="5" value="${postInstance?.body}" />
            </p>
            <p>
            <label for="tags"><g:message code="post.tags.label" default="Tags" /></label>
            <g:textField name="tags" value="${postInstance?.tags}" />
            </p>
            </fieldset>
                <div class="buttons">
                    <span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
