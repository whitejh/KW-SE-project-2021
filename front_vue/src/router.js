import Vue from 'vue';
import Router from 'vue-router';
import LoginPage from '@/views/LoginPage.vue';
import SignupPage from '@/views/SignupPage.vue';
import Home from './views/Home.vue';
import Shop from './views/Shop.vue';
import Banpal from './components/shop/Banpal.vue';
import Shirts from './components/shop/Shirts.vue';
import Pk from './components/shop/PK.vue';

import ProductCreate from './views/ProductCreate.vue';
import Cart from './views/Cart.vue';
import MyPage from './views/MyPage.vue';
import MyInfo from './components/mypage/MyInfo.vue';

Vue.use(Router);

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      redirect: '/login',
    },
    {
      path: '/login',
      component: LoginPage,
      // component: () => import('@/views/LoginPage.vue'), // Code Spliting : url을 이동할 떄마다 필요한 자바스크립트 파일을 가져온다
    },
    {
      path: '/signup',
      component: SignupPage,
      // component: () => import('@/views/SignupPage.vue'),
    },
    {
      path: '/home',
      name: 'home',
      component: Home,
    },
    {
      path: '/shop',
      name: 'shop',
      component: Shop,
    },
    {
      path: '/Banpal',
      name: 'Banpal',
      component: Banpal,
    },
    {
      path: '/Shirts',
      name: 'Shirts',
      component: Shirts,
    },
    {
      path: '/PK',
      name: 'PK',
      component: Pk,
    },

    {
      path: '/create',
      name: 'create',
      component: ProductCreate,
    },
    {
      path: '/cart',
      name: 'cart',
      component: Cart,
    },
    {
      path: '/mypage',
      name: 'mypage',
      component: MyPage,
    },
    {
      path: '/myinfo',
      name: 'myinfo',
      component: MyInfo,
    },
  ],
});
