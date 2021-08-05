import logo from './logo.svg';
import './App.css';
import AdminUI from "./components/AdminView/AdminUI";
import NavBar from "./components/TopLevel/Navbar";
import LoginPage from "./components/Login/LoginPage";
import CustomerUI from "./components/CustomerView/CustomerUI";
import axios from 'axios';
import {useEffect, useState} from "react";
function App() {

    const nullCustomer = {
    name: "",
    address: "",
    zipCode: "",
    age: "",
    yearsAsCustomer: "",
    creditScore: ""
    }

    const [customer, setCustomer] = useState(nullCustomer);

    const getCustomerById = () => {
        axios.get('http://localhost:8080/customer/24').then(
            res => {
                if(res.status != 200)
                {
                    setCustomer(null)
                    console.log("RESPONCE STATUS = " +res.status)
                }
                else {
                    setCustomer(res.data);
                    console.log("RESULT IS")
                    console.log(res);
                }
            }
        );
    }

    useEffect(getCustomerById, []);

  return (
    <div className="App ">
        <NavBar/>
        {/*<AdminUI/>*/}
        {/*<LoginPage/>*/}
        <CustomerUI customer={customer}/>
    </div>
  );
}

export default App;
