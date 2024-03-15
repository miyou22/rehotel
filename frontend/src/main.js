import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import VueDatePicker from "@vuepic/vue-datepicker";
import "@vuepic/vue-datepicker/dist/main.css";
import store from "./store.js";

createApp(App).component("VueDatePicker", VueDatePicker).use(router).use(store).mount('#app')
