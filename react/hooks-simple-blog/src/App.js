import React, { useState } from 'react'

import CreatePost from "./post/CreatePost";
import PostList from './post/PostList'
import UserBar from "./user/UserBar";

const posts = [
  { title: "My First Post", content: "Nothing to see here, move along.", author: "Barney" },
  { title: "My Second Post", content: "Still nothing to see here, move along.", author: "Pepper" },
  { title: "My Third Post", content: "Read mine! Read mine!", author: "Boo" }
]

export default function App () {

  const [ user, setUser ] = useState('')

  return (
      <div style={{ padding: 8 }}>
        <UserBar user={user} setUser={setUser} />
        <br/>
          {user && <CreatePost user={user} />}
        <hr/>
        <PostList posts={posts} />
      </div>
  )
}
