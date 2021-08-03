import Customer from "./Customer";
import {useState} from "react";
import {Dropdown} from "react-bootstrap";

const CustomerList = (props) => {
  const customer1 = {
    "name": "Sean",
    "address": "1a",
    "zipcode": "98765",
    "age": "100",
    "yearsAsCustomer": "70",
    "creditScore": "800"
  }
  const customer2 = {
    "name": "Ahmad",
    "address": "123 CoolVile st",
    "zipcode": "98765",
    "age": "18",
    "yearsAsCustomer": "1",
    "creditScore": "100"
  }
  const customer3 = {
    "name": "Daniel",
    "address": "12 Coolvile pl",
    "zipcode": "19283",
    "age": "40",
    "yearsAsCustomer": "10",
    "creditScore": "700"
  }
  const customer4 = {
    "name": "Rioh",
    "address": "142 CoolVille ln",
    "zipcode": "85281",
    "age": "63",
    "yearsAsCustomer": "40",
    "creditScore": "900"
  }
  const [customers, setCustomers] = useState([customer1, customer2, customer3, customer4])
  const zipcodes = customers.map(customer => customer.zipcode)
      .filter((v, i, a) => a.indexOf(v) === i).map((zipcode) => {
    return <Dropdown.Item eventKey={zipcode}>{zipcode}</Dropdown.Item>;
  })
  ;
  const [selectedZipcode, setSelectedZipcode] = useState("all")
  const customerComponents = customers.filter((cust) => {
    return selectedZipcode==="all" || cust.zipcode===selectedZipcode
  }).map((cust) => {
   return (<Customer customer={cust} key={cust.name}/>);
  });

  console.log(selectedZipcode);

  return (
  <>
    <Dropdown   className={"mt-5"} onSelect={setSelectedZipcode}>
      <Dropdown.Toggle variant="success" id="dropdown-basic">
        ViewByZipcode
      </Dropdown.Toggle>

      <Dropdown.Menu>
        <Dropdown.Item eventKey={"all"}>All</Dropdown.Item>
        {zipcodes}
      </Dropdown.Menu>
    </Dropdown>
    <table  className={"my-3 table"}>
      <thead className={"thead-dark"}>
        <tr>
          <th>name</th>
          <th>address</th>
          <th>zipcode</th>
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