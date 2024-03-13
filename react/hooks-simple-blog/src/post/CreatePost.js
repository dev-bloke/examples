import React, { useState, useContext } from 'react'
import { StateContext } from "../contexts";

export default function CreatePost () {

    const { state, dispatch } = useContext(StateContext)
    const { user } = state
    const [ title, setTitle ] = useState('')
    const [ content, setContent ] = useState('')

    function handleContent(event) {
        setContent(event.target.value)
    }

    function handleTitle(event) {
        setTitle(event.target.value)
    }

    function handleCreate(event) {
        dispatch({ type: "CREATE_POST", title, content, author: user })
    }

    return (
        <form onSubmit={e => { e.preventDefault(); handleCreate() }}>
            <div>Author: <b>{user}</b></div>
            <div>
                <label htmlFor="create-title">Title:</label>
                <input type="text" name="create-title" id="create-title" value={title} onChange={handleTitle}/>
            </div>
            <textarea name="create-content" value={content} onChange={handleContent} />
            <input type="submit" value="Create" />
        </form>
    )
}