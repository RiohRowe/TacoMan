import {useEffect, useState} from "react";
import axios from "axios";

const AddPolicyForm = () => {

    const[policyType, setPolicyType] = useState("");
    const[coverageType, setCoverageType] = useState("");
    const[deductibleType, setDeductibleType] = useState("");

    const[policyTypes, setPolicyTypes] = useState(["home"]);
    const[coverageTypes, setCoverageTypes] = useState(["standard"]);
    const[deductibleTypes, setDeductibleTypes] = useState(["medium"]);

    const handleAddPolicy = (event) => {
        event.preventDefault();
        const policy = {
           customerId: 24,
           policyType,
           coverageType,
           deductible: deductibleType
        }
    }

    const getPolicyTypes = () => {
        axios.get('http://localhost:8080/policy/types/all').then(
            res => {
                if(res.status != 200)
                {
                    console.log("Failed to get Policy types.")
                }
                else {
                    console.log("types = ");
                    console.log(res.data);
                    setPolicyTypes(res.data.policyTypes);
                    setCoverageTypes(res.data.coverageTypes);
                    setDeductibleTypes(res.data.deductibleTypes);
                }
            }
        );
    }

    useEffect(getPolicyTypes, []);



    const policyTypesOptions = policyTypes.map((thisPolicyType) => {
        return<option value={thisPolicyType}>{thisPolicyType}</option>
    })
    const coverageTypesOptions = coverageTypes.map((thisCoverageType) => {
        return<option value={thisCoverageType}>{thisCoverageType}</option>
    })
    const deductibleTypesOptions = deductibleTypes.map((thisDeductibleType) => {
        return<option value={thisDeductibleType}>{thisDeductibleType}</option>
    })

    const policyTypeOption = policyType == ""?
        <option selected>Policy Type</option>: <option selected disabled>Policy Type</option>;
    const coverageTypeOption = coverageType == ""?
        <option selected>Coverage Type</option>: <option selected disabled>Policy Type</option>
    const deductibleTypeOption = deductibleType == ""?
        <option selected>Decuctible Type</option>: <option selected disabled>Policy Type</option>
    return (
        <>
            <form className="addTransactionsForm" onSubmit={handleAddPolicy}>
                <h3>REGISTER</h3>
                <br/>
                <select className="form-select" aria-label="Default select example"
                        onChange={(e) => setPolicyType(e.target.value)} value={policyType} >
                    {policyTypeOption}
                    {policyTypesOptions}
                </select>
                <select className="form-select" aria-label="Default select example"
                        onChange={(e) => setCoverageType(e.target.value)} value={coverageType} >
                    {coverageTypeOption}
                    {coverageTypesOptions}
                </select>
                <select className="form-select" aria-label="Default select example"
                    onChange={(e) => setDeductibleType(e.target.value)} value={deductibleType} >
                    {deductibleTypeOption}
                    {deductibleTypesOptions}
                </select>

                <br/>
                <button type="submit">Submit</button>
                {/*<div className="addTransactionMessage">{message}</div>*/}
            </form>
        </>
    );
}
export default AddPolicyForm;