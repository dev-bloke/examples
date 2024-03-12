import React, { useReducer } from 'react'

import CreatePost from "./post/CreatePost";
import PostList from './post/PostList'
import UserBar from "./user/UserBar";
import { postReducer} from "./reducers/postReducer";
import { userReducer } from "./reducers/userReducer"

const defaultPosts = [
  { title: "My First Post", content: "Nothing to see here, move along.", author: "Barney" },
  { title: "My Second Post", content: "Still nothing to see here, move along.", author: "Pepper" },
  { title: "My Third Post", content: "Read mine! Read mine!", author: "Boo" }
]

export default function App () {

  const [posts, dispatchPosts ] = useReducer(postReducer, defaultPosts)
  const [ user, dispatchUser ] = useReducer(userReducer, '')

  return (
      <div style={{ padding: 8 }}>
        <UserBar user={user} dispatch={dispatchUser} />
        <br/>
          {user && <CreatePost user={user} posts={posts} dispatch={dispatchPosts} />}
        <hr/>
        <PostList posts={posts} />
      </div>
  )
}
