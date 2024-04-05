<template>
  <header id="head">
    <div class="header-container aaa">
      <nav class="header-nav-bar">
        <!-- ========================================================== -->
        <div class="header-nav-logo">
          <!-- <a href="index.html"> -->
          <a href="/admin">
            <img src="../../assets/img/logo.png" alt="kings hotel logo" />
          </a>
        </div>
        <!-- ========================================================== -->
        <div id="gnbMenu">
          <ul class="header-nav-lists">
            <li class="header-nav-list">
              <a
                class="header-nav-link"
                :class="{ 'header-active': currentRoute === '/admin/member' }"
                href="/admin/member"
                >회원관리</a
              >
            </li>
            <li class="header-nav-list">
              <a
                class="header-nav-link"
                :class="{
                  'header-active': currentRoute === '/admin/reservation',
                }"
                href="/admin/reservation"
                >예약관리</a
              >
            </li>
            <li class="header-nav-list">
              <a
                class="header-nav-link"
                :class="{
                  'header-active':
                    currentRoute === '/admin/board' ||
                    currentRoute === '/admin/comments' ||
                    currentRoute === '/admin/deletepost',
                }"
                href="/admin/board"
                >게시판관리</a
              >
            </li>
          </ul>
        </div>
      </nav>
      <div>
        <ul class="header-top-gnb">
          <div class="top-menu">
            <li>
              <a class="header-nav-link" href="/">사이트 홈</a>
            </li>
            <li>
              <a class="w3-border w3-round-large loginLink" href="#">로그인</a>
            </li>
          </div>
        </ul>
        <div class="header-hamburger-icon" @click="toggle">
          <div class="header-hamburger-line-1"></div>
          <div class="header-hamburger-line-2"></div>
          <div class="header-hamburger-line-3"></div>
        </div>
      </div>
    </div>
  </header>

  <div class="sub-gnb" v-if="subgnb3">
    <p class="sub-gnb-name">게시판 관리</p>
    <ul class="sub-gnb-list">
      <li>
        <a
          href="/admin/board"
          :class="{ 'header-active': currentRoute === '/admin/board' }"
          >게시글관리</a
        >
      </li>
      <li>
        <a
          href="/admin/comments"
          :class="{ 'header-active': currentRoute === '/admin/comments' }"
          >댓글관리</a
        >
      </li>
      <li>
        <a
          href="/admin/deletePost"
          :class="{ 'header-active': currentRoute === '/admin/deletePost' }"
          >삭제된 글 관리</a
        >
      </li>
    </ul>
  </div>
</template>

<script>
// import toggle from "../assets/js/toggleHamburger";

export default {
  data() {
    return {
      color1: false,
      subgnb3: true,
      currentRoute: "", // currentRoute 추가
    };
  },
  mounted() {
    this.currentRoute = window.location.pathname; // 현재 URL을 currentRoute에 할당
  },
  beforeMount: function () {
    // alert("beforeMount");
    var currentUrl = window.location.pathname;
    // alert(currentUrl);

    if (
      currentUrl === "/admin/board" ||
      currentUrl === "/admin/comments" ||
      currentUrl === "/admin/deletePost"
    ) {
      // alert("AHeader Watch Route....");
      this.subgnb3 = true;
    } else {
      this.subgnb3 = false; // this 키워드 추가
    }
  },

  methods: {
    toggle() {
      const ul = document.querySelector(".header-nav-lists");
      const hamburger = document.querySelector(".header-hamburger-icon");
      ul.classList.toggle("show");
      hamburger.classList.toggle("show");
    },
  },
};
</script>

<style scoped>
@import "/src/assets/css/Header.css";

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
  height: 60px;
  border-radius: 5%;
  width: 180px;
  margin-left: 30px;
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

.top-menu {
  transform: translateY(0);
}

.loginLink {
  display: block;
  width: 90px;
  height: 32px;
  text-align: center;
  line-height: 2.4;
}

@media (min-width: 1px) {
  .header-nav-lists {
    display: flex;
  }

  .header-hamburger-icon {
    display: none;
  }
}

@media (max-width: 10000px) {
  .header-top-gnb {
    display: flex;
  }

  .subMenu li a {
    display: none;
  }
}

@media (min-width: 1px) {
  * {
    font-size: 20px;
  }
}
</style>
