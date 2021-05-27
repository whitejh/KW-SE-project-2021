import Vue from 'vue';
import VueRouter from 'vue-router';

import ProductList from '../views/ProductList.vue';
import ProductDetail from '../views/ProductDetail.vue';
import ProductCreate from '../views/ProductCreate.vue';
// import ProductUpdate from '../views/ProductUpdate.vue';
// import SalesList from '../views/SalesList.vue';
// import ImageInsert from '../views/ImageInsert.vue';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    redirect: '/login',
  },
  {
    path: '/login',
    component: () => import('@/views/LoginPage.vue'), // Code Spliting : url을 이동할 떄마다 필요한 자바스크립트 파일을 가져온다
  },
  {
    path: '/signup',
    component: () => import('@/views/SignupPage.vue'),
  },
  {
    path: '/list',
    name: 'ProductList',
    component: () => import('@/views/ProductList.vue'),
  },
  {
    path: '/detail',
    name: 'ProductDetail',
    component: () => import('@/views/ProductDetail.vue'),
  },
  {
    path: '/create',
    name: 'ProductCreate',
    component: () => import('@/views/ProductCreate.vue'),
  },
  {
    path: '*',
    component: () => import('@/views/NotFoundPage.vue'),
  },
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
});

export default router;

// 위와 같은 코드
// export default new VueRouter({
//   mode: 'history',
//   routes: [
//     {
//       path: '/',
//       redirect: '/login',
//     },
//     {
//       path: '/login',
//       component: () => import('@/views/LoginPage.vue'), // Code Spliting : url을 이동할 떄마다 필요한 자바스크립트 파일을 가져온다
//     },
//     {
//       path: '/signup',
//       component: () => import('~/src/views/SignupPage.vue'),
//     },
//     {
//       path: '*',
//       component: () => import('@/views/NotFoundPage.vue'),
//     },
//   ],
// });
// 라우터의 인스턴스가 생성되면서 현재 파일에서 밖으로 나간다. 이게 export의 역할
// default는 현재 파일에서 하나의 변수 혹은 함수가 나가는 것
