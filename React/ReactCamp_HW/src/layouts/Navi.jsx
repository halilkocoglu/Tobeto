import { useState } from "react";
import CartSummary from "./CartSummary";
import { Container, Menu, MenuItem, MenuMenu } from "semantic-ui-react";
import SignedIn from "./SignedIn";
import SignedOut from "./SignedOut";
import { NavLink, useNavigate } from "react-router-dom";
import { useSelector } from "react-redux";

function Navi() {
  const [isLoggedIn, setIsLoggedIn] = useState(true);
  const navigate = useNavigate();
  const { cartItems } = useSelector((state) => state.cart);

  const handleLogOut = () => {
    setIsLoggedIn(false);
    navigate("/");
  };
  const handleLogIn = () => {
    setIsLoggedIn(true);
  };
  return (
    <div>
      <Menu inverted fixed="top">
        <Container>
          <MenuItem as={NavLink} to={"/"} name="home" />
          <MenuItem as={NavLink} to={"/product/add"} name="Add Product" />
          <MenuMenu position="right">
            {cartItems.length > 0 && <CartSummary />}
            {isLoggedIn ? (
              <SignedIn handleLogOut={handleLogOut} />
            ) : (
              <SignedOut handleLogIn={handleLogIn} />
            )}
          </MenuMenu>
        </Container>
      </Menu>
    </div>
  );
}

export default Navi;
