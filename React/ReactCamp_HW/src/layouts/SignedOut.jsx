import React from "react";
import { Button, MenuItem } from "semantic-ui-react";

function SignedOut({ handleLogIn }) {
  return (
    <div>
      <MenuItem>
        <Button primary style={{ marginRight: "1em" }} onClick={handleLogIn}>
          Giriş Yap
        </Button>
        <Button primary>Kayıt Ol</Button>
      </MenuItem>
    </div>
  );
}

export default SignedOut;
