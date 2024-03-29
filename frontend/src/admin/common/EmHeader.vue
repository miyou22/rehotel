<template>
  <header id="head">
    <div class="header-container aaa">
      <nav class="header-nav-bar">
        <!-- ========================================================== -->
        <div class="header-nav-logo">
          <!-- <a href="index.html"> -->
          <a href="/">
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

.aaa {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

@media (min-width: 1px) {
  * {
    font-size: 20px;
  }
}
</style>
