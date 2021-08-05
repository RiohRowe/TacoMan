import Customer from "./Customer";
import {useEffect, useState} from "react";
import {Dropdown} from "react-bootstrap";
import axios from 'axios';

const CustomerList = (props) => {

  const [customers, setCustomers] = useState([])
  const zipCodes = customers.map(customer => customer.zipCode)
      .filter((v, i, a) => a.indexOf(v) === i).map((zipCode) => {
    return<option value={zipCode}>{zipCode}</option>;
  })
  ;
  const [selectedZipCode, setSelectedZipCode] = useState("all")

  const getAllCustomers = () => {
    axios.get('http://localhost:8080/customer/all').then(
        res => {
          if(res.data == null)
          {
            setCustomers([])
          }
          else {
            setCustomers(res.data);
          }
        }
    );
  }

  useEffect(getAllCustomers, [])

  const customerComponents = customers.filter((cust) => {
    return selectedZipCode==="all" || cust.zipCode===selectedZipCode
  }).map((cust) => {
   return (<Customer customer={cust} key={cust.name}/>);
  });

  return (
  <>
    <select className={"form-select"} aria-label={"Default select example"} style={{width:"20%"}}
            onChange={(e) => setSelectedZipCode(e.target.value)} value={selectedZipCode} >
      <option value={"all"}>All</option>
      {zipCodes}
    </select>

    <table  className={"my-3 table"}>
      <thead className={"thead-dark"}>
        <tr>
          <th>name</th>
          <th>address</th>
          <th>zip-code</th>
          <th>age</th>
          <th>yearsAsCustomer</th>
          <th>creditScore</th>
        </tr>
      </thead>
      <tbody>
        {customerComponents}
      </tbody>
    </table>
  </>
  );
};
export default CustomerList;