import React, { useEffect, useState } from 'react'
import ProductCard from '../../components/ProductCard/ProductCard'
import  ProductService  from '../../services/ProductService'
import { ProductModel } from '../../models/responses/ProductModel'

type Props = {

}

const Homepage = (props: Props) => {
    const [products, setProducts] = useState<ProductModel[]>([]);

    useEffect(() => {
        fetchProducts();
    }, [])
    
    const fetchProducts = async () =>{
        try {
            let response = await ProductService.getAll();
            setProducts(response.data.products)
        } catch (error) {
            console.log(error);
        }
        
        
    }
    
  return (
    <div className='container mt-5'>
        <div className="row">
            {
                products.map((product) => (
                <div key={product.id} className='col-lg-3 col-md-6 col-12 mb-5'>
                        <ProductCard product= {product}/>
                    </div>
                    )
                )
            }
        </div>
    </div>
  )
}

export default Homepage