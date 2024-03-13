import React, { useContext } from 'react'
import Post from './Post'
import { StateContext } from "../contexts";

export default function PostList () {
    const { state } = useContext(StateContext)
    const { posts } = state
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
