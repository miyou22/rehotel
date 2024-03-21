import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import About from '../views/About'
import Location from '../views/Location'
import Accommodation from '../views/Accommodation'
import Reservation from '../views/Reservation'
import Facility from '../views/Facility'
import Newsevent from '../views/Newsevent'
import Faq from '../views/news/faq/Faq'
import Banquethall from '../views/Banquethall'
import Mypage from '../views/Mypage'
import Joinmember from '../views/join/Joinmember'
import Login from '../views/Login'
import Findidpw from '../views/Findidpw.vue'


import Board from '../views/news/board/BoardList'
import BoardDetail from '../views/news/board/BoardDetail'
import BoardWrite from '../views/news/board/BoardWrite'
import BoardUpdate from '../views/news/board/BoardUpdate'

import Payment from "../views/Payment";
import Check from "../views/Checklist.vue";

import Admin from "../admin/home/Admin";
import AdminBoard from "../admin/board/AdminBoardList"
import AdminBoardWrite from "../admin/board/AdminBoardWrite"
import AdminBoardDetail from "../admin/board/AdminBoardDetail"


const routes = [
  {
    path: "/",
    name: "home",
    component: Home,
  },
  {
    path: "/checkList",
    name: "checkList",
    component: Check,
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
    path: '/:pageType/update',
    name: 'update',
    component: BoardUpdate
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
  {
    path: '/login',
    name: 'login',
    component: Login
  },
 {
    path: '/findidpw',
    name: 'findidpw',
    component: Findidpw,
  }
  {
    path: '/admin',
    name: 'admin',
    component: Admin
  },
  {
    path: '/admin/:categoryType',
    name: 'categoryTitle',
    component: AdminBoard
  },
  {
    path: '/admin/:categoryType/write',
    name: 'write',
    component: AdminBoardWrite
  },
  {
    path: '/admin/:categoryType/detail',
    name: 'detail',
    component: AdminBoardDetail
  },

  // {
  //   path: '/about',
  //   name: 'about',
  //   // route level code-splitting
  //   // this generates a separate chunk (about.[hash].js) for this route
  //   // which is lazy-loaded when the route is visited.
  //   component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  // }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
