<template>
  <main>
    <!-- Top Text -->
    <div class="container">
      <div class="page-header-container">
        <h2 class="page-header">공지사항</h2>
        <hr />
      </div>
      <!-- Board -->
      <div class="board-list">
        <div class="common-buttons">
          <button
            type="button"
            class="w3-button w3-round w3-blue-gray w3-margin-bottom"
          >
            작성하기
          </button>
        </div>
        <table class="w3-table w3-bordered w3-hoverable w3-margin-bottom">
          <colgroup>
            <col width="110px" />
            <col width="180px" />
            <col width="auto" />
            <col width="180px" />
          </colgroup>
          <thead>
            <tr class="w3-light-grey w3-border-top w3-border-black">
              <th class="w3-center">번호</th>
              <th class="w3-center">카테고리</th>
              <th class="w3-center">제목</th>
              <th class="w3-center">작성일</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td class="w3-center">1</td>
              <td class="w3-center">
                <a>hey</a>
              </td>
              <td class="w3-center">about</td>
              <td class="w3-center">nyaa</td>
            </tr>
            <tr>
              <td class="w3-center">1</td>
              <td class="w3-center">
                <a>hey</a>
              </td>
              <td class="w3-center">about</td>
              <td class="w3-center">nyaa</td>
            </tr>
            <tr>
              <td class="w3-center">1</td>
              <td class="w3-center">
                <a>hey</a>
              </td>
              <td class="w3-center">about</td>
              <td class="w3-center">nyaa</td>
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
  </main>
</template>

<script>
export default {};
</script>

<style scoped>
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
</style>
