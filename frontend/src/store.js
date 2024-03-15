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
      checkinDate: null,
      checkoutDate: null,
      selectedRoomImageData: null,
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
    setCheckinDate(state, checkinDate) {
      state.checkinDate = checkinDate;
    },
    setCheckoutDate(state, checkoutDate) {
      state.checkoutDate = checkoutDate;
    },
    setSelectedRoomImageData(state, imageData) {
      state.selectedRoomImageData = imageData;
    },
  },
  actions: {
    updateSelectedMembers({ commit }, value) {
      commit("setSelectedMembers", value);
    },
    saveSelectedRoomImageData({ commit }, imageData) {
      commit('setSelectedRoomImageData', imageData);
    },
  },
});

export default store;
