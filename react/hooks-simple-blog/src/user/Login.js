import React, { useState } from 'react'

export default function Login ({ setUser }) {

    const [ userName, setUserName ] = useState('')

    function handleUserName(event) {
        setUserName(event.target.value)
    }

    return (
        <form onSubmit={e => { e.preventDefault(); setUser(userName) }}>
            <label htmlFor="login-username">Username:</label>
            <input type="text" name="login-username" id="login-username" value={userName} onChange={handleUserName} />
            <label htmlFor="login-password">Password:</label>
            <input type="password" name="login-password" id="login-password" />
            <input type="submit" value="Login" disabled={userName.length === 0} />
        </form>
    )
}