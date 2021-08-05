import {ADD_CUSTOMER_POLICY, SET_CURRENT_CUSTOMER, SET_CUSTOMER_POLICIES} from "./ActionTypes";

export const setCurrentCustomer = (customer) => {
    return ({
        type:SET_CURRENT_CUSTOMER,
        payload:customer
    });
}

// export const logoff = () => {
//     return ({
//         type: LOGOFF
//     });
// }

export const setCurrentCustomerPolicies = (policies) => {
    return ({
        type: SET_CUSTOMER_POLICIES,
        payload: policies
    });
}

export const addCustomerPolicy = (policy) => {
    return ({
        type: ADD_CUSTOMER_POLICY,
        payload: policy
    });
}