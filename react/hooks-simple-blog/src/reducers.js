function postReducer(state, action) {
    switch (action.type) {
        case "CREATE_POST":
            const post = { title: action.title, content: action.content, author: action.author }
            return [ post, ...state ]
        case "FETCH_POSTS":
            return action.posts
        default:
            return state
    }
}

function userReducer(state, action) {
    switch (action.type) {
        case "LOGIN":
        case "REGISTER":
            return action.username
        case "LOGOUT":
            return ""
        default:
            return state
    }
}

function errorReducer(state, action) {
    switch (action.type) {
        case "POSTS_ERROR":
            return "Failed to fetch posts."
        default:
            return state
    }
}

export default function appReducer (state, action) {
    return {
        user: userReducer(state.user, action),
        posts: postReducer(state.posts, action),
        error: errorReducer(state.error, action)
    }
}