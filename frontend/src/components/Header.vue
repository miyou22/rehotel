<template>
  <header id="head">
    <div class="header-container aaa">
      <nav class="header-nav-bar">
        <!-- ========================================================== -->
        <div class="header-nav-logo">
          <!-- <a href="index.html"> -->
          <a href="/">
            <img src="../assets/img/logo.png" alt="logo" />
          </a>
        </div>
        <!-- ========================================================== -->
        <div id="gnbMenu">
          <ul class="header-nav-lists">
            <li class="header-nav-list">
              <a
                class="header-nav-link"
                :class="{
                  'header-active':
                    currentRoute === '/about' || currentRoute === '/location',
                }"
                href="about"
                >About</a
              >
            </li>
            <li class="header-nav-list">
              <a
                class="header-nav-link"
                :class="{ 'header-active': currentRoute === '/accommodation' }"
                href="accommodation"
                @click="subgnb2 = true"
                >Accommodation</a
              >
            </li>
            <li class="header-nav-list">
              <a
                class="header-nav-link"
                :class="{ 'header-active': currentRoute === '/Facility' }"
                href="Facility"
                @click="subgnb2 = true"
                >Facility</a
              >
            </li>
            <li class="header-nav-list">
              <a
                class="header-nav-link"
                :class="{ 'header-active': currentRoute === '/banquethall' }"
                href="banquethall"
                @click="subgnb2 = true"
                >banquet hall</a
              >
            </li>
            <li class="header-nav-list">
              <a
                class="header-nav-link"
                :class="{ 'header-active': currentRoute === '/reservation' }"
                href="reservation"
                >Reservation</a
              >
            </li>
            <li class="header-nav-list">
              <a
                class="header-nav-link"
                :class="{
                  'header-active':
                    currentRoute === '/notice' ||
                    currentRoute === '/inquiry' ||
                    currentRoute === '/faq',
                }"
                href="notice"
                >notice</a
              >
            </li>
          </ul>
        </div>
      </nav>
      <div>
        <ul class="header-top-gnb">
          <div class="top-menu">
            <!-- ------------------------------------------------------------------------------------------------------------------------- -->
            <!-- <li>
              <a
                class="header-nav-link"
                :class="{ 'header-active': currentRoute === '/mypage' }"
                href="mypage"
                >myPage</a
              >
            </li> -->
            <!-- ------------------------------------------------------------------------------------------------------------------------- -->
            <li v-if="!$store.state.isLoggedIn"><a href="/login">LogIn</a></li>
            <li v-else>
              <a @click="logout()" style="cursor: pointer"
                >{{ $store.state.userId }}님 Logout</a
              >
            </li>

            <li v-if="!$store.state.isLoggedIn">
              <a href="/joinmember">회원가입</a>
            </li>
            <li v-else><a href="/mypage">마이페이지</a></li>
            <li v-if="!$store.state.userId"><a href="/login">예약확인</a></li>
            <li v-else><a href="/checkList">예약확인</a></li>
            <li><a href="/location">오시는길</a></li>
            <li><a href="/sitemap">사이트맵</a></li>
            <li><a href="/adLogin">관리자 홈</a></li>
          </div>
          <li>
            <button class="top-btn">
              <a href="/reservation" class="booksNow">Books Now!!!</a>
            </button>
          </li>
        </ul>
        <div class="header-hamburger-icon" @click="toggle">
          <div class="header-hamburger-line-1"></div>
          <div class="header-hamburger-line-2"></div>
          <div class="header-hamburger-line-3"></div>
        </div>
      </div>
    </div>
  </header>
  <div class="sub-gnb" v-if="subgnb1">
    <p class="sub-gnb-name">킹스 호텔</p>
    <ul class="sub-gnb-list">
      <li>
        <router-link
          to="/about"
          :class="{ 'header-active': currentRoute === '/about' }"
          @click="(color1 = true), (color2 = false)"
          >호텔 소개</router-link
        >
      </li>
      <li>
        <router-link
          to="/location"
          :class="{ active: color2 }"
          @click="(color2 = true), (color1 = false)"
          >오시는 길</router-link
        >
      </li>
    </ul>
  </div>

  <div class="sub-gnb" v-if="subgnb2">
    <p class="sub-gnb-name">시설 소개</p>
    <ul class="sub-gnb-list">
      <li>
        <a
          href="accommodation"
          :class="{ 'header-active': currentRoute === '/accommodation' }"
          >객실</a
        >
      </li>
      <li>
        <a
          href="Facility"
          :class="{ 'header-active': currentRoute === '/Facility' }"
          >부대시설</a
        >
      </li>
      <li>
        <a
          href="banquethall"
          :class="{ 'header-active': currentRoute === '/banquethall' }"
          >연회장</a
        >
      </li>
    </ul>
  </div>

  <div class="sub-gnb" v-if="subgnb3">
    <p class="sub-gnb-name">고객지원</p>
    <ul class="sub-gnb-list">
      <li>
        <a
          href="/notice"
          :class="{ 'header-active': currentRoute === '/notice' }"
          >공지사항</a
        >
      </li>
      <li>
        <a
          href="/inquiry"
          :class="{ 'header-active': currentRoute === '/inquiry' }"
          >문의사항</a
        >
      </li>
      <li>
        <a href="/faq" :class="{ 'header-active': currentRoute === '/faq' }"
          >faq</a
        >
      </li>
    </ul>
  </div>
</template>

<script>
// import toggle from "../assets/js/toggleHamburger";
import axios from "axios";
import store from "@/store";
const serverUrl = "http://localhost:8081";

export default {
  data() {
    return {
      currentRoute: this.$route.path,
      subgnb1: false,
      subgnb2: false,
      subgnb3: false,
      // ------------------------------------------
      isLoggedIn: false, // 로그인 여부를 나타냄
    };
  },
  watch: {
    $route(to) {
      this.currentRoute = to.path;
      if (to.path == "/about" || to.path == "/location") {
        this.subgnb1 = true;
      } else if (
        to.path == "/accommodation" ||
        to.path == "/Facility" ||
        to.path == "/banquethall"
      ) {
        this.subgnb2 = true;
      } else if (
        to.path == "/notice" ||
        to.path == "/faq" ||
        to.path == "/inquiry"
      ) {
        this.subgnb3 = true;
      }
    },
  },
  methods: {
    toggle() {
      const ul = document.querySelector(".header-nav-lists");
      const hamburger = document.querySelector(".header-hamburger-icon");
      ul.classList.toggle("show");
      hamburger.classList.toggle("show");
    },

    logout() {
      alert("로그아웃합니다");
      store.commit('setLoggedIn', false);
      // sessionStorage.removeItem("userId");
      store.commit("setAccount", null);
      sessionStorage.removeItem("sessionId");
      console.log("세션제거 ==> " + sessionStorage.sessionId);
      this.$router.push({
        path: "/",
        name: "home",
      });
    },
  },
};
</script>

<style scoped>
@import "../assets/css/Header.css";

#gnbMenu {
  display: flex;
}

#gnbMenu ul {
  list-style: none;
}

#gnbMenu a {
  text-decoration: none;
}

.top-btn {
  height: 50px;
  border: none;
  width: 180px;
  background-color: #d4af37;
  color: white;
  float: right;
}

.aaa {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.acc {
  width: 140px;
}


.news {
  width: 100px;
}
.sub-gnb {
  display: flex;
  height: 60px;
  outline: 1px solid #d3d1d1;
  align-items: center;
  margin-bottom: 85px;
}
.sub-gnb-name {
  font-weight: bold;
  font-size: 18px;
  margin: 0 140px 0 40px;
}
.sub-gnb-list {
  display: flex;
  list-style: none;
}
.sub-gnb-list li {
  margin: 0 20px 0 20px;
}
.sub-gnb-list li a {
  font-size: 16px;
  text-decoration: none;
}
.booksNow {
  font-size: 16px;
  text-align: center;
  margin: 0;
  font-weight: 500;
  color: white;
}

.booksNow:hover {
  color: black;
}
.active {
  color: #d4af37;
}
</style>
