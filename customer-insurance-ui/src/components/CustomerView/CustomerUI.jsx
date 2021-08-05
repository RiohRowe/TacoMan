import AddPolicyForm from "./AddPolicyForm/AddPolicyForm";
import axios from 'axios';
import CustomerData from "./CustomerData/CustomerData";
import {useEffect, useState} from "react";
import PolicyListTable from "./PolicyListTable/PolicyListTable";

const CustomerUI = ({customer}) => {

    const [policies, setPolicies] = useState([])

    const getAllPolicies = () => {
        axios.get('http://localhost:8080/policy/all?customerId=24').then(
            res => {
                console.log("res = " +res);
                console.log(res);
                if(res.status != 200)
                {
                    setPolicies([])
                }
                else {
                    setPolicies(res.data);
                }
            }
        );
    }



    useEffect(getAllPolicies, [])

    return(
        <>
            <CustomerData customer={customer} policies={policies}/>
            <AddPolicyForm/>
            <PolicyListTable policies={policies}/>
        </>
    );
}
export default CustomerUI;