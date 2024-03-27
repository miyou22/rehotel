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
      </nav>
    </div>
  </header>
</template>

<script>
export default {};
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
