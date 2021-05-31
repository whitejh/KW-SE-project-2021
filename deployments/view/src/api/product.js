import http from './http';

export default {
  async getBestProducts() {
    return http.get('api/best-product.json');
  },
  async getFeaturedProducts() {
    return http.get('api/featured-product.json');
  },
  async getProducts() {
    return http.get('api/products.json', {});
  },
  async getProducts1() {
    return http.get('api/products1.json', {});
  },
};
