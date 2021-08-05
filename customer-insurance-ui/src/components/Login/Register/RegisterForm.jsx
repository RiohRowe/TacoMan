import {useState} from "react";
import axios from 'axios';
import {useDispatch} from "react-redux";
import {setCurrentCustomer} from "../../../store/Actions";

const RegisterForm = () => {

    const[name, setName] = useState("");
    const[age, setAge] = useState("");
    const[zipCode, setZipCode] = useState("");
    const[address, setAddress] = useState("");
    const[ssn, setSsn] = useState("");
    const[creditScore, setCreditScore] = useState("");

    const[customerId, setCustomerId] = useState("");

    const dispatch = useDispatch();


    const handleRegisterCustomer = (event) => {
        event.preventDefault();
        const customer = {
            name,
            age,
            zipCode,
            address,
            ssn,
            creditScore,
            yearsAsCustomer:0
        }
        axios.put("http://localhost:8080/customer", customer).then(
            res => {
                if(res.status == 200) {
                    setCustomerId(res.data.id);
                }
            }
        )
    }
    return (
        <>
            <form className="addTransactionsForm" onSubmit={handleRegisterCustomer}>
                <div className={"d-flex justify-content-center"}>
                    <h3>REGISTER</h3>
                </div>
                <br/>
                <div className={"d-flex flex-column align-items-between"}>
                    <label htmlFor="name">Name</label>
                    <input type="text" id="name" value={name}
                           onChange={(e) => setName(e.target.value)} />
                    <label htmlFor="age">Age</label>
                    <input type="number" id="age" value={age}
                           onChange={(e) => setAge(e.target.value)} />
                    <label htmlFor="zipCode">Zip Code</label>
                    <input type="number" id="zipCode" value={zipCode}
                           onChange={(e) => setZipCode(e.target.value)} />
                    <label htmlFor="address">Address</label>
                    <input type="text" id="address" value={address}
                           onChange={(e) => setAddress(e.target.value)} />
                    <label htmlFor="ssn">SSN</label>
                    <input type="number" id="ssn" value={ssn}
                           onChange={(e) => setSsn(e.target.value)} />
                    <label htmlFor="creditScore">Credit Score</label>
                    <input type="number" id="creditScore" value={creditScore}
                           onChange={(e) => setCreditScore(e.target.value)} />
                </div>
                <br/>
                <div className={"d-flex justify-content-center"}>
                    <button type="submit">Submit</button>
                </div>
            </form>
            {customerId && <p>Your customer Id is: {customerId}</p>}
        </>
    );
}
export default RegisterForm;