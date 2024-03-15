import { createStore } from "vuex";
import createPersistedState from "vuex-persistedstate";
const store = createStore({
  plugins: [createPersistedState()],
  state() {
    return {
      fromDate: "",
      fromDate2: "",
      selectedMembers: 1,
      selectedRoomData: null,
    };
  },
  getters: {
    getSelectedMembers(state) {
      return state.selectedMembers;
    },
  },
  mutations: {
    setYmd(state, payload) {
      state.fromDate = payload;
    },
    setYmd2(state, payload) {
      state.fromDate2 = payload;
    },
    setSelectedMembers(state, value) {
      state.selectedMembers = value;
    },
    setSelectedRoomData(state, payload) {
      state.selectedRoomData = payload;
    },
  },
  actions: {
    updateSelectedMembers({ commit }, value) {
      commit("setSelectedMembers", value);
    },
  },
});

export default store;
