import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import About from '../views/About'
import Location from '../views/Location'
import Accommodation from '../views/Accommodation'
import Reservation from '../views/Reservation'
import Facility from '../views/Facility'
import Newsevent from '../views/Newsevent'
import Faq from '../views/news/faq/Faq'
import Board from '../views/news/board/BoardList'
import Banquethall from '../views/Banquethall'
import Mypage from '../views/Mypage'
import Joinmember from '../views/Joinmember'


import BoardDetail from '../views/news/board/BoardDetail'
import BoardWrite from '../views/news/board/BoardWrite'

import Payment from '../views/Payment'
import Admin from '../admin/home/Admin'


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
    path: '/location',
    name: 'location',
    component: Location
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
    path: '/facility',
    name: 'facility',
    component: Facility
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
    path: '/banquethall',
    name: 'banquethall',
    component: Banquethall
  },
 {
    path: "/payment",
    name: "payment",
    component: Payment,
  },

  {
    path: '/:pageType/detail',
    name: 'detail',
    component: BoardDetail
  },
  {
    path: '/:pageType/write',
    name: 'write',
    component: BoardWrite
  },
  {
    path: '/admin',
    name: 'admin',
    component: Admin
  },
  {
    path: '/mypage',
    name: 'mypage',
    component: Mypage
  },
  {
    path: '/joinmember',
    name: 'joinmember',
    component: Joinmember
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
