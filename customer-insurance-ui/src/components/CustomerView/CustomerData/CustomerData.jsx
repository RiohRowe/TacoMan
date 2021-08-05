import {customerSelector, getCustomer, getPolicies} from "../../../store/Selectors";
import {useSelector} from "react-redux";

const CustomerData = () => {
    const customer = useSelector(getCustomer);
    const policies = useSelector(getPolicies);
    return (
        <div className={"d-flex justify-content-around my-4"}>
            <div>
                <h3>Customer Data</h3>


                <p style={{marginBottom:"0px"}}>name: {customer.name}</p>
                <p style={{marginBottom:"0px"}}>address: {customer.address}</p>
                <p style={{marginBottom:"0px"}}>zip code: {customer.zipCode}</p>
                <p style={{marginBottom:"0px"}}>age: {customer.age}</p>
                <p style={{marginBottom:"0px"}}>years as customer: {customer.yearsAsCustomer}</p>
                <p style={{marginBottom:"0px"}}>credit score: {customer.creditScore}</p>

            </div>
            <div>
                <h3>Policy Data</h3>
                <p>number of policies: {policies.length}</p>
                <p>total monthly premium: {policies?.reduce((acc, policy) => acc + policy.premium, 0).toFixed(2)}</p>
            </div>
        </div>
    );
};
export default CustomerData;