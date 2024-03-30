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
      totalmember: null,
      selectedResItem: null,
      userId: null,
    };
  },
  getters: {
    getSelectedMembers(state) {
      return state.selectedMembers;
    },
    getSelectedResItem: (state) => state.selectedResItem,
  },
  mutations: {
    setSelectedResItem(state, item) {
      state.selectedResItem = item; // 선택된 예약 항목을 설정하는 뮤테이션
    },
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
    setTotalMember(state, totalmember) {
      state.totalmember = totalmember;
    },
    setAccount(state, payload) {
      state.userId = payload;
      sessionStorage.setItem("sessionId", payload);
    },
  },
  actions: {
    updateSelectedMembers({ commit }, value) {
      commit("setSelectedMembers", value);
    },
    saveSelectedRoomImageData({ commit }, imageData) {
      commit("setSelectedRoomImageData", imageData);
    },
    setSelectedResItem({ commit }, item) {
      commit("setSelectedResItem", item); // 선택된 예약 항목을 설정하는 액션
    },
  },
});

export default store;
