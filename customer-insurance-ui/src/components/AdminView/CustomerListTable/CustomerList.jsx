import Customer from "./Customer";
import {useEffect, useState} from "react";
import {Dropdown} from "react-bootstrap";
import axios from 'axios';

const CustomerList = (props) => {

  const [customers, setCustomers] = useState([])
  const zipCodes = customers.map(customer => customer.zipCode)
      .filter((v, i, a) => a.indexOf(v) === i).map((zipCode) => {
    return <Dropdown.Item eventKey={zipCode}>{zipCode}</Dropdown.Item>;
  })
  ;
  const [selectedZipCode, setSelectedZipCode] = useState("all")

  const getAllCustomers = () => {
    axios.get('http://localhost:8080/customer/all').then(
        res => {
          console.log("res = " +res);
          console.log(res);
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

  console.log(selectedZipCode);

  return (
  <>

    <table  className={"my-3 table"}>
      <thead className={"thead-dark"}>
        <tr>
          <th>name</th>
          <th>address</th>
          <th>
            <span>
              zip-code
              <Dropdown onSelect={setSelectedZipCode}>
                <Dropdown.Toggle variant="success" id="dropdown-basic">
                  {selectedZipCode}
                </Dropdown.Toggle>
                <Dropdown.Menu>
                  <Dropdown.Item eventKey={"all"}>All</Dropdown.Item>
                  {zipCodes}
                </Dropdown.Menu>
              </Dropdown>
            </span>
          </th>
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