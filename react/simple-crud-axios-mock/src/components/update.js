import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { Button, Form } from 'semantic-ui-react'
import axios from 'axios';

export default function Update() {

    const [productCode, setProductCode] = useState('');
    const [name, setName] = useState('');
    const [description, setDescription] = useState('');

    const [id, setID] = useState(null);

    const updateAPIData = () => {
        axios.put(`/api/product/${id}`, {
            productCode,
            name,
            description
        }).then(() => { navigate('/') })
    }

    let navigate = useNavigate();

    useEffect(() => {
        setID(localStorage.getItem('ID'))
        setProductCode(localStorage.getItem('Product Code'));
        setName(localStorage.getItem('Product Name'));
        setDescription(localStorage.getItem('Product Description'))
    }, []);

    return (
        <div>
            <Form className="create-form">
                <Form.Field>
                    <label>Product Code</label>
                    <input placeholder='Product Code' value={productCode} onChange={(e) => setProductCode(e.target.value)}/>
                </Form.Field>
                <Form.Field>
                    <label>Name</label>
                    <input placeholder='Name' value={name} onChange={(e) => setName(e.target.value)}/>
                </Form.Field>
                <Form.Field>
                    <label>Description</label>
                    <input placeholder='Name' value={description} onChange={(e) => setDescription(e.target.value)}/>
                </Form.Field>
                <Button type='submit' onClick={updateAPIData}>Update</Button>
            </Form>
        </div>
    )
}