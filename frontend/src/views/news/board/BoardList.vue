<template>
  <!-- Top Text -->
  <div class="board-container">
    <div class="page-header-container">
      <h1 class="page-header">{{ pageTitle }}</h1>
    </div>
    <!-- 공지사항 -->
    <div class="allBoard" v-if="pageType === 'notice'">
      <!-- Board -->
      <div class="board-list">
        <div class="common-buttons">
          <button
            type="button"
            class="w3-button w3-round w3-blue-gray w3-margin-bottom"
            v-if="pageType !== 'notice'"
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
            <tr v-for="item in 10" :key="item">
              <td class="w3-center">{{ item }}</td>
              <td class="w3-center">
                <a>hey</a>
              </td>
              <td class="w3-center"><a href="/notice/detail">about</a></td>
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
      <div class="searchBar">
        <select name="typeDetail">
          <option value="all" style="font-size: 14px">전체</option>
          <option value="칭찬" style="font-size: 14px">칭찬</option>
          <option value="문의" style="font-size: 14px">문의</option>
          <option value="제안" style="font-size: 14px">제안</option>
          <option value="기타" style="font-size: 14px">기타</option>
        </select>
        <div class="inputButton">
          <input type="text" placeholder="검색어를 입력하세요" id="search" />
          <button type="button" class="w3-button">검색</button>
        </div>
      </div>
    </div>
    <!-- 문의사항 -->
    <div class="allBoard" v-if="pageType === 'inquiry'">
      <!-- Board -->
      <div class="board-list">
        <div class="common-buttons">
          <button
            type="button"
            class="w3-button w3-round w3-margin-bottom buttonWrite"
            v-if="pageType !== 'notice'"
            @click="$router.push(pageType + '/write')"
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
              <th class="w3-center">고양이</th>
              <th class="w3-center">사자</th>
              <th class="w3-center">강아지</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="item in 10" :key="item">
              <td class="w3-center">{{ item }}</td>
              <td class="w3-center">
                <a>hey</a>
              </td>
              <td class="w3-center"><a href="/inquiry/detail">about</a></td>
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
      <div class="searchBar">
        <select name="typeDetail">
          <option value="all" style="font-size: 14px">전체</option>
          <option value="칭찬" style="font-size: 14px">칭찬</option>
          <option value="문의" style="font-size: 14px">문의</option>
          <option value="제안" style="font-size: 14px">제안</option>
          <option value="기타" style="font-size: 14px">기타</option>
        </select>
        <div class="inputButton">
          <input type="text" placeholder="검색어를 입력하세요" id="search" />
          <button type="button" class="w3-button">검색</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      pageTitle: "", // 페이지 제목
      pageType: "", // 페이지 유형 ('inquiry' 또는 'notice')
    };
  },
  created() {
    // 라우터를 통해 페이지 유형을 결정합니다.

    const pageType = this.$route.params.pageType;

    console.log(pageType);

    // 페이지의 유형에 따라 페이지 제목과 게시판 리스트 출력 여부를 설정합니다.
    if (pageType === "notice") {
      this.pageTitle = "공지사항";
      this.pageType = "notice";
    } else if (pageType === "inquiry") {
      this.pageTitle = "문의하기";
      this.pageType = "inquiry";
    }
  },
  // setup() {
  //   axios.get("/notice").then((res) => {
  //     console.log(res);
  //   });
  // },
};
</script>

<style scoped>
.board-container {
  max-width: 1200px;
  margin: 0 auto;
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
  background-image: url(../../../assets/img/dropdown.svg);
  background-repeat: no-repeat;
  background-position: 90% center;
  background-size: 14px;
}
a {
  text-decoration: none;
}
</style>
