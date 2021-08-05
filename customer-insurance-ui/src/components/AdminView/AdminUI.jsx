import CustomerList from "./CustomerListTable/CustomerList";
import FindByIdSearchBar from "../TopLevel/FindByIdSearchBar";

const AdminUI = (props) => {
    return(
        <div className={"my-5 mx-5 d-flex flex-column align-items-center justify-content-center"}>
            <FindByIdSearchBar/>
            <CustomerList/>
        </div>
    );
};
export default AdminUI