<template>
  <Header v-if="!isAdminRoute && !isEmAdminRoute"></Header>
  <AHeader v-if="isAdminRoute"></AHeader>
  <EmHeader v-if="isEmAdminRoute"></EmHeader>
  <router-view />
  <Footer v-if="!isAdminRoute && !isEmAdminRoute"></Footer>
</template>

<script>
import Header from "./components/Header";
import Footer from "./components/Footer";
import AHeader from "./admin/common/AHeader.vue";
import EmHeader from "./admin/common/EmHeader.vue";

export default {
  name: "App",
  components: {
    Header,
    Footer,
    AHeader,
    EmHeader,
  },
  computed: {
    isAdminRoute() {
      return this.$route.path.startsWith("/admin");
    },
    isEmAdminRoute() {
      return this.$route.path.startsWith("/adLogin");
    },
  },
};
</script>
