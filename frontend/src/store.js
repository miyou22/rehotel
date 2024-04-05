import { createStore } from "vuex";
import createPersistedState from "vuex-persistedstate";
const store = createStore({
  plugins: [createPersistedState()],
  state() {
    return {
      reservationId: "",
      reservationEmail: "",
      reservationEmail2: "",
      fromDate: "",
      fromDate2: "",
      selectedMembers: 1,
      selectedRoomData: null,
      checkinDate: null,
      checkoutDate: null,
      selectedRoomImageData: null,
      totalmember: null,
      selectedResItem: null,
      selectedResItems: null,
      selectedMemItems: null,
      userId: null,
      isLoggedIn: false,
    };
  },
  getters: {
    getSelectedMembers(state) {
      return state.selectedMembers;
    },
    getSelectedResItem: (state) => state.selectedResItem,
    getSelectedResItems: (state) => state.selectedResItems,
    getSelectedMemItems: (state) => state.selectedMemItems,
  },
  mutations: {
    setReservationId(state, reservationId) {
      state.reservationId = reservationId; // 예약번호를 저장하는 mutation
    },
    setReservationEmail(state, reservationEmail) {
      state.reservationEmail = reservationEmail; // 예약번호를 저장하는 mutation
    },
    setReservationEmail2(state, reservationEmail2) {
      state.reservationEmail2 = reservationEmail2; // 예약번호를 저장하는 mutation
    },
    setSelectedResItem(state, item) {
      state.selectedResItem = item; // 선택된 예약 항목을 설정하는 뮤테이션
    },
    setSelectedResItems(state, item) {
      state.selectedResItems = item; // 선택된 예약 항목을 설정하는 뮤테이션
    },
    setSelectedMemItems(state, item) {
      state.selectedMemItems = item; // 선택된 예약 항목을 설정하는 뮤테이션
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
    setUserId(state, userId) {
      state.userId = userId // 사용자 아이디를 저장하는 뮤테이션 추가
    },
    // 로그인 상태를 변경하는 뮤테이션
    setLoggedIn(state, isLoggedIn) {
      state.isLoggedIn = isLoggedIn;
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
    setSelectedResItems({ commit }, item) {
      commit("setSelectedResItems", item); // 선택된 예약 항목을 설정하는 액션
    },
    setSelectedMemItems({ commit }, item) {
      commit("setSelectedMemItems", item); // 선택된 예약 항목을 설정하는 액션
    },
  },
});

export default store;
