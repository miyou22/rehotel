<template>
  <Header v-if="!isAdminRoute"></Header>
  <AHeader v-else></AHeader>

  <router-view />
  <Footer v-if="!isAdminRoute"></Footer>
</template>

<script>
import Header from "./components/Header";
import Footer from "./components/Footer";
import AHeader from "./admin/common/AHeader.vue";

export default {
  name: "App",
  components: {
    Header,
    Footer,
    AHeader,
  },
  computed: {
    isAdminRoute() {
      return this.$route.path.startsWith("/admin");
    },
  },
};
</script>

<style></style>
