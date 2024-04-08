<template>
  <!-- Top Text -->
  <div class="board-container">
    <div class="page-header-container">
      <h1 class="page-header">{{ pageTitle }}</h1>
    </div>
    <div class="allBoard">
      <div class="board-list">
        <div class="common-buttons">
          <button
            type="button"
            class="w3-button w3-round w3-blue-gray w3-margin-bottom"
            v-if="pageType !== 'notice'"
            @click.prevent="fnWrite"
          >
            작성하기-데헷
          </button>
        </div>
        <!-- 기본으로 나옴 -->
        <table
          class="w3-table w3-bordered w3-hoverable w3-margin-bottom"
          v-if="searchfinish === false"
        >
          <colgroup>
            <col width="110px" />
            <col width="auto" />
            <col width="100px" />
            <col width="80px" />
            <col width="200px" />
          </colgroup>
          <thead>
            <tr class="w3-light-grey w3-border-top w3-border-black">
              <th class="w3-center">번호</th>
              <th class="w3-center">제목</th>
              <th class="w3-center">작성자</th>
              <th class="w3-center">조회수</th>
              <th class="w3-center">작성일</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(item, idx) in paginatedBoardList" :key="idx">
              <td class="w3-center">{{ getNumber(idx) }}</td>
              <td class="w3-center">
                <a @click="boardView(pageType, item.boardSn)">{{
                  item.boardTitle
                }}</a>
              </td>
              <td class="w3-center">
                {{ item.userId }}
              </td>
              <td class="w3-center">
                {{ item.boardCnt }}
              </td>
              <td class="w3-center">
                {{ formatDate(item.createdAt) }}
              </td>
            </tr>
          </tbody>
        </table>
        <!-- 검색결과 -->
        <table
          class="w3-table w3-bordered w3-hoverable w3-margin-bottom"
          v-if="searchfinish === true"
        >
          <colgroup>
            <col width="110px" />
            <col width="auto" />
            <col width="180px" />
          </colgroup>
          <thead>
            <tr class="w3-light-grey w3-border-top w3-border-black">
              <th class="w3-center">번호</th>
              <th class="w3-center">제목</th>
              <th class="w3-center">조회수</th>
              <th class="w3-center">작성일</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(item, idx) in paginatedSearchList" :key="idx">
              <td class="w3-center">{{ getNumber(idx) }}</td>
              <td class="w3-center">
                <a @click="boardView(pageType, item.boardSn)">{{
                  item.boardTitle
                }}</a>
              </td>
              <td class="w3-center">
                {{ item.boardCnt }}
              </td>
              <td class="w3-center">
                {{ formatDate(item.createdAt) }}
              </td>
            </tr>
          </tbody>
        </table>
      </div>
      <!-- Pagination -->
      <div class="w3-bar pagin">
        <a
          href="#"
          class="w3-button w3-hover-white w3-hover-text-amber"
          @click="prevPage"
          >&laquo;</a
        >
        <a
          v-for="page in pageCount"
          :key="page"
          href="#"
          class="w3-button"
          :class="{
            'w3-text-black  w3-white w3-border w3-hover-white hofont':
              page === currentPage,
            'w3-text-black  w3-white w3-hover-white w3-hover-text-amber nofont':
              page !== currentPage,
          }"
          @click="changePage(page)"
          >{{ page }}</a
        >
        <a
          href="#"
          class="w3-button w3-hover-white w3-hover-text-amber w3-center"
          @click="nextPage"
          >&raquo;</a
        >
      </div>
      <!-- SearchBar -->
      <div class="searchBar">
        <div class="inputButton">
          <input
            v-model="searchKeyword"
            type="text"
            placeholder="검색어를 입력하세요"
            id="search"
          />
          <button type="button" class="w3-button" @click="searchstart">
            검색
          </button>
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
      boardList: [],
      itemsPerPage: 10,
      currentPage: 1,
      searchKeyword: "", // 검색키워드
      searchfinish: false, // 검색완료시 true로 바뀌고, 이때부터 표 생성
      searchcnt: 0, // 검색된 게시글 갯수
      contentlist: [], // 게시글 리스트
      searchList: [],
    };
  },
  mounted() {
    this.getBoardList();
  },
  computed: {
    pageCount() {
      return Math.ceil(this.boardList.length / this.itemsPerPage);
    },
    paginatedBoardList() {
      const startIndex = (this.currentPage - 1) * this.itemsPerPage;
      const endIndex = startIndex + this.itemsPerPage;
      const sortedList = this.boardList
        .slice()
        .sort((a, b) => new Date(b.createdAt) - new Date(a.createdAt));

      return sortedList.slice(startIndex, endIndex);
    },
    paginatedSearchList() {
      const startIndex = (this.currentPage - 1) * this.itemsPerPage;
      const endIndex = startIndex + this.itemsPerPage;
      const sortedList = this.searchList
        .slice()
        .sort((a, b) => new Date(b.createdAt) - new Date(a.createdAt));

      return sortedList.slice(startIndex, endIndex);
    },
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
  methods: {
    getBoardList() {
      if (this.pageType == "notice") {
        this.$axios
          .get("http://localhost:8081/api/notice")
          .then((res) => {
            this.boardList = res.data;
            // alert('getData() 수신데이터 ==> ' + res.data)
            console.log(res.data);
          })
          .catch((error) => {
            console.log(error);
          })
          .finally(() => {
            console.log("항상 마지막에 실행");
          });
      } else if (this.pageType == "inquiry") {
        this.$axios
          .get("http://localhost:8081/api/inquiry")
          .then((res) => {
            this.boardList = res.data;
            // alert('getData() 수신데이터 ==> ' + res.data)
            console.log(res.data);
          })
          .catch((error) => {
            console.log(error);
          })
          .finally(() => {
            console.log("항상 마지막에 실행");
          });
      }
    },
    formatDate(dateTimeString) {
      return dateTimeString.slice(0, 10);
    },
    boardView(pageType, boardSn) {
      this.$router.push({
        path: pageType + "/" + boardSn,
      });
    },
    fnWrite() {
      // 세션 스토리지에서 데이터 가져오기
      const sessionId = sessionStorage.getItem("sessionId");

      // 데이터가 없는 경우 경고창 표시
      if (!sessionId) {
        alert("로그인 후 이용가능합니다.");
        this.$router.push({ path: "login" });
      } else {
        // 데이터가 있는 경우 페이지 이동
        this.$router.push({ path: "/inquiry/write" });
      }
    },
    changePage(page) {
      this.currentPage = page;
    },
    nextPage() {
      if (this.currentPage < this.pageCount) {
        this.currentPage++;
      }
    },
    prevPage() {
      if (this.currentPage > 1) {
        this.currentPage--;
      }
    },
    getNumber(index) {
      const reversedIndex =
        this.boardList.length -
        (index + (this.currentPage - 1) * this.itemsPerPage);
      console.log(reversedIndex);
      return reversedIndex;
    },
    searchstart() {
      console.log("this.pageType::::", this.pageType);
      // 검색버튼 눌렀을때 실행
      if (this.searchKeyword === "") {
        alert("키워드가 없습니다!");
      } else {
        this.$axios
          .get(
            `http://localhost:8081/api/admin/board/search?keyword=${this.searchKeyword}&boardCategory=${this.pageType}`
          )

          .then((res) => {
            this.searchList = res.data;
            this.searchfinish = true;
          })
          .catch((err) => {
            console.error("api 호출 에러", err);
          });
      }
    },
  },
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
