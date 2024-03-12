import React, { useState } from 'react'

import CreatePost from "./post/CreatePost";
import PostList from './post/PostList'
import UserBar from "./user/UserBar";

const defaultPosts = [
  { title: "My First Post", content: "Nothing to see here, move along.", author: "Barney" },
  { title: "My Second Post", content: "Still nothing to see here, move along.", author: "Pepper" },
  { title: "My Third Post", content: "Read mine! Read mine!", author: "Boo" }
]

export default function App () {

  const [posts, setPosts ] = useState(defaultPosts)
  const [ user, setUser ] = useState('')

  return (
      <div style={{ padding: 8 }}>
        <UserBar user={user} setUser={setUser} />
        <br/>
          {user && <CreatePost user={user} posts={posts} setPosts={setPosts} />}
        <hr/>
        <PostList posts={posts} />
      </div>
  )
}
