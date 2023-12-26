import axios from "axios";
import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

function ProductDetail() {
  const { id } = useParams();
  const [product, setProduct] = useState(null);
  const [counter, setCounter] = useState(0);

  useEffect(() => {
    fetchSingleProduct();
  }, []);

  const handleIncreaseClick = () => {
    setCounter(counter + 1);
    if (counter > product.images.length - 2) {
      setCounter(0);
    }
  };
  const handleDecreaseClick = () => {
    setCounter(counter - 1);
    if (counter < 1) {
      setCounter(product.images.length - 1);
    }
  };
  const fetchSingleProduct = async () => {
    let response = await axios.get(`https://dummyjson.com/products/${id}`);
    setProduct(response.data);
    console.log(response.data);
  };
  return (
    <>
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
    </>
  );
}

export default ProductDetail;
