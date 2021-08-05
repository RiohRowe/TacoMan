import {useEffect, useState} from "react";
import axios from "axios";
import {getCustomer} from "../../../store/Selectors";
import {useDispatch, useSelector} from "react-redux";
import {ADD_CUSTOMER_POLICY} from "../../../store/ActionTypes";
import {addCustomerPolicy} from "../../../store/Actions";

const AddPolicyForm = () => {

    const customer = useSelector(getCustomer);

    const[policyType, setPolicyType] = useState("");
    const[coverageType, setCoverageType] = useState("");
    const[deductibleType, setDeductibleType] = useState("");

    const[policyTypes, setPolicyTypes] = useState(["home"]);
    const[coverageTypes, setCoverageTypes] = useState(["standard"]);
    const[deductibleTypes, setDeductibleTypes] = useState(["medium"]);

    const [quote, setQuote] = useState("");

    const dispatch = useDispatch();

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

    const buildPolicyRequest = () => {
        return ({
            customerId: customer.id,
            policyType: policyType,
            coverageType: coverageType,
            deductible: deductibleType
        });
    }

    const getQuote = () => {
        axios.post("http://localhost:8080/policy/quote", buildPolicyRequest()).then(
            res => {
              if(res.status == 200){
                  setQuote(res.data.premium);
              }
            }
        );
    }
    const submitPolicy = () => {
        axios.post("http://localhost:8080/policy", buildPolicyRequest()).then(
            res => {
                if(res.status == 200){
                    dispatch(addCustomerPolicy(res.data))
                    setQuote("")

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
            <div className={"d-flex flex-column align-items-center justify-content-center mt-5"}>
                <h3>Add Policy</h3>
                <div style={{width:"20%"}}>
                    <select className="mb-2 form-select" aria-label="Default select example"
                            onChange={(e) => setPolicyType(e.target.value)} value={policyType} >
                        {policyTypeOption}
                        {policyTypesOptions}
                    </select>
                    <select className="mb-2 form-select" aria-label="Default select example"
                            onChange={(e) => setCoverageType(e.target.value)} value={coverageType} >
                        {coverageTypeOption}
                        {coverageTypesOptions}
                    </select>
                    <select className="mb-2 form-select" aria-label="Default select example"
                        onChange={(e) => setDeductibleType(e.target.value)} value={deductibleType} >
                        {deductibleTypeOption}
                        {deductibleTypesOptions}
                    </select>
                </div>
                <button className={"button"} onClick={getQuote}>Get Quote</button>

                <p style={{color:"#ff0000"}}>{quote}</p>

                <br/>
                <button className={"mb-5"} disabled={!quote} onClick={submitPolicy}>Submit</button>
                {/*<div className="addTransactionMessage">{message}</div>*/}
            </div>
        </>
    );
}
export default AddPolicyForm;