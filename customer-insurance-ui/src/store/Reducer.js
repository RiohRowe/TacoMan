import {
    ADD_CUSTOMER_POLICY,
    GET_POLICIES,
    LOGIN,
    LOGOFF,
    SET_CURRENT_CUSTOMER,
    SET_CUSTOMER_POLICIES
} from "./ActionTypes";

const nullCustomer = {
    id: null,
    name: "",
    address: "",
    zipCode: "",
    age: "",
    yearsAsCustomer: "",
    creditScore: ""
}

const initialState = {
    customer: nullCustomer,
    policies: [],
}

const mainReducer = (state = initialState, action) => {
    switch(action.type) {
        case SET_CURRENT_CUSTOMER: {
                return {...state, customer: action.payload};
            }
        case LOGOFF: {
                return {...state, customer: nullCustomer};
            }
        case SET_CUSTOMER_POLICIES: {
                return {...state, policies: action.payload};
            }
        case ADD_CUSTOMER_POLICY: {
            return {...state, policies: [...state.policies, action.payload]};
        }
        default: {
            return state;
        }
    }
}
export default mainReducer;