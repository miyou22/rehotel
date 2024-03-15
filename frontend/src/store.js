import { createStore } from "vuex";

const store = createStore({
  state() {
    return {
      fromDate: "",
      fromDate2: "",
    };
  },
  getters: {},
  mutations: {
    setYmd(state, payload) {
      state.fromDate = payload;
    },
    setYmd2(state, payload) {
      state.fromDate2 = payload;
    },
  },
});

export default store;
