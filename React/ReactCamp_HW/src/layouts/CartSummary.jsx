import { Link } from "react-router-dom";
import {
  Dropdown,
  DropdownDivider,
  DropdownItem,
  DropdownMenu,
} from "semantic-ui-react";

function CartSummary() {
  return (
    <div>
      <Dropdown item text="Your Cart">
        <DropdownMenu>
          <DropdownItem>English</DropdownItem>
          <DropdownItem>Russian</DropdownItem>
          <DropdownItem>Spanish</DropdownItem>
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
