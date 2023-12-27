import axios from 'axios';
import React, { useState, ChangeEvent } from 'react'
import { ProductModel } from '../../models/responses/ProductModel';
import ProductService from '../../services/ProductService';

type Props = {}

const AddProduct = (props: Props) => {
    const [input, setInput] = useState({
        id:0,  
        brand: "",
        title: "",
        discountPercentage: 0,
        rating: 0,
        description: "",
        stock: 0,
        price: 0,
        category: '',
        thumbnail: '',
        images: []
      });
    
      const onChangeInput = (e:ChangeEvent<HTMLInputElement>) => {
        setInput({ ...input, [e.target.name]: e.target.value });
      };
      const handleAddProduct = async (input:ProductModel) => {
        try {
            let response = await ProductService.addProduct({
                id: 0,
                title: input.title,
                description: input.description,
                price: input.price,
                discountPercentage: 0,
                rating: 0,
                stock: 0,
                brand:  input.brand,
                category: '',
                thumbnail: '',
                images: []
            });
          
          console.log(response.data);
        } catch (e) {
          console.log("Error", e);
        }
      };
      const handleReset = () => {
        setInput({id: 0,
          title: "",
          description: "",
          price: 0,
          discountPercentage: 0,
          rating: 0,
          stock: 0,
          brand: "",
          category: '',
          thumbnail: '',
          images: []});
      };
  return (
    <div className=' d-flex flex-column align-items-center justify-content-center'>
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
    <div className="row justify-content-between">
      <button onClick={() => handleAddProduct(input)} className=" btn btn-primary col-5 ">
        Add
      </button>
      <button onClick={handleReset} className=" btn btn-danger col-6 offset-1">
        Reset
      </button>
    </div>
  </div>
  )
}

export default AddProduct