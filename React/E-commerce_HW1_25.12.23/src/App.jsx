import { BrowserRouter, Routes, Route } from "react-router-dom";
import "./App.css";
import Homepage from "./pages/Homepage/Homepage";
import About from "./pages/About/About";
import Navbar from "./components/Navbar/Navbar";
import ProductDetail from "./pages/ProductDetail/ProductDetail";
import AddProduct from "./pages/AddProduct/AddProduct";

function App() {
  return (
    <div>
      <BrowserRouter>
        <Navbar />
        <div className="d-flex align-items-center justify-content-center mt-3">
          <Routes>
            <Route path="/" element={<Homepage />}></Route>
            <Route path="/add-product" element={<AddProduct />}></Route>
            <Route path="/about" element={<About />}></Route>
            <Route path="*" element={<p>Not Found</p>}></Route>
            <Route
              path="/product-detail/:id"
              element={<ProductDetail />}
            ></Route>
          </Routes>
        </div>
      </BrowserRouter>
    </div>
  );
}
export default App;
