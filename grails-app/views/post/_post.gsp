<div class="post">
    <h2 id="title"><g:link action="show" id="${post.id}">${post.title}</g:link></h2>
    <h3>by ${post?.author?.name?:'Anonymous'}</h3>
    <p id="body">
        ${post.body}
    </p>
    <p id="tags">
        tags: ${post.tags}
    <p>
</div>
