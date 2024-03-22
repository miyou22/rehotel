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
            <input
              type="number"
              class="reservationNumber"
              name="reservationNumber"
              placeholder="나중에수정못하도록 input이 아닌 데이터값을 넣어야함."
              value
            />
          </td>
        </tr>
        <tr>
          <th>예약일</th>
          <td>
            <input
              type="text"
              class="memberName"
              name="memberName"
              placeholder="나중에수정못하도록 input이 아닌 데이터값을 넣어야함."
              value
            />
          </td>
        </tr>
        <tr>
          <th>체크인</th>
          <td>
            <input
              type="password"
              class="password"
              name="password"
              placeholder="나중에수정못하도록 input이 아닌 데이터값을 넣어야함."
              value
            />
          </td>
        </tr>
        <tr>
          <th>체크아웃</th>
          <td>
            <input
              type="password"
              class="passwordCheck"
              name="passwordCheck"
              placeholder="나중에수정못하도록 input이 아닌 데이터값을 넣어야함."
              value
            />
          </td>
        </tr>
        <tr>
          <th>예약상품</th>
          <td>
            <input type="email" class="email" name="email" value />
          </td>
        </tr>
        <tr>
          <th>예약자명</th>
          <td>
            <input type="text" class="namename" name="namename" value />
          </td>
        </tr>
        <tr>
          <th>연락처</th>
          <td>
            <input type="tel" class="tell" name="tell" value />
          </td>
        </tr>
        <tr>
          <th>요청사항</th>
          <td>
            <input type="text" class="request" name="request" value />
          </td>
        </tr>
        <tr>
          <th>결제금액</th>
          <td>
            <input
              type="text"
              class="join"
              name="join"
              placeholder="input이아닌데이터값"
              required
              value
            />
          </td>
        </tr>
      </tbody>
    </table>
    <!-- 버튼 -->
    <div class="w3-container w3-center w3-margin-top">
      <button
        class="w3-button w3-round w3-margin-bottom"
        style="width: 20%"
        @click="$router.push({ path: '/admin/reservation' })"
      >
        목록으로
      </button>
    </div>
  </div>
</template>

<script>
export default {
  methods: {},
};
</script>

<style scoped>
* {
  font-size: 16px;
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
