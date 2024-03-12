import React, { useState } from 'react'

export default function Register({ setUser }) {

    const [ userName, setUserName ] = useState('')
    const [ password, setPassword ] = useState('')
    const [ repeatPassword, setRepeatPassword ] = useState('')

    function handleUserName (event) {
        setUserName(event.target.value)
    }

    function handlePassword(event) {
        setPassword(event.target.value)
    }

    function handleRepeatPassword(event) {
        setRepeatPassword(event.target.value)
    }

    return (
        <form onSubmit={e => { e.preventDefault(); setUser(userName) }}>
            <label htmlFor="register-username">Username:</label>
            <input type="text" name="register-username" id="register-username"
                value={userName} onChange={handleUserName} />
            <label htmlFor="register-password">Password:</label>
            <input type="password" name="register-password" id="register-password"
                value={password} onChange={handlePassword} />
            <label htmlFor="register-password-repeat">Repeat password:</label>
            <input type="password" name="register-password-repeat" id="register-password-repeat"
                value={repeatPassword} onChange={handleRepeatPassword} />
            <input type="submit" value="Register"
                disabled={userName.length === 0 || password.length === 0 || password !== repeatPassword} />
        </form>
    )
}