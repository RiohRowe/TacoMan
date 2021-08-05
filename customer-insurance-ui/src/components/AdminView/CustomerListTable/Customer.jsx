const Customer = ({customer}) => {

    return (
        <tr>
            <td>{customer.name}</td>
            <td>{customer.address}</td>
            <td>{customer.zipCode}</td>
            <td>{customer.age}</td>
            <td>{customer.yearsAsCustomer}</td>
            <td>{customer.creditScore}</td>
        </tr>
    )
};

export default Customer;