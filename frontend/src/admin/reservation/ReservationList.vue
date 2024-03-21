<template>
  <!-- Top Text -->
  <div class="board-container">
    <div class="page-header-container">
      <h1 class="page-header">예약목록</h1>
    </div>
    <!--체크박스 삽입 할까 말까?-->
    <!-- 게시글관리 -->
    <div class="allBoard">
      <!-- Board -->
      <div class="board-list">
        <div class="common-buttons">
          <button
            type="button"
            class="w3-button w3-white w3-border-red w3-border w3-text-red"
          >
            선택예약 취소
          </button>
        </div>
        <table class="w3-table w3-bordered w3-hoverable w3-margin-bottom">
          <colgroup>
            <col width="80px" />
            <col width="100px" />
            <col width="200px" />
            <col width="200px" />
            <col width="auto" />
            <col width="150PX" />
            <col width="100PX" />
            <col width="50PX" />
          </colgroup>
          <thead>
            <tr class="w3-light-grey w3-border-top w3-border-black">
              <th class="w3-center">
                <input
                  type="checkbox"
                  id="selectAll"
                  @change="selectAllItems"
                />
              </th>
              <th class="w3-center">번호</th>
              <th class="w3-center">예약번호</th>
              <th class="w3-center">예약자명(회원ID)</th>
              <th class="w3-center">체크인</th>
              <th class="w3-center">체크아웃</th>
              <th class="w3-center">체크예약일</th>
              <th class="w3-center">상태</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="item in 10" :key="item">
              <td class="w3-center">
                <input type="checkbox" id="select" />
              </td>
              <td class="w3-center">{{ 10 - item + 1 }}</td>
              <td class="w3-center">문의하기</td>
              <td class="w3-center">객실</td>
              <td class="w3-center">
                <a href="/admin/board/detail">about</a>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
      <!-- Pagination -->
      <div class="w3-bar pagin">
        <a href="#" class="w3-button w3-hover-purple circle">«</a>
        <a href="#" class="w3-button w3-hover-green">1</a>
        <a href="#" class="w3-button w3-hover-red">2</a>
        <a href="#" class="w3-button w3-hover-blue">3</a>
        <a href="#" class="w3-button w3-hover-black">4</a>
        <a href="#" class="w3-button w3-hover-orange circle">»</a>
      </div>
      <!-- SearchBar -->
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    selectAllItems() {
      const item = document.querySelectorAll('input[type="checkbox"]');
      const firstBox = document.querySelector('input[id="selectAll"]');
      item.forEach((box) => {
        box.checked = firstBox.checked;
      });
      console.log(item);
    },
  },
};
</script>

<style scoped>
table th,
table td {
  font-size: 16px;
}
.board-container {
  max-width: 1200px;
  margin: 0 auto;
  padding-bottom: 100px;
}
.buttonWrite {
  background-color: #d4af37;
  color: white;
}
.page-header {
  margin: 0;
  font-size: 40px;
  font-weight: bold;
}
.page-header-container {
  text-align: center;
  margin-bottom: 80px;
}
.common-buttons {
  text-align: right;
  font-size: 14px;
  margin-bottom: 24px;
}
.common-buttons button {
  width: 140px;
  height: 40px;
  margin-left: 8px;
  color: rgb(136, 136, 136);
  border: 1px solid rgb(221, 221, 221);
}

.pagin {
  text-align: center;
  margin-top: 50px;
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
.searchBar {
  justify-content: center;
  display: flex;
  column-gap: 10px;
  height: 40px;
  font-size: 14px;
  margin-top: 50px;
  margin-bottom: 100px;
}
.inputButton {
  display: flex;
  column-gap: 10px;
}
.inputButton input {
  border: 1px solid rgb(221, 221, 221);
  font-size: 14px;
  padding: 0 8px;
  width: 250px;
}
.inputButton button {
  font-size: 14px;
  width: 80px;
  height: 40px;
  border: none;
  background-color: #d4af37;
  color: white;
}
.searchBar select {
  width: 120px;
  border: 1px solid rgb(221, 221, 221);
  padding: 0 30px 0px 15px;
  font-size: 14px;
  -webkit-appearance: none; /* for chrome */

  -moz-appearance: none; /*for firefox*/

  appearance: none;
  background-repeat: no-repeat;
  background-position: 90% center;
  background-size: 14px;
}
a {
  text-decoration: none;
}
</style>
