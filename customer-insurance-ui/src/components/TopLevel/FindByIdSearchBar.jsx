import { Button } from 'react-bootstrap';

const FindByIdSearchBar = () => {
    return (
        <div>
            <label>Search for a customer</label>
            <input type={"text"}/>
            <Button type={"submit"}>search</Button>
        </div>
    );
};

export default FindByIdSearchBar;