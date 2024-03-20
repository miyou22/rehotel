<template>
  <!-- Top Text -->
  <div class="board-container">
    <div class="page-header-container">
      <h1 class="page-header">{{ categoryTitle }}</h1>
    </div>
    <!--체크박스 삽입 할까 말까?-->
    <!-- 공지사항 -->
    <div class="allBoard" v-if="categoryType === 'board'">
      <!-- Board -->
      <div class="board-list">
        <div class="common-buttons">
          <button
            type="button"
            class="w3-button w3-white w3-border w3-hover-white"
            @click="$router.push(categoryType + '/write')"
          >
            게시글 작성
          </button>
          <button
            type="button"
            class="w3-button w3-white w3-border-red w3-border w3-text-red"
          >
            게시글 삭제
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
    </div>
    <!-- 문의사항 -->
    <div class="allBoard" v-if="categoryType === 'comments'">
      <!-- Board -->
      <div class="board-list">
        <div class="common-buttons">
          <button
            type="button"
            class="w3-button w3-round w3-margin-bottom w3-hover-white w3-text-red w3-border-red"
            @click="$router.push(categoryType + '/write')"
          >
            삭제하기
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
    </div>
    <!-- 게시글삭제 -->
    <div class="allBoard" v-if="categoryType === 'deletePost'">
      <!-- Board -->
      <div class="board-list">
        <div class="common-buttons">
          <button
            type="button"
            class="w3-button w3-round w3-margin-bottom w3-hover-white"
            @click="$router.push(categoryType + '/write')"
          >
            선택 글 복원하기
          </button>
          <button
            type="button"
            class="w3-button w3-round w3-margin-bottom w3-hover-white w3-hover-text-red w3-text-red w3-border-red"
            @click="$router.push(categoryType + '/write')"
          >
            영구 삭제
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
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      categoryTitle: "", // 페이지 제목
      categoryType: "", // 페이지 유형 ('inquiry' 또는 'notice')
    };
  },
  created() {
    // 라우터를 통해 페이지 유형을 결정합니다.

    const categoryType = this.$route.params.categoryType;

    console.log(categoryType);

    // 페이지의 유형에 따라 페이지 제목과 게시판 리스트 출력 여부를 설정합니다.
    if (categoryType === "board") {
      this.categoryTitle = "게시글 관리";
      this.categoryType = "board";
    } else if (categoryType === "comments") {
      this.categoryTitle = "댓글 관리";
      this.categoryType = "comments";
    } else if (categoryType === "deletePost") {
      this.categoryTitle = "삭제된 글 관리";
      this.categoryType = "deletePost";
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
