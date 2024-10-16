import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import LoginView from '@/views/LoginView.vue'
import NewAccountView from '@/views/NewAccountView.vue'

function isAuthenticated() {
  const token = sessionStorage.getItem('authToken')

  // Aquí debería ir la lógica para gestionar tokens caducados. (casi prefiero que la duración sea infinita)
  return !!token
}

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
      meta: { requiresAuth: true }
    },
    {
      path: '/api/login',
      name: 'login',
      component: LoginView
    },
    {
      path: '/new-account',
      name: 'new-account',
      component: NewAccountView
    }
  ]
})

router.beforeEach((to, from, next) => {
  if (to.meta.requiresAuth && !isAuthenticated()) {
    next({ name: 'login' })
  } else {
    next()
  }
})

export default router
