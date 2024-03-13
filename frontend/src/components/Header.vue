<template>
  <header id="head">
    <div class="header-container aaa">
      <nav class="header-nav-bar ">
        <div class="header-nav-logo">
          <!-- <a href="index.html"> -->
          <a href="/">
            <img src="https://res.cloudinary.com/joshuafolorunsho/image/upload/v1591615159/star_hotels_logo.png"
              alt="star hotels logo" />
          </a>
        </div>
        <!-- ========================================================== -->
        <div id="gnbMenu">
          <ul class="header-nav-lists">
            <li class="header-nav-list">
              <a class="header-nav-link" :class="{ 'header-active': currentRoute === '/about' }" href="about">About</a>
              <ul class="subMenu">
                <li><a href="#"><p>호텔소개</p></a></li>
                <li><a href="#"><p>오시는길</p></a></li>
              </ul>
            </li>
            <li class="header-nav-list">
              <a class="header-nav-link" :class="{ 'header-active': currentRoute === '/accommodation' }"
                href="accommodation">Accommodation</a>
              <ul class="subMenu acc">
                <li><a href="#"><p>호텔형</p></a></li>
                <li><a href="#"><p>콘도형</p></a></li>
              </ul>
            </li>
            <li class="header-nav-list">
              <a class="header-nav-link" :class="{ 'header-active': currentRoute === '/dining' }"
                href="dining">Dining</a>
              <ul class="subMenu">
                <li><a href="#"><p>식사장소</p></a></li>
              </ul>
            </li>
            <li class="header-nav-list">
              <a class="header-nav-link" :class="{ 'header-active': currentRoute === '/reservation' }"
                href="reservation">Reservation</a>
              <ul class="subMenu">
                <li><a href="#"><p>객실/패키지 예약</p></a></li>
                <li><a href="#"><p>예약조회</p></a></li>
              </ul>
            </li>
            <li class="header-nav-list">
              <a class="header-nav-link" :class="{ 'header-active': currentRoute === '/newsevent' }"
                href="newsevent">news&event</a>
              <ul class="subMenu news">
                <li><a href="#"><p>공지사항</p></a></li>
                <li><a href="#"><p>faq</p></a></li>
              </ul>
            </li>

          </ul>
        </div>

        <li class="header-nav-list">
          <a class="header-btn header-btn-custom" href="https://timbu.com/search?query=hotel">로그인</a>
        </li>


        <div class="header-hamburger-icon" @click="toggle">
          <div class="header-hamburger-line-1"></div>
          <div class="header-hamburger-line-2"></div>
          <div class="header-hamburger-line-3"></div>
        </div>
      </nav>
    </div>
  </header>
</template>

<script>
// import toggle from "../assets/js/toggleHamburger";

export default {
  data() {
    return {
      currentRoute: this.$route.path,
    };
  },
  watch: {
    $route(to) {
      this.currentRoute = to.path;
      console.log(this.currentRoute);
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
@import "../assets/css/Header.css";

#gnbMenu{
 display: flex;
}
#gnbMenu li{
  /* width: 150px; */
  /* outline: 1px solid red; */
 
}

#gnbMenu a{
  text-decoration: none;
      /* color: white; */
}
#gnbMenu li:hover .subMenu{
  /* width: 100%; */
  height: 100px;
  display: block;
}
.subMenu{
  position: absolute;
  display: none;
}

.subMenu li a p{
  font-size: 14px;
  color: #fff;
  /* outline: 1px solid red; */
  /* width: 150px; */

}
.subMenu li a{
text-align: center;
}
.subMenu li a p:hover{
color: orange;
}
.aaa{
  height: 120px;
}
.acc{
  width: 140px;
}
.news{
  width: 100px;
}

</style>
