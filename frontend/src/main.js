import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import VueDatePicker from "@vuepic/vue-datepicker";
import "@vuepic/vue-datepicker/dist/main.css";
import store from "./store.js";

import axios from "axios";

// createApp(App).component("VueDatePicker", VueDatePicker).use(router).use(store).mount('#app')
const app = createApp(App);
app.config.globalProperties.$axios = axios;
app.config.globalProperties.$serverUrl = "//localhost:3081";

app
  .component("VueDatePicker", VueDatePicker)
  .use(store)
  .use(router)
  .mount("#app");
