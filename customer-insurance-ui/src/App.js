import logo from './logo.svg';
import './App.css';
import AdminUI from "./components/AdminView/AdminUI";
import NavBar from "./components/Common/Navbar";
import LoginPage from "./components/Login/LoginPage";
import CustomerUI from "./components/CustomerView/CustomerUI";
import axios from 'axios';
import {useEffect, useState} from "react";
import {BrowserRouter, Route, Switch} from "react-router-dom";
import NotFound from "./components/404/404";

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
                    setCustomer(nullCustomer);
                }
                else {
                    setCustomer(res.data);
                }
            }
        );
    }

    useEffect(getCustomerById, []);

  return (
    <div className="App ">
        <BrowserRouter>
            <NavBar/>
            <Switch>
                <Route path={"/admin"} exact={true}>
                    <AdminUI/>
                </Route>
                <Route path={"/"} exact={true}>
                    <LoginPage/>
                </Route>
                <Route path={"/user"} exact={true}>
                    <CustomerUI/>
                </Route>
                <Route>
                    <NotFound/>
                </Route>
            </Switch>
        </BrowserRouter>
    </div>
  );
}

export default App;
