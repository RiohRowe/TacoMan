import {useEffect, useState} from "react";
import {Dropdown} from "react-bootstrap";
import axios from 'axios';
import Policy from "./Policy";
import {useSelector} from "react-redux";
import {getPolicies} from "../../../store/Selectors";

const PolicyListTable = () => {

    const policies = useSelector(getPolicies);
    const policyComponents = policies.map((policy) => {
        return (<Policy policy={policy} key={policy.id}/>);
    });

    return (
        <>
            <div className={"d-flex justify-content-center"}>
                <h3>User Policies</h3>
            </div>
            <table  className={"my-3 table"} name={"User Policies"}>
                <thead className={"thead-dark"}>
                <tr>
                    <th>Policy Number</th>
                    <th>Policy Type</th>
                    <th>Coverage Type</th>
                    <th>Deductible Type</th>
                    <th>Process Date</th>
                    <th>Effective Date</th>
                    <th>Premium</th>
                </tr>
                </thead>
                <tbody>
                {policyComponents}
                </tbody>
            </table>
        </>
    );
};
export default PolicyListTable;