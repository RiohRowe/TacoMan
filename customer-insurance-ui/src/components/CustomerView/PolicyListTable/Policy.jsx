const Policy = ({policy}) => {

    return (
        <tr>
            <td>{policy.policyNumber}</td>
            <td>{policy.policyType}</td>
            <td>{policy.coverageType}</td>
            <td>{policy.deductibleType}</td>
            <td>{policy.processDate}</td>
            <td>{policy.effectiveDate}</td>
            <td>{policy.premium}</td>
        </tr>
    )
};
export default Policy;