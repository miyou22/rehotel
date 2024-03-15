import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import About from '../views/About'
import Accommodation from '../views/Accommodation'
import Reservation from '../views/Reservation'
import Dining from '../views/Dining'
import Newsevent from '../views/Newsevent'
import Faq from '../views/news/faq/Faq'
import Board from '../views/news/board/BoardList'
import Payment from '../views/Payment'


const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path: '/about',
    name: 'about',
    component: About
  },
  {
    path: '/accommodation',
    name: 'accommodation',
    component: Accommodation
  },
  {
    path: '/reservation',
    name: 'reservation',
    component: Reservation
  },
  {
    path: '/dining',
    name: 'dining',
    component: Dining
  },
  {
    path: '/newsevent',
    name: 'newsevent',
    component: Newsevent
  },
  {
    path: '/faq',
    name: 'faq',
    component: Faq
  },
  {
    path: '/:pageType',
    name: 'pageType',
    component: Board
  },
 {
    path: "/payment",
    name: "payment",
    component: Payment,
  },
  // {
  //   path: '/about',
  //   name: 'about',
  //   // route level code-splitting
  //   // this generates a separate chunk (about.[hash].js) for this route
  //   // which is lazy-loaded when the route is visited.
  //   component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  // }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
