import axios from 'axios';
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';
import { Button, Checkbox, Form } from 'semantic-ui-react'

export default function Create() {

    const [productCode, setProductCode] = useState('');
    const [name, setName] = useState('');
    const [description, setDescription] = useState('');

    const postData = () => {
        axios.post(`/api/product`, {
            productCode,
            name,
            description
        }).then(() => { navigate('/') })
    }

    let navigate = useNavigate();

    return (
        <div>
            <Form className="create-form">
                <Form.Field>
                    <label>Product Code</label>
                    <input placeholder='Product Code' onChange={(e) => setProductCode(e.target.value)}/>
                </Form.Field>
                <Form.Field>
                    <label>Product Name</label>
                    <input placeholder='Product Name' onChange={(e) => setName(e.target.value)}/>
                </Form.Field>
                <Form.Field>
                    <label>Description</label>
                    <input placeholder='Description' onChange={(e) => setDescription(e.target.value)}/>
                </Form.Field>
                <Button onClick={postData} type='submit'>Submit</Button>
            </Form>
        </div>
    )
}

