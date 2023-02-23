import { createRouter, createWebHashHistory } from 'vue-router';

const routes = [
  {
    path: '/',
    redirect: '/login',
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
  },
  {
    path: '/register',
    component: () => import('@/views/User/register.vue'),
  },
  {
    path: '/forget',
    component: () => import('@/views/User/forget.vue'),
  },
  {
    path:'/Historicalmeetings',
    component: () => import('@/views/Historicalmeetings.vue'),

  }

];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
});

export default router;
