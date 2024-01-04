import React from "react";
import {
  Dropdown,
  DropdownItem,
  DropdownMenu,
  Image,
  MenuItem,
} from "semantic-ui-react";

function SignedIn({ handleLogOut }) {
  return (
    <div>
      <MenuItem>
        <Image avatar spaced="right" src="" />
        <Dropdown pointing="top" text="Halil">
          <DropdownMenu>
            <DropdownItem text="Bilgilerim" icon="info" />
            <DropdownItem
              onClick={handleLogOut}
              text="Çıkış Yap"
              icon="sign-out"
            />
          </DropdownMenu>
        </Dropdown>
      </MenuItem>
    </div>
  );
}

export default SignedIn;
