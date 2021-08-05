const CustomerData = (props) => {
    const {customer, policies} = props;
    return (
        <div>
            <div>
                <h2>Customer Data</h2>

                <p>name: {customer.name}</p>
                <p>address: {customer.address}</p>
                <p>zip code: {customer.zipCode}</p>
                <p>age: {customer.age}</p>
                <p>years as customer: {customer.yearsAsCustomer}</p>
                <p>credit score: {customer.creditScore}</p>
            </div>
            <div>
                <h2>Policy Data</h2>
                <p>number of policies: {policies.length}</p>
                <p>total monthly premium: {policies?.reduce((acc, policy) => acc + policy.premium, 0)}</p>
            </div>
        </div>
    );
};
export default CustomerData;