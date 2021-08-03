import CustomerList from "./CustomerList";
import SearchBar from "./SearchBar";

const AdminUI = (props) => {
    return(
        <div className={"my-5 mx-5 d-flex flex-column align-items-center justify-content-center"}>
            <SearchBar/>
            <CustomerList/>
        </div>
    );
};
export default AdminUI