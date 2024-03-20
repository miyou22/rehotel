<template>
  <header id="head">
    <div class="header-container aaa">
      <nav class="header-nav-bar">
        <!-- ========================================================== -->
        <div class="header-nav-logo">
          <!-- <a href="index.html"> -->
          <a href="/">
            <img
              src="https://res.cloudinary.com/joshuafolorunsho/image/upload/v1591615159/star_hotels_logo.png"
              alt="star hotels logo"
            />
          </a>
        </div>
        <!-- ========================================================== -->
        <div id="gnbMenu">
          <ul class="header-nav-lists">
            <li class="header-nav-list">
              <a
                class="header-nav-link"
                :class="{ 'header-active': currentRoute === '/about' }"
                href="about"
              ></a>
            </li>
            <li class="header-nav-list">
              <a
                class="header-nav-link"
                :class="{ 'header-active': currentRoute === '/accommodation' }"
                href="accommodation"
                @click="subgnb2 = true"
                >회원관리</a
              >
            </li>
            <li class="header-nav-list">
              <a
                class="header-nav-link"
                :class="{ 'header-active': currentRoute === '/Facility' }"
                href="Facility"
                @click="subgnb2 = true"
                >예약관리</a
              >
            </li>
            <li class="header-nav-list">
              <a
                class="header-nav-link"
                :class="{ 'header-active': currentRoute === '/banquethall' }"
                href="banquethall"
                @click="subgnb2 = true"
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
    <p class="sub-gnb-name">3</p>
    <ul class="sub-gnb-list">
      <li><a href="#">3</a></li>
      <li><a href="#">3</a></li>
      <li><a href="#">3</a></li>
    </ul>
  </div>
</template>

<script>
// import toggle from "../assets/js/toggleHamburger";

export default {
  data() {
    return {
      currentRoute: this.$route.path,
      subgnb1: false,
      subgnb2: false,
      subgnb3: false,
      // ------------------------------------------
    };
  },
  watch: {
    $route(to) {
      this.currentRoute = to.path;
      if (to.path == "/about") {
        this.subgnb1 = true;
      } else if (
        to.path == "/accommodation" ||
        to.path == "/Facility" ||
        to.path == "/banquethall"
      ) {
        this.subgnb2 = true;
      } else if (to.path == "/reservation") {
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
  margin-bottom: 85px;
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
@media (max-width: 9000px) {
  .header-hamburger-icon {
  }
  .header-top-gnb {
    display: block;
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
