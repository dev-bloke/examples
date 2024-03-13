import React, { useReducer, useEffect } from 'react'
import { useResource } from 'react-request-hook'

import appReducer from "./reducers";
import CreatePost from "./post/CreatePost";
import PostList from './post/PostList'
import { StateContext } from "./contexts";
import UserBar from "./user/UserBar";

const title = "My Simple Blog"

export default function App () {
    const [ state, dispatch ] = useReducer(appReducer, { user: '', posts: [] })
    const { user } = state

    const [ posts, getPosts ] = useResource(() => ({
        url: "/post",
        method: "get"
    }))

    useEffect(getPosts, [])

    useEffect(() => {
        if (posts && posts.data) {
            dispatch({ type: "FETCH_POSTS", posts: posts.data })
        }
    }, [posts])

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
