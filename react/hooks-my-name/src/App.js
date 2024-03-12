import React, { useState }from 'react'

function MyName() {

  const [ title, setTitle ] = useState('')
  const [ name, setName ] = useState('')
  const [ includeTitle, setIncludeTitle ] = useState(false)

  function handleNameChange(event) {
    setName(event.target.value)
  }

  function handleTitleChange(event) {
    setTitle(event.target.value)
  }

  function handleIncludeTitleChange(event) {
    setIncludeTitle(event.target.checked)
  }

  return (
      <div>
        <h1>My name is {includeTitle ? title + " " : ""}{name}</h1>
        <input type="text" value={title} onChange={handleTitleChange} />
        <input type="checkbox" onClick={handleIncludeTitleChange} />
        <input type="text" value={name} onChange={handleNameChange} />
      </div>
  )
}

export default MyName
