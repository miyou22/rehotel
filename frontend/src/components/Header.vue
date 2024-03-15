<template>
  <header id="head">
    <div class="header-container aaa">

      <nav class="header-nav-bar ">
        <!-- ========================================================== -->
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

            </li>
            <li class="header-nav-list">
              <a class="header-nav-link" :class="{ 'header-active': currentRoute === '/accommodation' }"
                href="accommodation">Accommodation</a>

            </li>
            <li class="header-nav-list">
              <a class="header-nav-link" :class="{ 'header-active': currentRoute === '/dining' }"
                href="dining">Facility</a>

            </li>
            <li class="header-nav-list">
              <a class="header-nav-link" :class="{ 'header-active': currentRoute === '/newsevent' }"
                href="newsevent">banquet hall</a>

            </li>
            <li class="header-nav-list">
              <a class="header-nav-link" :class="{ 'header-active': currentRoute === '/reservation' }"
                href="reservation">Reservation</a>

            </li>
            <li class="header-nav-list">
              <a class="header-nav-link" :class="{ 'header-active': currentRoute === '/newsevent' }"
                href="newsevent">news&event</a>
            </li>
            

          </ul>
        </div>









      </nav>
      <div>
        <ul class="header-top-gnb">
          <div class="top-menu">
          <li><a href="#">MyPage</a></li>
          <li><a href="#">LogIn</a></li>
          <li><a href="#">회원가입</a></li>
          <li><a href="#">회원가입</a></li>
          <li><a href="#">회원가입</a></li>
        </div>
         <li> <button class="top-btn">Books Now</button></li>
        </ul>
        <div class="header-hamburger-icon" @click="toggle">
          <div class="header-hamburger-line-1"></div>
          <div class="header-hamburger-line-2"></div>
          <div class="header-hamburger-line-3"></div>
        </div>
      </div>
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

#gnbMenu {
  display: flex;

}

#gnbMenu ul {
  list-style: none;

}


#gnbMenu a {
  text-decoration: none;
}

#gnbMenu li:hover .subMenu {
  width: 150px;
  display: block;
}

.subMenu {
  position: absolute;
  display: none;
  z-index: 100;
  list-style: none;
  background-color: white;
  border-radius: 3%;
  outline: 1px solid black;
}

.subMenu li a p {
  font-size: 14px;
  color: black;
  padding: 10px;
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


.subMenu li a p:hover {
  color: #D4AF37;
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
</style>
