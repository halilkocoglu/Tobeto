import { ADD_TO_CART, REMOVE_FROM_CART } from "../actions/cartActions";
import { cartItems } from "../initialValues/cartItems";

const initialState = {
  cartItems: cartItems,
};
export default function cartReducer(state = initialState, { type, payload }) {
  switch (type) {
    case ADD_TO_CART: {
      let product = state.cartItems.find((c) => c.product.id === payload.id);
      if (product) {
        // Mevcut product'ın bir kopyasını oluştur
        const updatedProduct = { ...product };
        updatedProduct.quantity++; // Miktarı artır
        // Yeni bir state döndür, güncellenmiş ürünü kullan
        return {
          ...state,
          cartItems: state.cartItems.map((c) =>
            c.product.id === payload.id ? updatedProduct : c
          ),
        };
      } else {
        return {
          ...state,
          cartItems: [...state.cartItems, { quantity: 1, product: payload }],
        };
      }
    }
    case REMOVE_FROM_CART:
      return {
        ...state,
        cartItems: state.cartItems.filter((c) => c.product.id !== payload.id),
      };

    default:
      return state;
  }
}
