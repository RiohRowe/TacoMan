import FindByIdSearchBar from "./FindByIdSearchBar";
import RegisterForm from "./Register/RegisterForm";

const LoginPage = (props) => {
    console.log("FindByIdSearchBarPROPS", props);
    return (
        <div className={"d-flex flex-column justify-content-center align-items-center"}>
            <FindByIdSearchBar/>
            <RegisterForm/>
        </div>
    );
}

export default LoginPage;