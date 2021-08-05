import AddPolicyForm from "./AddPolicyForm/AddPolicyForm";
import axios from 'axios';
import CustomerData from "./CustomerData/CustomerData";
import {useEffect, useState} from "react";
import PolicyListTable from "./PolicyListTable/PolicyListTable";

const CustomerUI = () => {

    const [policies, setPolicies] = useState([])

    const getAllPolicies = () => {
        axios.get('http://localhost:8080/policy/all?customerId=24').then(
            res => {
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
        <div className={"mx-5"}>
            <CustomerData />
            <PolicyListTable/>
            <AddPolicyForm/>
        </div>
    );
}
export default CustomerUI;