<template>
  <div class="board-container w3-margin-bottom">
    <div class="page-header-container">
      <h1 class="page-header">예약상세</h1>
    </div>

    <!-- 글작성 메뉴 -->
    <table class="w3-border-top w3-margin-top w3-border-black">
      <tbody>
        <tr>
          <th>예약번호</th>
          <td>
            <p>{{ SelectedResItems.resId }}</p>
          </td>
        </tr>
        <tr>
          <th>예약일</th>
          <td>{{ SelectedResItems.resDate.split("T")[0] }}</td>
        </tr>
        <tr>
          <th>체크인</th>
          <td>{{ SelectedResItems.resCheckin.split("T")[0] }}</td>
        </tr>
        <tr>
          <th>체크아웃</th>
          <td>{{ SelectedResItems.resCheckout.split("T")[0] }}</td>
        </tr>
        <tr>
          <th>예약상품</th>
          <td>{{ SelectedResItems.roomName }}</td>
        </tr>
        <tr>
          <th>예약자명</th>
          <td>{{ SelectedResItems.userName }}</td>
        </tr>
        <tr>
          <th>연락처</th>
          <td>{{ formatPhoneNumber(SelectedResItems.userTel) }}</td>
        </tr>
        <tr>
          <th>요청사항</th>
          <td>{{ SelectedResItems.resRequest }}</td>
        </tr>
        <tr>
          <th>결제금액</th>
          <td>{{ numberWithCommas(SelectedResItems.roomPrice) }}원</td>
        </tr>
        <tr>
          <th>연회장이용</th>
          <td>
            {{
              SelectedResItems.facCheck === 1 ? "이용" : "이용하지않음"
            }}
          </td>
        </tr>
        <tr>
          <th>예약상태</th>
          <td>{{ SelectedResItems.payCheck === 1 ? "예약" : "취소" }}</td>
        </tr>
      </tbody>
    </table>
    <!-- 버튼 -->
    <div class="w3-container w3-center w3-margin-top">
      <button
        class="w3-button w3-round w3-margin-bottom"
        style="width: 20%"
        @click="$router.push({ path: '/checkList' })"
      >
        목록으로
      </button>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  computed: {
    // Vuex 게터를 사용하여 선택된 예약 항목을 가져오기
    ...mapGetters(["getSelectedResItems"]),
    SelectedResItems() {
      return this.getSelectedResItems;
    },
  },
  methods: {
    numberWithCommas(x) {
      return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
    formatPhoneNumber(phoneNumber) {
      // 전화번호에서 숫자만 추출
      const cleaned = ("" + phoneNumber).replace(/\D/g, "");
      if (!/^0/.test(cleaned)) {
        return "0" + cleaned;
      }
      // 정규식을 사용하여 전화번호 형식에 맞게 변환
      const match = cleaned.match(/^(\d{3})(\d{4})(\d{4})$/);
      if (match) {
        return match[1] + "-" + match[2] + "-" + match[3];
      }
      return phoneNumber;
    },
  },
};
</script>

<style scoped>
* {
  font-size: 16px;
  font-family: "Noto Sans KR", sans-serif;
}

.board-container {
  max-width: 1200px;
  margin: 0 auto;
}
.page-header-container {
  margin-bottom: 50px;
}
.page-header {
  margin: 0;
  font-size: 40px;
  font-weight: bold;
  text-align: center;
}
#editor {
  width: 100%;
  font-size: 4px !important;
  margin-bottom: 100px;
}
.boardWrite-container {
  max-width: 1200px;
  margin: 0 auto;
}
table {
  border-collapse: collapse;
  width: 100%;
}
select,
td input {
  height: 36px;
  min-width: 240px;
  padding-left: 12px;
  border: 1px solid rgb(221, 221, 221);
}
td select {
  background-position: 96% center;
}
.titleLong {
  width: 60%;
}
tr th {
  width: 240px;
  background-color: #f7f7f7;
  text-align: center;
}
th,
td {
  padding: 9px 12px;
}
tbody tr {
  border-bottom: 1px solid rgb(238, 238, 238);
}

button {
  margin-left: 30px;
  padding: 15px;
  background-color: #d4af37;
  color: white;
}
.selectCategory {
  -webkit-appearance: none; /* for chrome */
  -moz-appearance: none; /*for firefox*/
  appearance: none;
  /* background-image: url(../../../assets/img/dropdown.svg); */
  background-repeat: no-repeat;
  background-position: 95% center;
  background-size: 14px;
}
/* tab-item 과 dining 반응형 css와 겹침 */
</style>
