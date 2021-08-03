import { Button } from 'react-bootstrap';

const SearchBar = () => {
    return (
        <div>
            <label>Search for a customer</label>
            <input type={"text"}/>
            <Button type={"submit"}>search</Button>
        </div>
    );
};

export default SearchBar;