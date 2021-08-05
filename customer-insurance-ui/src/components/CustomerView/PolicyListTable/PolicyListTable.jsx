import {useEffect, useState} from "react";
import {Dropdown} from "react-bootstrap";
import axios from 'axios';
import Policy from "./Policy";

const PolicyListTable = ({policies}) => {


    const policyComponents = policies.map((policy) => {
        return (<Policy policy={policy} key={policy.id}/>);
    });

    return (
        <>

            <table  className={"my-3 table"}>
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