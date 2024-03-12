import React, { useReducer, useEffect } from 'react'

import CreatePost from "./post/CreatePost";
import PostList from './post/PostList'
import UserBar from "./user/UserBar";
import appReducer from "./reducers";

const defaultPosts = [
  { title: "My First Post", content: "Nothing to see here, move along.", author: "Barney" },
  { title: "My Second Post", content: "Still nothing to see here, move along.", author: "Pepper" },
  { title: "My Third Post", content: "Read mine! Read mine!", author: "Boo" }
]

const title = "My Simple Blog"

export default function App () {
    const [ state, dispatch ] = useReducer(appReducer, {user: '', posts: defaultPosts})
    const { user, posts } = state

    useEffect(() => {
        if (user) {
            document.title = `${title} - ${user}`
        } else {
            document.title = title
        }
    }, [user])

    return (
        <div style={{ padding: 8 }}>
            <UserBar user={user} dispatch={dispatch} />
            <br/>
              {user && <CreatePost user={user} posts={posts} dispatch={dispatch} />}
            <hr/>
            <PostList posts={posts} />
        </div>
   )
}
