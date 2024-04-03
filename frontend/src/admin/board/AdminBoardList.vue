<template>
  <!-- Top Text -->
  <div class="board-container">
    <div class="page-header-container">
      <h1 class="page-header">{{ categoryTitle }}</h1>
    </div>
    <!-- 게시글관리 -->
    <div class="allBoard" v-if="categoryType === 'board'">
      <!-- Board -->
      <div class="board-list">
        <div class="common-buttons">
          <button
            type="button"
            class="w3-button w3-white w3-border w3-hover-white"
            @click="$router.push('board/write')"
          >
            게시글 작성
          </button>
          <button
            type="button"
            class="w3-button w3-white w3-border-red w3-border w3-text-red"
            @click="fnChange"
          >
            게시글 삭제
          </button>
        </div>
        <table class="w3-table w3-bordered w3-hoverable w3-margin-bottom">
          <colgroup>
            <col width="80px" />
            <col width="100px" />
            <col width="200px" />
            <col width="auto" />
            <col width="200px" />
            <col width="200px" />
            <col width="150px" />
          </colgroup>
          <thead>
            <tr class="w3-light-grey w3-border-top w3-border-black">
              <th class="w3-center">
                <input
                  type="checkbox"
                  id="selectAll"
                  @change="selectAllItems($event.target.checked)"
                />
              </th>
              <th class="w3-center">번호</th>
              <th class="w3-center">게시판</th>
              <th class="w3-center">제목</th>
              <th class="w3-center">작성자ID</th>
              <th class="w3-center">조회수</th>
              <th class="w3-center">작성일</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(item, idx) in paginatedResList" :key="idx">
              <td class="w3-center">
                <input
                  type="checkbox"
                  id="select"
                  @change="selectItem"
                  v-model="item.selected"
                />
              </td>
              <td class="w3-center">{{ getNumber(idx) }}</td>
              <td class="w3-center">{{ jpcall(item.boardCategory) }}</td>
              <td class="w3-center">
                <a @click="boardView(item.boardSn)">{{ item.boardTitle }}</a>
              </td>
              <td class="w3-center">nyaa</td>
              <td class="w3-center">{{ item.boardCnt }}</td>
              <td class="w3-center">{{ formatDate(item.createdAt) }}</td>
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
    </div>
    <!-- 댓글관리 -->
    <div class="allBoard" v-if="categoryType === 'comments'">
      <!-- Board -->
      <div class="board-list">
        <div class="common-buttons">
          <button
            type="button"
            class="w3-button w3-round w3-margin-bottom w3-hover-white"
            @click="fnBackPost"
          >
            선택 글 복원하기
          </button>
          <button
            type="button"
            class="w3-button w3-round w3-margin-bottom w3-hover-white w3-hover-text-red w3-text-red w3-border-red"
            @click="fnDelete"
          >
            영구 삭제
          </button>
        </div>
        <table class="w3-table w3-bordered w3-hoverable w3-margin-bottom">
          <colgroup>
            <col width="80px" />
            <col width="100px" />
            <col width="200px" />
            <col width="auto" />
            <col width="300px" />
            <col width="100px" />
            <col width="150px" />
          </colgroup>
          <thead>
            <tr class="w3-light-grey w3-border-top w3-border-black">
              <th class="w3-center">
                <input
                  type="checkbox"
                  id="selectAll"
                  @change="selectAllItems($event.target.checked)"
                />
              </th>
              <th class="w3-center">번호</th>
              <th class="w3-center">게시판</th>
              <th class="w3-center">게시글제목</th>
              <th class="w3-center">댓글내용</th>
              <th class="w3-center">작성자ID</th>
              <th class="w3-center">작성일</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(item, idx) in paginatedCommentList" :key="idx">
              <td class="w3-center">
                <input
                  type="checkbox"
                  id="select"
                  @change="selectItem"
                  v-model="item.selected"
                />
              </td>
              <td class="w3-center">{{ getNumber(idx) }}</td>
              <td class="w3-center">{{ jpcall(item.board.boardCategory) }}</td>
              <td class="w3-center">{{ item.board.boardTitle }}</td>
              <td class="w3-center deContent">
                <p class="deleteContent">{{ item.content }}</p>
              </td>
              <td class="w3-center">nyaa</td>
              <td class="w3-center">{{ formatDate(item.createdAt) }}</td>
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
    </div>
    <!-- 게시글삭제 -->
    <div class="allBoard" v-if="categoryType === 'deletePost'">
      <!-- Board -->
      <div class="board-list">
        <div class="common-buttons">
          <button
            type="button"
            class="w3-button w3-round w3-margin-bottom w3-hover-white"
            @click="fnBackPost"
          >
            선택 글 복원하기
          </button>
          <button
            type="button"
            class="w3-button w3-round w3-margin-bottom w3-hover-white w3-hover-text-red w3-text-red w3-border-red"
            @click="fnDelete"
          >
            영구 삭제
          </button>
        </div>
        <table class="w3-table w3-bordered w3-hoverable w3-margin-bottom">
          <colgroup>
            <col width="80px" />
            <col width="100px" />
            <col width="200px" />
            <col width="auto" />
            <col width="200px" />
            <col width="150px" />
          </colgroup>
          <thead>
            <tr class="w3-light-grey w3-border-top w3-border-black">
              <th class="w3-center">
                <input
                  type="checkbox"
                  id="selectAll"
                  @change="selectAllItems($event.target.checked)"
                />
              </th>
              <th class="w3-center">번호</th>
              <th class="w3-center">게시판</th>
              <th class="w3-center">제목</th>
              <th class="w3-center">작성자ID</th>
              <th class="w3-center">작성일</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(item, idx) in paginatedResList" :key="idx">
              <td class="w3-center">
                <input
                  type="checkbox"
                  id="select"
                  @change="selectItem"
                  v-model="item.selected"
                />
              </td>
              <td class="w3-center">{{ getNumber(idx) }}</td>
              <td class="w3-center">{{ jpcall(item.boardCategory) }}</td>
              <td class="w3-center">
                <a @click="boardView(item.boardSn)">{{ item.boardTitle }}</a>
              </td>
              <td class="w3-center">nyaa</td>
              <td class="w3-center">{{ formatDate(item.createdAt) }}</td>
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
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      categoryTitle: "", // 페이지 제목
      categoryType: "", // 페이지 유형 ('inquiry' 또는 'notice')
      boardList: [],
      requestBody: {},
      boardCategory: "",
      itemsPerPage: 10,
      currentPage: 1,
      selectChecked: [],
      commentList: [],
    };
  },
  mounted() {
    if (this.categoryType == "board") {
      this.getBoardList();
    } else if (this.categoryType === "deletePost") {
      this.getDeleteList();
    } else if (this.categoryType === "comments") {
      this.fnCommentList();
    }
  },
  computed: {
    pageCount() {
      return Math.ceil(this.boardList.length / this.itemsPerPage);
    },
    paginatedResList() {
      const startIndex = (this.currentPage - 1) * this.itemsPerPage;
      const endIndex = startIndex + this.itemsPerPage;
      return this.boardList.slice(startIndex, endIndex);
    },
    paginatedCommentList() {
      const startIndex = (this.currentPage - 1) * this.itemsPerPage;
      const endIndex = startIndex + this.itemsPerPage;
      return this.commentList.slice(startIndex, endIndex);
    },
  },
  created() {
    // 라우터를 통해 페이지 유형을 결정합니다.
    const categoryType = this.$route.params.categoryType;

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
  methods: {
    selectAllItems(checked) {
      this.allChecked = checked;
      for (let i in this.boardList) {
        this.boardList[i].selected = this.allChecked;
      }
    },
    selectItem(checked) {
      let itemIdx = [];
      for (let i in this.boardList) {
        if (this.boardList[i].selected) {
          itemIdx.push(this.boardList[i].boardSn);
        }
        console.log(itemIdx);
      }
      return itemIdx;
    },
    fnChange() {
      alert("삭제할꼬야?");
      const selectIds = this.selectItem();
      if (selectIds.length === 0) {
        alert("꺼졍 ㅋ");
        return;
      }
      selectIds.map((boardSn) => {
        const boardDto = { boardSn, boardStatus: "N" }; // 삭제 요청에 필요한 요청 본문을 생성합니다.
        this.$axios
          .put(
            "http://localhost:8081/api/admin/board/detail/" + boardSn,
            boardDto
          )
          .then((res) => {
            console.log("data sent", res);
            alert("글삭제가 완료되었습니다");
            window.location.reload();
          })
          .catch((error) => {
            console.log("에러닷!", error);
          });
      });
    },
    getBoardList() {
      this.$axios
        .get("http://localhost:8081/api/admin/board")
        .then((res) => {
          this.boardList = res.data;
          console.log(res.data);
        })
        .catch((error) => {
          console.log(error);
        })
        .finally(() => {
          console.log("항상 마지막에 실행");
        });
    },
    getDeleteList() {
      this.$axios
        .get("http://localhost:8081/api/admin/deletePost")
        .then((res) => {
          this.boardList = res.data;
          console.log(res.data);
        })
        .catch((error) => {
          console.log(error);
        })
        .finally(() => {
          console.log("항상 마지막에 실행");
        });
    },
    fnCommentList() {
      this.$axios
        .get("http://localhost:8081/api/admin/comments")
        .then((res) => {
          this.commentList = res.data;
          console.log(res.data);
        })
        .catch((error) => {
          console.log(error);
        })
        .finally(() => {
          console.log("항상 마지막에 실행");
        });
    },
    fnCommentDelete() {},
    formatDate(dateTimeString) {
      return dateTimeString.slice(0, 10);
    },

    boardView(boardSn) {
      alert("boardSn은 : " + boardSn);
      // this.requestBody.boardSn = boardSn;
      this.$router.push({
        // query: this.requestBody,
        path: "/admin/board/detail/" + boardSn,
      });
    },
    jpcall(category) {
      let categoryChange = "";
      if (category === "notice") {
        categoryChange = "공지사항";
      } else if (category === "inquiry") {
        categoryChange = "문의사항";
      } else if (category === "faq") {
        categoryChange = "FAQ";
      }
      return categoryChange;
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
        (index + (this.currentPage - 1) * this.itemsPerPage) +
        1;
      return reversedIndex;
    },
    fnBackPost() {
      alert("복구할꼬야?");
      const selectIds = this.selectItem();
      console.log(selectIds);
      if (selectIds.length === 0) {
        alert("선택하지 않았어요.");
        return;
      }
      selectIds.map((boardSn) => {
        const boardDto = { boardSn, boardStatus: "Y" };
        this.$axios
          .put(
            "http://localhost:8081/api/admin/board/detail/" + boardSn,
            boardDto
          )
          .then((res) => {
            console.log("data sent", res);
            alert("글복구가 완료되었습니다");
            window.location.reload();
          })
          .catch((error) => {
            console.log("에러닷!", error);
          });
      });
    },
    fnDelete() {
      alert("삭제할꼬야?");
      const selectIds = this.selectItem();
      if (selectIds.length === 0) {
        alert("선택되지 않았엉");
        return;
      }
      selectIds.map((boardSn) => {
        const boardDto = { boardSn, boardStatus: "Y" }; // 삭제 요청에 필요한 요청 본문을 생성합니다.

        console.log(boardDto);
        const config = {
          data: boardDto,
        };
        this.$axios
          .delete(
            `http://localhost:8081/api/admin/deletePost/${boardSn}`,
            config
          )
          .then((res) => {
            console.log("data sent", res);
            alert("글삭제가 완료되었습니다");
            window.location.reload();
          })
          .catch((error) => {
            console.log("에러닷!", error);
          });
      });
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
  cursor: pointer;
}
.deContent {
  text-align: center;
}
.deleteContent {
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  width: 300px;
  color: red;
  text-align: center;
}
</style>
