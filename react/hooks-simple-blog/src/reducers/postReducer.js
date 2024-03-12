export function postReducer(state, action) {
    console.log(action)
    switch (action.type) {
        case "CREATE_POST":
            const post = { title: action.title, content: action.content, author: action.author }
            return [ post, ...state ]
        default:
            throw new Error()
    }
}