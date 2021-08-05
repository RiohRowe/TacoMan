import {useState} from "react";

const AddPolicyForm = () => {

    const[policyType, setPolicyType] = useState("");
    const[coverageType, setCoverageType] = useState("");
    const[deductibleType, setDeductibleType] = useState("");

    const[policyTypes, setPolicyTypes] = useState(["home","auto","life"]);
    const[coverageTypes, setCoverageTypes] = useState(["economy","standard","premium"]);
    const[deductibleTypes, setDeductibleTypes] = useState(["low", "medium", "high"]);

    const handleAddPolicy = (event) => {
        event.preventDefault();
        const policy = {
           customerId: 24,
           policyType,
           coverageType,
           deductible: deductibleType
        }
    }

    const policyTypesOptions = policyTypes.map((thisPolicyType) => {
        return<option value={thisPolicyType}>{thisPolicyType}</option>
    })
    const coverageTypesOptions = coverageTypes.map((thisCoverageType) => {
        return<option value={thisCoverageType}>{thisCoverageType}</option>
    })
    const deductibleTypesOptions = deductibleTypes.map((thisDeductibleType) => {
        return<option value={thisDeductibleType}>{thisDeductibleType}</option>
    })

console.log(policyType);

    return (
        <>
            <form className="addTransactionsForm" onSubmit={handleAddPolicy}>
                <h3>REGISTER</h3>
                <br/>
                <select className="form-select" aria-label="Default select example"
                        onChange={(e) => setPolicyType(e.target.value)} value={policyType} >
                    <option selected disabled>Policy Type</option>
                    {policyTypesOptions}
                </select>
                <select className="form-select" aria-label="Default select example"
                        onChange={(e) => setCoverageType(e.target.value)} value={coverageType} >
                    <option selected disabled>Coverage Type</option>
                    {coverageTypesOptions}
                </select>
                <select className="form-select" aria-label="Default select example"
                    onChange={(e) => setDeductibleType(e.target.value)} value={deductibleType} >
                    <option selected disabled>Deductible Type</option>
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