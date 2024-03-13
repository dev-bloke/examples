import React, { useState, useContext } from 'react'
import { StateContext } from "../contexts";

export default function Register() {

    const [ username, setUsername ] = useState('')
    const [ password, setPassword ] = useState('')
    const [ repeatPassword, setRepeatPassword ] = useState('')
    const { dispatch } = useContext(StateContext)

    function handleUsername (event) {
        setUsername(event.target.value)
    }

    function handlePassword(event) {
        setPassword(event.target.value)
    }

    function handleRepeatPassword(event) {
        setRepeatPassword(event.target.value)
    }

    return (
        <form onSubmit={e => { e.preventDefault(); dispatch({type: "REGISTER", username}) }}>
            <label htmlFor="register-username">username:</label>
            <input type="text" name="register-username" id="register-username"
                value={username} onChange={handleUsername} />
            <label htmlFor="register-password">Password:</label>
            <input type="password" name="register-password" id="register-password"
                value={password} onChange={handlePassword} />
            <label htmlFor="register-password-repeat">Repeat password:</label>
            <input type="password" name="register-password-repeat" id="register-password-repeat"
                value={repeatPassword} onChange={handleRepeatPassword} />
            <input type="submit" value="Register"
                disabled={username.length === 0 || password.length === 0 || password !== repeatPassword} />
        </form>
    )
}