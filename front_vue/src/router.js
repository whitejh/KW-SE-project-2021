import Vue from 'vue';
import Router from 'vue-router';
import LoginPage from '@/views/LoginPage.vue';
import SignupPage from '@/views/SignupPage.vue';
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
      path: '/cart',
      name: 'cart',
      component: Cart,
    },
  ],
});
