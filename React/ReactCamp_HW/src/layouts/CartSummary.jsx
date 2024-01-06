import { useSelector } from "react-redux";
import { Link } from "react-router-dom";
import {
  Dropdown,
  DropdownDivider,
  DropdownItem,
  DropdownMenu,
  Label,
} from "semantic-ui-react";

function CartSummary() {
  const { cartItems } = useSelector((state) => state.cart);
  console.log(cartItems);
  return (
    <div>
      <Dropdown item text="Your Cart">
        <DropdownMenu>
          {cartItems.map((cartItem, i) => {
            return (
              <DropdownItem key={i}>
                {cartItem.product.title}
                <Label style={{ marginLeft: "4px" }}>{cartItem.quantity}</Label>
              </DropdownItem>
            );
          })}

          <DropdownDivider />
          <DropdownItem as={Link} to={"/cart"}>
            See Cart...
          </DropdownItem>
        </DropdownMenu>
      </Dropdown>
    </div>
  );
}

export default CartSummary;
