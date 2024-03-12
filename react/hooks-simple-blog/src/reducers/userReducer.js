export function userReducer(state, action) {
    console.log(action)
    switch (action.type) {
        case "LOGIN":
        case "REGISTER":
            return action.username
        case "LOGOUT":
            return ""
        default:
            throw new Error()
    }
}