import React from 'react'
import { ProductModel } from '../../models/responses/ProductModel'
import { Link } from 'react-router-dom';
import axios, { HttpStatusCode } from 'axios';
import ProductService from '../../services/ProductService';

type Props = {
    product: ProductModel;
}

const ProductCard = (props: Props) => {
    const handleDelete = async (id: number) => {
        try {
          const response = await ProductService.delete(id);
          if(response.status === HttpStatusCode.Ok){
            console.log("Succesfully deleted");
            
          }
          console.log(response.data);
        } catch (error) {
          console.log(error);
        }
      };
  return (
    <div className="card" style={{height:"600px"}}>
      <img src={props.product.thumbnail} style={{height:"300px"}} className="card-img-top" alt="..." />
      <div className="card-body row flex-column justify-content-between "  >
        <h5 className="card-title">{props.product.title}</h5>
        <p className="card-text">{props.product.description}</p>
        <p className="card-text">{props.product.price}$</p>

        <div className="btn-group gap-5 ">
          <Link
            to={`/product-detail/?id=${props.product.id}`}
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
  )
}

export default ProductCard