<template>
  <div class="board-container">
    <div class="page-header-container">
      <h1 class="page-header">{{ pageTitle }}</h1>
    </div>
    <div class="boardDetail" style="width: 100%">
      <!--제목,분류,작성일-->
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

      <!-- 첨부파일, 본문, 버튼 -->
      <div class="contents w3-padding-32 w3-container w3-border-bottom">
        <!-- 본문 및 버튼 -->
        <div
          id="viewer"
          ref="viewer"
          class="boardContent w3-padding-16 w3-container"
        ></div>
        <!-- <div class="common-buttons">  버튼이 커짐.-->
        <div class="buttons w3-right" v-if="pageTitle != '공지사항'">
          <button
            type="button"
            class="w3-button w3-round w3-white w3-text-black w3-border w3-wide w3-border-black w3-padding-large"
            @click.prevent="boardUpdate(boardSn)"
            v-if="isAuthor"
          >
            수정</button
          >&nbsp;
          <button
            type="button"
            class="w3-button w3-round w3-white w3-text-black w3-border w3-wide w3-border-black w3-padding-large"
            @click.prevent="changeMod"
            v-if="isAuthor"
          >
            삭제</button
          >&nbsp;
        </div>
      </div>
      <!--댓글리스트-->
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
        <string class="replyStrong">댓글 달기</string>
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
            @click.prevent="button1"
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
const serverUrl = "http://localhost:8081";
const sessionId = sessionStorage.getItem("sessionId");

export default {
  data() {
    return {
      pageTitle: "", // 페이지 제목
      pageType: "", // 페이지 유형 ('inquiry' 또는 'notice')
      viewer: null,
      boardTitle: "",
      boardSn: null, // 게시물 번호
      createdAt: "",
      boardCategory: "",
      boardCnt: "",
      boardContent: "",
      role: "",
      replyComment: "",
      board: "",
      userId: sessionId,
      commentList: [],
      editedContent: "",
      id: "", //댓글 id
      isAuthor: false, //현재계정과 글작성자 계정 비교
    };
  },
  created() {
    // 라우터를 통해 페이지 유형을 결정합니다.

    const pageType = this.$route.params.pageType;

    // 페이지의 유형에 따라 페이지 제목과 게시판 리스트 출력 여부를 설정.
    if (pageType === "notice") {
      this.pageTitle = "공지사항";
      this.pageType = "notice";
    } else if (pageType === "inquiry") {
      this.pageTitle = "문의하기";
      this.pageType = "inquiry";
    }
  },
  mounted() {
    this.boardSn = this.$route.params.boardSn;
    this.getDetail();
    this.fnCommentList();
  },

  methods: {
    formatDate(dateTimeString) {
      return dateTimeString.slice(0, 10);
    },
    getDetail(boardSn) {
      this.$axios
        .get("http://localhost:8081/api/" + this.pageType + "/" + this.boardSn)
        .then((res) => {
          this.boardCategory = res.data.boardCategory;
          this.boardCnt = res.data.boardCnt;
          this.boardTitle = res.data.boardTitle;
          this.boardContent = res.data.boardContent;
          this.role = res.data.role;
          this.createdAt = res.data.createdAt;
          this.boardStatus = res.data.boardStatus;
          this.isAuthor = res.data.member.userId === sessionId;
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
    boardCheck(boardCategory) {
      if (boardCategory === "notice") {
        return "공지사항";
      } else if (boardCategory === "inquiry") {
        return "문의사항";
      } else return "FAQ";
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
          this.$router.push({ path: "/inquiry" }); // 페이지 이동
        })
        .catch((error) => {
          console.log("에러닷!");
        });
    },
    button1() {
      this.$router.push({ path: "/inquiry" }); // 페이지 이동
    },
    boardUpdate(boardSn) {
      this.$router.push({
        path: "/inquiry/update/" + boardSn,
      });
    },
    fnComment() {
      if (sessionId != null) {
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
            console.log("data send::", res.commentData);
            alert("댓글 작성이 완료");
            location.reload();
          })
          .catch((err) => {
            console.log("에러닷", err);
          });
      } else alert("로그인 해주세요!");
    },
    fnCommentList() {
      const boardSn = this.boardSn;
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
    fnModifyContent(item) {
      let commentId = item.userId;
      if (sessionId === commentId) {
        item.isEditing = true;
        item.editedContent = item.content; // 수정할 내용을 textarea에 채움
      } else alert("너따위가 수정을 한다고?");
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
          console.log("data sent", res);
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
          console.log("data sent", res);
          alert("댓글 삭제완료");
          item.isEditing = false;
          location.reload();
        })
        .catch((err) => {
          console.log("에러닷", err);
        });
    },
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
