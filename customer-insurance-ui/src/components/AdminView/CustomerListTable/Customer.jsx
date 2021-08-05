import {useHistory} from 'react-router-dom'
import {useDispatch} from "react-redux";
import {setCurrentCustomer, setCurrentCustomerPolicies} from "../../../store/Actions";
import axios from "axios";

const Customer = ({customer}) => {

    const history = useHistory();
    const dispatch = useDispatch();

    const goToCustomerData = () => {
        dispatch(setCurrentCustomer(customer));
        axios("http://localhost:8080/policy/all?customerId="+customer.id).then(
            res => {
                if(res.status == 200) {
                    dispatch(setCurrentCustomerPolicies(res.data));
                    history.push("/user");
                }
            }
        );
    }

    return (
        <tr>
            <td>{customer.name}</td>
            <td>{customer.address}</td>
            <td>{customer.zipCode}</td>
            <td>{customer.age}</td>
            <td>{customer.yearsAsCustomer}</td>
            <td>{customer.creditScore}</td>
            <td>
                <button className={"button"} onClick={goToCustomerData}>view</button>
            </td>
        </tr>
    )
};

export default Customer;