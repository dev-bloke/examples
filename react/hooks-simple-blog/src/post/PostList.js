import React from 'react'
import Post from './Post'

export default function PostList ({ posts = [] }) {
    return (
        <div>
            { posts.map((post, index) => (
                <React.Fragment>
                    <Post {...post} key={'post-' + index} />
                    <hr />
                </React.Fragment>
            ))}
        </div>
    )
}
