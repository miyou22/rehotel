<template>
  <main>
    <!-- Top Text -->
    <div class="container-check">
      <div class="page-header-container">
        <h2 class="page-header">예약 목록</h2>
      </div>
      <!-- Board -->
      <div class="board-list">
        <table class="w3-table w3-bordered w3-hoverable w3-margin-bottom">
          <colgroup>
            <col width="110px" />
            <col width="180px" />
            <col width="auto" />
            <col width="180px" />
          </colgroup>
          <thead>
            <tr class="w3-light-grey w3-border-top w3-border-black">
              <th class="w3-center" style="width: 110px">번호</th>
              <th class="w3-center" style="width: 220px">예약번호</th>
              <th class="w3-center" style="width: 280px">객실명</th>
              <th class="w3-center" style="width: 140px">체크인</th>
              <th class="w3-center" style="width: 140px">체크아웃</th>
              <th class="w3-center" style="width: 140px">예약날짜</th>
              <th class="w3-center" style="width: 150px">결제금액</th>
              <th class="w3-center" style="width: 140px">예약 취소</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td class="w3-center">1</td>
              <td class="w3-center">
                <a>3326645884</a>
              </td>
              <td class="w3-center room">그랜드 스위트 룸</td>
              <td class="w3-center">2024/03/18</td>
              <td class="w3-center">2024/03/20</td>
              <td class="w3-center">2024/02/22</td>
              <td class="w3-center">200,000</td>
              <td class="w3-center">
                <button class="return" @click="checkRe">취소</button>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
      <!-- Pagination -->
      <div class="w3-bar pagin">
        <a href="#" class="w3-button w3-hover-purple circle">«</a>
        <a href="#" class="w3-button w3-hover-green">1</a>

        <a href="#" class="w3-button w3-hover-orange circle">»</a>
      </div>
      <!-- SearchBar -->
    </div>
  </main>
</template>

<script>
export default {
  methods: {
    checkRe() {
      if (confirm("삭제하시겠습니까?") == true) {
        //true는 확인버튼을 눌렀을 때 코드 작성
        alert("예약 취소되었습니다");
      } else {
        // false는 취소버튼을 눌렀을 때, 취소됨
        return;
      }
    },
  },
};
</script>

<style scoped>
.container-check {
  width: 1200px;
  margin: auto;
}
.common-buttons {
  text-align: right;
  font-size: 15px;
}
.common-buttons button {
  padding: 15px 75px;
}
.pagin {
  text-align: center;
}
.room {
  vertical-align: middle;
  font-size: 16px;
  font-weight: bold;
}
.return {
  border-radius: 10px;
  width: 50px;
  padding: 5px;
  font-size: 14px;
  border: none;
  background-color: #d4af37;
  cursor: pointer;
  color: white;
}
.return:hover {
  background-color: #e0ba3a;
  color: black;
}
.circle {
  width: 24px;
  border: 1px solid black;
  /* border: 1px solid rgb(186, 160, 133); */
  /* color: rgb(156, 131, 106); */
  color: black;
  border-radius: 100%;
  padding: 0 7px;
  height: 24px;
  line-height: 20px;
}
.page-header {
  text-align: center;
  margin-top: 80px;
  margin-bottom: 80px;
}
</style>
