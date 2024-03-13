import React, { useReducer, useEffect } from 'react'

import appReducer from "./reducers";
import CreatePost from "./post/CreatePost";
import PostList from './post/PostList'
import { StateContext } from "./contexts";
import UserBar from "./user/UserBar";


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
        <StateContext.Provider value={{ state, dispatch }}>
            <div style={{ padding: 8 }}>
                <UserBar />
                <br/>
                  {user && <CreatePost />}
                <hr/>
                <PostList />
            </div>
        </StateContext.Provider>
   )
}
