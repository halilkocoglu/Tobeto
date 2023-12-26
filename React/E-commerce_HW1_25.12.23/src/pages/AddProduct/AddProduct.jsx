import axios from "axios";
import React, { useState } from "react";

function AddProduct() {
  const [input, setInput] = useState({
    brand: "",
    title: "",
    description: "",
    price: "",
  });

  const onChangeInput = (e) => {
    setInput({ ...input, [e.target.name]: e.target.value });
  };
  const addProduct = async (input) => {
    try {
      let response = await axios.post(
        "https://dummyjson.com/products/add",
        {
          brand: input.brand,
          title: input.title,
          description: input.description,
          price: input.price,
        },
        {
          "Content-Type": "application/json",
        }
      );
      console.log(response.data);
    } catch (e) {
      console.log("Error", e);
    }
  };
  const handleReset = () => {
    setInput({ brand: "", title: "", description: "", price: "" });
  };
  return (
    <div>
      <div className="mb-3">
        <label htmlFor="productBrand" className="form-label">
          Product Brand
        </label>
        <input
          name="brand"
          value={input.brand}
          onChange={onChangeInput}
          type="text"
          className="form-control"
          id="productBrand"
        />
      </div>
      <div className="mb-3">
        <label htmlFor="productTitle" className="form-label">
          Product Title
        </label>
        <input
          name="title"
          value={input.title}
          onChange={onChangeInput}
          type="text"
          className="form-control"
          id="productTitle"
        />
      </div>
      <div className="mb-3">
        <label htmlFor="productDescription" className="form-label">
          Product Description
        </label>
        <input
          name="description"
          value={input.description}
          onChange={onChangeInput}
          type="text"
          className="form-control"
          id="productDescription"
        />
      </div>
      <div className="mb-3">
        <label htmlFor="productPrice" className="form-label">
          Product Price
        </label>
        <input
          name="price"
          value={input.price}
          onChange={onChangeInput}
          type="text"
          className="form-control"
          id="productPrice"
        />
      </div>
      <div className="row">
        <button onClick={() => addProduct(input)} className="col-5 offset-1">
          Add
        </button>
        <button onClick={handleReset} className="col-5 offset-1">
          Reset
        </button>
      </div>
    </div>
  );
}

export default AddProduct;
