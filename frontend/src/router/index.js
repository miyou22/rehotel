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
import AdminBoardUpdate from "../admin/board/AdminBoardUpdate.vue"
import AdminMember from "../admin/member/AdminMember"
import AdminMemberDetail from "../admin/member/AdminMemberDetail"
import AdminReservation from "../admin/reservation/ReservationList"
import AdminReservationDetail from "../admin/reservation/ReservationDetail"


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
    path: '/:pageType(notice|inquiry)',
    name: 'pageType',
    component: Board
  },

  {
    path: '/:pageType(notice|inquiry)/update',
    name: 'update',
    component: BoardUpdate
  },
  {
    path: '/:pageType(notice|inquiry)/detail',
    name: 'detail',
    component: BoardDetail
  },

  {
    path: '/:pageType(notice|inquiry)/write',
    name: 'write',
    component: BoardWrite
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
  },
  {
    path: '/admin',
    name: 'admin',
    component: Admin
  },
  {
    path: '/admin/:categoryType(board|comments|deletepost)',
    name: 'categoryType',
    component: AdminBoard
  },
  {
    path: '/admin/:categoryType(board|comments|deletepost)/detail',
    name: 'Admindetail',
    component: AdminBoardDetail
  },
  {
    path: '/admin/board/update',
    name: 'Adminupdate',
    component: AdminBoardUpdate
  },
  {
    path: '/admin/board/write',
    name: 'Adminwrite',
    component: AdminBoardWrite
  },
  {
    path: '/admin/member',
    name: 'AdminMember',
    component: AdminMember
  },
  {
    path: '/admin/member/detail',
    name: 'AdminMemberDetail',
    component: AdminMemberDetail
  },
  {
    path: '/admin/reservation',
    name: 'AdminReservation',
    component: AdminReservation
  },
  {
    path: '/admin/reservation/detail',
    name: 'AdminReservationDetail',
    component: AdminReservationDetail
  },
  // {
  //   path: '/admin/:categoryType(board|comments|deletepost)/detail',
  //   name: 'Admindetail',
  //   component: AdminBoardDetail
  // },
  // {
  //   path: '/admin/board/write',
  //   name: 'Adminwrite',
  //   component: AdminBoardWrite
  // },


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
