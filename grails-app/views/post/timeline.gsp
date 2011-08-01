
<%@ page import="org.markomannux.tracer.blog.Post" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <link rel="stylesheet" href="${resource(dir:'css', file:'post.css')}" type="text/css" media="screen, projection">
        <g:set var="entityName" value="${message(code: 'post.label', default: 'Post')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:each in="${postInstanceList}" var="postInstance">
            <g:render template="post" bean="${postInstance}" var="post" />
            </g:each>
            <div class="paginateButtons">
                <g:paginate total="${postInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
