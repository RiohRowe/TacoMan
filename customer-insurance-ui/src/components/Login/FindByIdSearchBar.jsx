import { Button } from 'react-bootstrap';
import {useState} from "react";
import axios from "axios";
import {useDispatch} from "react-redux";
import {setCurrentCustomer, setCurrentCustomerPolicies} from "../../store/Actions";
import {useHistory} from "react-router-dom"

const FindByIdSearchBar = () => {
    const dispatch = useDispatch()
    const history = useHistory();
    const getCustomerPolicies = (customerId) => {
        axios("http://localhost:8080/policy/all?customerId="+customerId).then(
            res => {
                if(res.status == 200) {
                    dispatch(setCurrentCustomerPolicies(res.data));
                    history.push("/user");
                }
            }
        );
    }
    const login = () => {
        axios("http://localhost:8080/customer/"+customerId).then(
            res => {
                if(res.status == 200) {
                    dispatch(setCurrentCustomer(res.data));
                    axios("http://localhost:8080/customer/"+customerId).then(
                        res => {
                            if(res.status == 200) {
                                dispatch(setCurrentCustomer(res.data));
                                getCustomerPolicies(res.data.id);
                            }
                        }
                    );
                    history.push("/user");
                }
            }
        );
    }

    const [customerId, setCustomerId] = useState("");

    console.log(customerId);

    return (
        <div className={"my-5"}>
            <input id={"customerIDSearch"} value={customerId} onChange={ event => setCustomerId(event.target.value)}
                   type={"text"} placeholder={"Search by user Id"} style={{marginRight:"10px"}}/>

            <Button type={"submit"} onClick={login}>search</Button>
        </div>
    );
};

export default FindByIdSearchBar;