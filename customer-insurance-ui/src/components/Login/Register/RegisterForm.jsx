import {useState} from "react";

const RegisterForm = () => {

    const[name, setName] = useState("");
    const[age, setAge] = useState("");
    const[zipCode, setZipCode] = useState("");
    const[address, setAddress] = useState("");
    const[ssn, setSsn] = useState("");
    const[creditScore, setCreditScore] = useState("");

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
    }
    return (
        <>
            <form className="addTransactionsForm" onSubmit={handleRegisterCustomer}>
                <h3>REGISTER</h3>
                <br/>
                <label htmlFor="name">Name</label>
                <input type="text" id="name" value={name}
                       onChange={(e) => setName(e.target.value)} />
                <br/>
                <label htmlFor="age">Age</label>
                <input type="number" id="age" value={age}
                       onChange={(e) => setAge(e.target.value)} />
                <br/>
                <label htmlFor="zipCode">Zip Code</label>
                <input type="number" id="zipCode" value={zipCode}
                       onChange={(e) => setZipCode(e.target.value)} />
                <br/>
                <label htmlFor="address">Address</label>
                <input type="text" id="address" value={address}
                       onChange={(e) => setAddress(e.target.value)} />
                <br/>
                <label htmlFor="ssn">SSN</label>
                <input type="number" id="ssn" value={ssn}
                       onChange={(e) => setSsn(e.target.value)} />
                <br/>
                <label htmlFor="creditScore">Credit Score</label>
                <input type="number" id="creditScore" value={creditScore}
                       onChange={(e) => setCreditScore(e.target.value)} />
                <br/>
                <button type="submit">Submit</button>
                {/*<div className="addTransactionMessage">{message}</div>*/}
            </form>
        </>
    );
}
export default RegisterForm;