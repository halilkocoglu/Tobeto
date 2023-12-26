import axios from "axios";
import React from "react";
import { Link } from "react-router-dom";
import "./productCard.css";

export default function ProductCard(props) {
  const handleDelete = async (id) => {
    try {
      const response = await axios.delete(
        `https://dummyjson.com/products/${id}`
      );
      console.log(response.data);
    } catch (error) {
      console.log(error);
    }
  };
  return (
    <div className="card">
      <img src={props.product.thumbnail} className="card-img-top" alt="..." />
      <div className="card-body">
        <h5 className="card-title">{props.product.title}</h5>
        <p className="card-text">{props.product.description}</p>
        <div className="btn-group gap-5 ">
          <Link
            to={`/product-detail/${props.product.id}`}
            className="btn btn-primary rounded"
          >
            Details
          </Link>
          <button
            onClick={() => handleDelete(props.product.id)}
            className="btn btn-danger rounded"
          >
            Delete
          </button>
        </div>
      </div>
    </div>
  );
}
