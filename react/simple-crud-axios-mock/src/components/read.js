import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom';
import { Button, Table } from 'semantic-ui-react'
export default function Read() {

    const [APIData, setAPIData] = useState([]);
    useEffect(() => {
        axios.get(`https://65e8766a4bb72f0a9c4f6aab.mockapi.io/api/product`)
            .then((response) => {
                setAPIData(response.data);
            })
    }, [])

    const getData = () => {
        axios.get(`https://65e8766a4bb72f0a9c4f6aab.mockapi.io/api/product`)
            .then((getData) => {
                setAPIData(getData.data);
            })
    }

    const setData = (data) => {
        let { id, productCode, name, description } = data;
        localStorage.setItem('ID', id);
        localStorage.setItem('Product Code', productCode);
        localStorage.setItem('Product Name', name);
        localStorage.setItem('Product Description', description);
    }

    const onDelete = (id) => {
        axios.delete(`https://65e8766a4bb72f0a9c4f6aab.mockapi.io/api/product/${id}`)
            .then(() => { getData(); })
    }

    return (
        <div>
            <Table singleLine>
                <Table.Header>
                    <Table.Row>
                        <Table.HeaderCell>Product Code</Table.HeaderCell>
                        <Table.HeaderCell>Name</Table.HeaderCell>
                        <Table.HeaderCell>Description</Table.HeaderCell>
                    </Table.Row>
                </Table.Header>

                <Table.Body>
                    {APIData.map((data) => {
                        return (
                            <Table.Row>
                                <Table.Cell>{data.productCode}</Table.Cell>
                                <Table.Cell>{data.name}</Table.Cell>
                                <Table.Cell>{data.description}</Table.Cell>
                                <Link to='/update'>
                                    <Table.Cell>
                                        <Button onClick={() => setData(data)}>Update</Button>
                                    </Table.Cell>
                                </Link>
                                <Table.Cell>
                                    <Button onClick={() => onDelete(data.id)}>Delete</Button>
                                </Table.Cell>
                            </Table.Row>
                        )})}
                </Table.Body>
            </Table>
            <a href={"/create"} className="centred"><Button>Create</Button></a>
        </div>
    )
}