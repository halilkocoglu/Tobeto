import React, { useEffect, useState } from 'react'
import { useLocation } from 'react-router-dom'
import { ProductModel } from '../../models/responses/ProductModel';
import ProductService from '../../services/ProductService';

type Props = {}

const ProductDetail = (props: Props) => {
  const [product, setProduct] = useState<ProductModel>();
  const [counter, setCounter] = useState<number>(0);
  const [queryId, setQueryId] = useState<any>("")
  //Query params via location
  const location = useLocation();
  let query = new URLSearchParams(location.search)
  const id = query.get('id');

    useEffect(() => {
    if(id){
      fetchSingleProduct(id);
    }
  }, []);

  const handleIncreaseClick = () => {
    setCounter(counter + 1);
    if (product && counter > product.images.length - 2 ) {
      setCounter(0);
    }
  };
  const handleDecreaseClick = () => {
    setCounter(counter - 1);
    if (counter < 1 && product) {
      setCounter(product.images.length - 1);
    }
  };
  const fetchSingleProduct = async (id:string) => {
    try {
      let response = await ProductService.getById(id);
      setProduct(response.data)

      
    } catch (error) {
      
    }
  };
  return (
    <div className="d-flex justify-content-center align-items-center ">
      {product && (
        <div className="row col-12 col-md-8 d-flex justify-content-center align-items-center ">
          <div className=" row col-12 d-flex justify-content-center align-items-center  ">
            <div
              id="carouselExampleFade"
              className="carousel slide carousel-fade"
            >
              <div className="carousel-inner">
                <div className="carousel-item active">
                  <img
                    style={{ maxHeight: "400px" }}
                    src={product.images[counter]}
                    className="d-block w-100 rounded-4"
                    alt="..."
                  />
                </div>
              </div>
              <button
                onClick={() => handleDecreaseClick()}
                className="carousel-control-prev "
                type="button"
              >
                <span className="text-danger fs-1">{"<"}</span>
              </button>
              <button
                onClick={() => handleIncreaseClick()}
                className="carousel-control-next "
                type="button"
              >
                <span className="text-danger fs-1">{">"}</span>
              </button>
            </div>
          </div>
          <div className="row col-11 d-flex border border-dark-subtle rounded my-3 ">
            <div className="row align-items-center">
              <h5 className="card-title col-10">{product.title}</h5>
              <div className=" col-1 ">
                <div className="text-decoration-line-through">
                  {product.price}$
                </div>
                <div>
                  {(product.price *
                    Math.round(100 - product.discountPercentage)) /
                    100}
                  $
                </div>
              </div>
            </div>
            <p className="card-text">{product.description}</p>
            <p className="card-text">Rating : {product.rating}</p>
            <p className="card-text">{product.description}</p>
            <p className="card-text">{product.description}</p>
          </div>
        </div>
      )}
    </div>
  )
}

export default ProductDetail