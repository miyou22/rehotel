<template>
  <div class="board-container">
    <div class="page-header-container">
      <h1 class="page-header">{{ categoryTitle }}</h1>
    </div>
    <div class="boardDetail" style="width: 100%">
      <!-- 제목,분류,작성일 -->
      <div class="common-buttons">
        <button
          type="button"
          class="w3-button w3-white w3-border w3-hover-white"
          @click="boardUpdate(boardSn)"
        >
          수정
        </button>
        <button
          type="button"
          class="w3-button w3-white w3-border-red w3-border w3-text-red"
          @click="changeMod"
        >
          게시글 삭제
        </button>
      </div>
      <header class="w3-container w3-padding-32">
        <div class="topSpan">
          <span class="w3-left">[{{ boardCheck(boardCategory) }}]</span>
          <span>&nbsp; {{ boardTitle }}</span>
          <span class="w3-right">{{ formatDate(createdAt) }}</span>
        </div>
        <div class="bottomSpan">
          <span>작성자 : 관리자</span>
          <span class="w3-right">조회수 : {{ boardCnt }}</span>
        </div>
      </header>
      <!-- 작성자, 조회수 -->
      <nav class="w3-container"></nav>
      <!-- 첨부파일, 본문, 버튼 -->
      <div class="contents w3-padding-32 w3-container w3-border-bottom">
        <!-- 본문 및 버튼 -->
        <div
          id="viewer"
          ref="viewer"
          class="boardContent w3-padding-16 w3-container"
        ></div>

        <!-- <div class="boardContent w3-padding-16 w3-container">
        </div> -->
      </div>
      <!-- 댓글리스트 -->
      <div class="w3-container commentList" v-if="pageTitle != '공지사항'">
        <ul
          class="boardContentUl w3-padding-16 w3-container w3-border-bottom"
          v-for="(item, idx) in commentList"
          :key="idx"
        >
          <li v-if="!item.isEditing">
            <div class="replyInfo">
              <strong class="replyId" style="font-size: 16px">{{
                item.userId
              }}</strong>
              <span class="replyDay">{{ formatDate(item.createdAt) }}</span>
              <span class="buttonSub"
                ><button
                  class="w3-white content-button"
                  @click="fnModifyContent(item)"
                >
                  수정</button
                ><button class="content-button" @click="fnModifyDelete(item)">
                  삭제
                </button></span
              >
            </div>
            <p class="w3-margin-top">{{ item.content }}</p>
          </li>
          <li v-else>
            <div class="replyInfo">
              <strong class="replyId" style="font-size: 16px">{{
                item.userId
              }}</strong>
              <span class="replyDay">{{ formatDate(item.createdAt) }}</span>
              <span class="buttonSub"
                ><button
                  class="content-button w3-white"
                  @click="fnModifySave(item)"
                >
                  저장</button
                ><button class="content-button" @click="fnModifyCancel(item)">
                  취소
                </button></span
              >
            </div>
            <textarea
              v-model="item.editedContent"
              class="w3-input w3-border"
              style="resize: none"
            ></textarea>
          </li>
        </ul>
      </div>
      <!-- 댓글 -->
      <div
        class="w3-padding-32 w3-container w3-border-bottom"
        v-if="pageTitle != '공지사항'"
      >
        <string class="replyStrong">댓글 달기 check</string>
        <div class="w3-row-padding textBtn" style="display: flex">
          <div class="w3-col s11">
            <textarea
              class="w3-input w3-border"
              v-model="replyComment"
              style="resize: none"
              placeholder="로그인 후 입력해주세요"
            ></textarea>
          </div>
          <button
            class="w3-col s2 w3-right w3-indigo w3-hover-lightt-blue"
            type="submit"
            style="cursor: pointer"
            @click="fnComment"
          >
            작성하기
          </button>
        </div>
      </div>
      <!-- 목록버튼 -->
      <div class="w3-padding-32 w3-container">
        <div class="w3-container w3-center">
          <button
            class="w3-button w3-round w3-blue-gray"
            style="width: 20%"
            @click="$router.push({ path: '/admin/board' })"
          >
            목록
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
// import { Viewer } from "@toast-ui/editor"; // Viewer를 가져옵니다.
import Viewer from "@toast-ui/editor/dist/toastui-editor-viewer";
import "@toast-ui/editor/dist/toastui-editor-viewer.css"; // Viewer를 위한 CSS 파일을 가져옵니다.
const sessionId = sessionStorage.getItem("sessionId");

const serverUrl = "http://localhost:8081";
export default {
  data() {
    return {
      viewer: null,
      categoryTitle: "", // 페이지 제목
      categoryType: "", // 페이지 유형 ('inquiry' 또는 'notice')
      boardTitle: "",
      boardSn: null, // 게시물 번호
      createdAt: "",
      boardCategory: "",
      boardCnt: "",
      boardContent: "",
      role: "",
      commentList: [],
      commentList: sessionId,
    };
  },
  mounted() {
    this.boardSn = this.$route.params.boardSn;
    this.getDetail();
    this.fnCommentList();
  },
  methods: {
    getDetail(boardSn) {
      this.$axios
        .get(serverUrl + "/api/admin/board/detail/" + this.boardSn, {})
        .then((res) => {
          this.boardCategory = res.data.boardCategory;
          this.boardCnt = res.data.boardCnt;
          this.boardTitle = res.data.boardTitle;
          this.boardContent = res.data.boardContent;
          this.role = res.data.role;
          this.createdAt = res.data.createdAt;
          this.boardStatus = res.data.boardStatus;
          this.renderMarkdown(this.boardContent);
        })
        .catch(function (error) {
          alert("실패입니다.");
          console.log(error);
        });
    },
    renderMarkdown(content) {
      // Markdown을 HTML로 변환하는 로직을 여기에 추가하세요.
      // 예: 직접 구현하거나 다른 라이브러리 사용
      // 필요한 경우 이미지 처리 로직도 추가하세요.
      const viewer = new Viewer({
        el: this.$el.querySelector("#viewer"),
        initialValue: content,
        // plugins: [[codeSyntaxHighlight, { hljs }]],
      });
    },
    formatDate(dateTimeString) {
      return dateTimeString.slice(0, 10);
    },
    boardCheck(boardCategory) {
      if (boardCategory === "notice") {
        return "공지사항";
      } else if (boardCategory === "inquiry") {
        return "문의사항";
      } else return "FAQ";
    },
    boardUpdate(boardSn) {
      alert("boardSn은 : " + boardSn);
      // this.requestBody.boardSn = boardSn;
      this.$router.push({
        // query: this.requestBody,
        path: "/admin/board/update/" + boardSn,
      });
    },
    changeMod() {
      alert("삭제할꼬야?");
      var boardStatus = {
        boardSn: this.boardSn,
        boardStatus: this.boardStatus,
      };
      this.$axios
        .put(
          "http://localhost:8081/api/admin/board/detail/" + this.boardSn,
          boardStatus
        )
        .then((res) => {
          alert("글이 삭제되었습니다");
          this.$router.push({ path: "/admin/board" }); // 페이지 이동
        })
        .catch((error) => {
          console.log("에러닷!");
        });
    },
    fnComment() {
      var commentData = {
        content: this.replyComment,
        categoryType: this.pageType,
        userId: this.userId,
        boardSn: this.boardSn,
        id: this.id,
      };
      axios
        .post(
          "http://localhost:8081/api/" + this.pageType + "/" + this.boardSn,
          commentData
        )
        .then((res) => {
          alert("댓글 작성이 완료");
          location.reload();
        })
        .catch((err) => {
          console.log("에러닷", err);
        });
    },
    fnCommentList() {
      // const boardSn = this.boardSn;
      this.$axios
        .get(
          `http://localhost:8081/api/${this.pageType}/${this.boardSn}/comments`
        )
        .then((res) => {
          this.commentList = res.data;
        })
        .catch((error) => {
          console.error("댓글 목록 가져오기 에러:", error);
          // 댓글 목록을 가져오는데 실패했을 때의 동작 추가
        });
    },
    fnCommentUpdate() {},
    fnModifyContent(item) {
      item.isEditing = true;
      item.editedContent = item.content; // 수정할 내용을 textarea에 채움
    },
    fnModifyCancel(item) {
      item.isEditing = false;
    },
    fnModifySave(item) {
      var editedContent = item.editedContent;
      var editid = item.id;
      var comment = {
        content: editedContent,
        id: editid,
      };
      axios
        .put(
          "http://localhost:8081/api/update/" +
            this.pageType +
            "/" +
            this.boardSn,
          comment
        )
        .then((res) => {
          alert("댓글 수정완료");
          item.isEditing = false;
          location.reload();
        })
        .catch((err) => {
          console.log("에러닷", err);
        });
    },
    fnModifyDelete(item) {
      var editedContent = item.editedContent;
      var editid = item.id;
      var comment = {
        content: editedContent,
        id: editid,
        commentStatus: this.commentStatus,
      };
      axios
        .put(
          "http://localhost:8081/api/modiDelete/" +
            this.pageType +
            "/" +
            this.boardSn,
          comment
        )
        .then((res) => {
          alert("댓글 삭제완료");
          item.isEditing = false;
          location.reload();
        })
        .catch((err) => {
          console.log("에러닷", err);
        });
    },
  },
  created() {
    // 라우터를 통해 페이지 유형을 결정합니다.
    const categoryType = this.$route.params.categoryType;

    console.log(categoryType);

    // 페이지의 유형에 따라 페이지 제목과 게시판 리스트 출력 여부를 설정합니다.
    if (categoryType === "board") {
      this.categoryTitle = "게시판 관리";
      this.categoryType = "board";
    } else if (categoryType === "comments") {
      this.categoryTitle = "댓글 관리";
      this.categoryType = "comments";
    } else if (categoryType === "deletePost") {
      this.categoryTitle = "삭제된 글 관리";
      this.categoryType = "deletePost";
    }
  },
};
</script>
<style scoped>
.replyStrong {
  display: block;
  margin-bottom: 20px;
  margin-left: 15px;
}
.board-container {
  max-width: 1200px;
  margin: 0 auto;
  margin-bottom: 100px;
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
  width: 100px;
  height: 40px;
  margin-left: 8px;
  color: rgb(136, 136, 136);
  border: 1px solid rgb(221, 221, 221);
}

ul,
li {
  list-style: none;
}
.boardCover {
  margin: 0 auto;
}
.boardetail {
  margin: 0 auto;
  box-shadow: none;
}

.replyDay {
  font-size: 16px;
  margin-left: 8px;
}

.modifyDelete {
  font-size: 14px;
  margin-left: 8px;
  border-style: none;
  background-color: white;
}
.replyDay {
  font-size: 16px;
  margin-left: 8px;
}

.content-button {
  font-size: 14px;
  margin-left: 8px;
  border-style: none;
  background-color: white;
}
.boardContentUl:last-child {
  border-bottom: none !important; /* w3-border-bottom 스타일 제거 */
}
.commentList {
  border-bottom: 1px solid black;
}
header {
  background-color: rgb(247, 247, 247);
  color: rgb(33, 32, 30);
  border-top: 1px solid black;
  border-bottom: 1px solid rgb(221, 221, 221);
}
header .topSpan span {
  font-size: 22px;
}
header .bottomSpan span {
  font-size: 15px;
}
</style>
