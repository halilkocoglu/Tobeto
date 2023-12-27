import React, { ReactElement } from 'react';
import './App.css';
import { Route, Routes } from 'react-router-dom';
import Homepage from './pages/Homepage/Homepage';
import ProductDetail from './pages/ProductDetail/ProductDetail';
import Navbar from './components/Navbar/Navbar';
import AddProduct from './pages/AddProduct/AddProduct';

function App() : ReactElement {
  return (
    <div className="App">
      <Navbar/>
      <Routes>
        <Route path='/' element={<Homepage/>}/>
        <Route path='/product-detail' element={<ProductDetail/>}/>
        <Route path='/add-product' element={<AddProduct/>}/>
      </Routes>
    </div>
  );
}

export default App;
