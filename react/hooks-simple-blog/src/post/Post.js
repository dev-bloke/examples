import React from 'react'
function Post ({ title, content, author }) {
     return (
        <div>
            <h3>{title}</h3>
            <div>{content}</div>
            <br />
            <i>Written by <b>{author}</b></i>
        </div>
    )
}

export default React.memo(Post)
