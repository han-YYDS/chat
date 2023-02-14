import { createRouter, createWebHashHistory } from 'vue-router';

const routes = [
  {
    path: '/',
    redirect: '/home',
  },
  {
    path: '/home',
    component: () => import('@/views/home.vue'),
  },
  {
    path: '/room',
    component: () => import('@/views/room.vue'),
  },
  {
    path: '/login',
    component: () => import('@/views/User/login.vue'),
  }, 
   {
    path: '/maillogin',
    component: () => import('@/views/User/NewMailLogin.vue'),
  },
  {
    path: '/newlogin',
    component: () => import('@/views/User/NewLogin.vue'),
  }
];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
});

export default router;
