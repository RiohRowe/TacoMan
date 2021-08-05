const NavBar = (props) => {
    return (
      <header style={{display:"flex", alignItems:"center", justifyContent:"space-between", backgroundColor:"#ccc"}}>
          <h2>Customer Insurance</h2>
          <nav>
              <a style={{margin:"20px"}}>user</a>
              <a style={{margin:"20px"}}>admin</a>
          </nav>
      </header>
    );
}
export default NavBar;