import React from 'react'

import CreatePost from "./post/CreatePost";
import PostList from './post/PostList'
import UserBar from "./user/UserBar";

const user = "Martin Ingram"

const posts = [
  { title: "My First Post", content: "Nothing to see here, move along.", author: "Barney" },
  { title: "My Second Post", content: "Still nothing to see here, move along.", author: "Pepper" },
  { title: "My Third Post", content: "Read mine! Read mine!", author: "Boo" }
]

export default function App () {
  return (
      <div style={{ padding: 8 }}>
        <UserBar user={user} />
        <br/>
        <CreatePost user={user} />
        <hr/>
        <PostList posts={posts} />
      </div>
  )
}
