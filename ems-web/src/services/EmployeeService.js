import axios from "axios";

const REST_API_BASE_URL = 'http://localhost:8080/api/employees';
const GET_ALL_EMPLOYEE = "/all"
const CREATE_EMPLOYEE = "/create"

export const listEmployees = () => axios.get(REST_API_BASE_URL + GET_ALL_EMPLOYEE);
export const createEmployee = (employee) => axios.post(REST_API_BASE_URL + CREATE_EMPLOYEE, employee);
export const getEmployee = (employeeId) => axios.get(REST_API_BASE_URL+'/'+employeeId);
export const updateEmployee =(employeeId, employee) => axios.put(REST_API_BASE_URL+'/'+employeeId, employee);
export const deleteEmployee = (employeeId) => axios.delete(REST_API_BASE_URL+'/'+employeeId);