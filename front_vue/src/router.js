import Vue from 'vue';
import Router from 'vue-router';
import Home from './views/Home.vue';
import Shop from './views/Shop.vue';
import Cart from './views/Features';

Vue.use(Router);

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
    },
    {
      path: '/shop',
      name: 'shop',
      component: Shop,
    },
    {
      path: '/cart',
      name: 'cart',
      component: Cart,
    },
  ],
});
