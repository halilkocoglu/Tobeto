import "./App.css";
import "semantic-ui-css/semantic.min.css";
import Dashboard from "./layouts/Dashboard";
import { Container } from "semantic-ui-react";
import Navi from "./layouts/Navi";
import { ToastContainer } from "react-toastify";
function App() {
  return (
    <div className="App">
      <Navi />

      <Container className="main">
        <ToastContainer position="top-right" />
        <Dashboard />
      </Container>
    </div>
  );
}

export default App;
