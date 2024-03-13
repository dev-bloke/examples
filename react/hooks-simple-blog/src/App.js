import React, { useReducer, useEffect } from 'react'

import appReducer from "./reducers";
import CreatePost from "./post/CreatePost";
import PostList from './post/PostList'
import { StateContext } from "./contexts";
import UserBar from "./user/UserBar";

const title = "My Simple Blog"

export default function App () {
    const [ state, dispatch ] = useReducer(appReducer, { user: '', posts: [] })
    const { user, posts } = state

    useEffect (() => {
        fetch(`/api/post`)
            .then(result => result.json())
            .then(posts => dispatch({type: "FETCH_POSTS", posts }))
    }, [])

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
