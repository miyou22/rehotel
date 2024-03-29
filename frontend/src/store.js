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
      isLoggedIn: false, // 로그인 상태를 저장할 변수
    };
  },
  getters: {
    getSelectedMembers(state) {
      return state.selectedMembers;
    },
    getSelectedResItem: (state) => state.selectedResItem,
    getSelectedUserId: (state) => state.userId, //사용자 ID를 반환하는 getter
    isLoggedIn: (state) => state.isLoggedIn, // 로그인 상태를 반환하는 getter
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
    setLoggedIn(state, status) { //  로그인 상태를 업데이트하는 뮤테이션
      state.isLoggedIn = status;
    },
    setUserId(state, userId) { // 사용자 ID를 업데이트하는 뮤테이션
      state.userId = userId;
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
