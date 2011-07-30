

<%@ page import="org.markomannux.tracer.tokeninput.Post" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'post.label', default: 'Post')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>

        <link rel="stylesheet" href="${resource(dir:'css/ui-lightness',file:'jquery-ui-1.8.12.custom.css')}" />
        <link rel="stylesheet" href="${resource(dir:'css/token-input',file:'token-input.css')}" />
        <script type="text/javascript" src="${resource(dir:'js/jquery',file:'jquery-1.5.1.min.js')}" ></script>
        <script type="text/javascript" src="${resource(dir:'js/jquery',file:'jquery-ui-1.8.12.custom.min.js')}" ></script>
        <script type="text/javascript" src="${resource(dir:'js/jquery',file:'jquery.tokeninput.js')}" ></script>
        
         <script type="text/javascript"> 
        $(document).ready(function() {

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
             prePopulate: ${selectedTags}});
        });
        </script>

    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${postInstance}">
            <div class="errors">
                <g:renderErrors bean="${postInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${postInstance?.id}" />
                <g:hiddenField name="version" value="${postInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="title"><g:message code="post.title.label" default="Title" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: postInstance, field: 'title', 'errors')}">
                                    <g:textField name="title" value="${postInstance?.title}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="body"><g:message code="post.body.label" default="Body" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: postInstance, field: 'body', 'errors')}">
                                    <g:textArea name="body" cols="40" rows="5" value="${postInstance?.body}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="tags"><g:message code="post.tags.label" default="Tags" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: postInstance, field: 'tags', 'errors')}">
                                    <g:textField name="tags" value="${postInstance?.tags}" />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
