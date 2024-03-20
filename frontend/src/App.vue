<template>
  <Header v-if="$route.name !== 'admin'"></Header>
  <router-view />
  <Footer v-if="$route.name !== 'admin'"></Footer>
</template>

<script>
import Header from "./components/Header";
import Footer from "./components/Footer";
export default {
  name: "App",
  components: {
    Header,
    Footer,
  },
};
</script>

<style></style>
