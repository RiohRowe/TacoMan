import {Link} from "react-router-dom"

const NavBar = (props) => {
    return (
      <header style={{display:"flex", alignItems:"center", justifyContent:"space-between", backgroundColor:"#ccc"}}>
          <h2>Customer Insurance</h2>
          <nav>
              <Link to={"/"} style={{margin:"20px"}}>
                  user
              </Link>
              <Link to={"/admin"} style={{margin:"20px"}}>
                  admin
              </Link>
          </nav>
      </header>
    );
}
export default NavBar;