import React, {useEffect, useState} from 'react'
import { deleteEmployee, listEmployees } from '../services/EmployeeService'
import { useNavigate } from 'react-router-dom'

const ListEmployeeComponent = () => {

  const[employees, setEmployees] = useState([])
  const navigator = useNavigate();

  useEffect(()=>{
       getAllEmployees();
  },[])

function getAllEmployees(){
    listEmployees().then((response) => {
        setEmployees(response.data);
    }).catch(error => {
        console.error(error);
    })
}

function addEmployee(){
    navigator('/add-employee');
}

function updateEmployee(id){
    navigator(`/edit-employee/${id}`)
}

function removeEmployee(id){
    console.log(id)
    deleteEmployee(id).then((response)=>{
        getAllEmployees();
    }).catch(error => {

    })
}
  return (
    <div className='container'>
        <h2 className='text-center'>Employees List</h2>
        <button className='btn btn-primary mb-2' onClick={addEmployee}>Add Employee</button>
        <table className='table table-striped table-bordered'>
            <thead>
                <tr>
                    <th>Emp Id</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Mobile</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                {
                    employees.map(employee =>
                        <tr key={employee.id}>
                            <td>{employee.id}</td>
                            <td>{employee.firstName}</td>
                            <td>{employee.lastName}</td>
                            <td>{employee.email}</td>
                            <td>{employee.mobileNumber}</td>
                            <td>
                                <button className='btn btn-info' onClick={()=>updateEmployee(employee.id)}>Edit</button>
                                <button className='btn btn-danger' style={{marginLeft:'10px'}} onClick={()=> removeEmployee(employee.id)}>Delete</button>
                            </td>
                        </tr>
                    )
                }
            </tbody>
        </table>
        
    </div>
  )
}

export default ListEmployeeComponent