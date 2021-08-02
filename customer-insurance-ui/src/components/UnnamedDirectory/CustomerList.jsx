import Customer from "./Customer";

const CustomerList = (props) => {
  const customer1 = {
    "name": "Sean",
    "address": "1a",
    "zipcode": "1",
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
  const customers = [customer1,customer2,customer3,customer4].map((cust) => {
   return (<Customer customer={cust} key={cust.name}/>);
  });

  console.log(customers);
  return (<table>
    <tr>
      <th>name</th>
      <th>address</th>
      <th>zipcode</th>
      <th>age</th>
      <th>yearsAsCustomer</th>
      <th>creditScore</th>
    </tr>
    {customers}
  </table>);
};
export default CustomerList;