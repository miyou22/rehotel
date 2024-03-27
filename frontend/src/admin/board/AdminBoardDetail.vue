<template>
  <div class="board-container w3-border-top">
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
      <header class="w3-container w3-blue w3-padding-32">
        <span class="w3-left">[{{ boardCheck(boardCategory) }}]</span>
        <span>&nbsp; {{ boardTitle }}</span>
        <span class="w3-right">{{ formatDate(createdAt) }}</span>
      </header>
      <!-- 작성자, 조회수 -->
      <nav
        class="w3-container w3-green w3-padding-16 w3-border-bottom w3-border-black"
      >
        <span>작성자들어감</span>
        <span class="w3-right">{{ boardCnt }}</span>
      </nav>
      <!-- 첨부파일, 본문, 버튼 -->
      <div
        class="contents w3-padding-32 w3-container w3-margin-bottom w3-border-bottom"
      >
        <!-- 첨부파일 -->
        <div class="filename w3-padding-16 w3-container">
          <!-- 첨부파일아이콘과 첨부파일 -->
        </div>
        <!-- 본문 및 버튼 -->
        <div
          id="viewer"
          ref="viewer"
          class="boardContent w3-padding-16 w3-container"
          initialValue="boardContent"
        >
          <!-- {{ boardContent }} -->
        </div>

        <!-- <div class="boardContent w3-padding-16 w3-container">
        </div> -->
      </div>
      <!-- 댓글 -->
      <div class="w3-padding-32 w3-container w3-border-bottom">
        <div class="w3-row-padding">
          <div class="w3-col s3">
            <input
              class="w3-input w3-border"
              type="text"
              placeholder="작성자명"
            />
          </div>
          <div class="w3-col s3">
            <input
              class="w3-input w3-border w3-margin-bottom"
              type="text"
              placeholder="비밀번호"
            />
          </div>
        </div>
        <div class="w3-row-padding textBtn" style="display: flex">
          <div class="w3-col s11">
            <textarea
              class="w3-input w3-border"
              style="resize: none"
            ></textarea>
          </div>
          <button
            class="w3-col s2 w3-right w3-indigo w3-hover-lightt-blue"
            type="submit"
            style="cursor: pointer"
          >
            작성하기
          </button>
        </div>
      </div>
      <!-- 댓글리스트 -->
      <div class="w3-padding-32 w3-container w3 w3-border-bottom">
        <ul class="boardContent w3-padding-16 w3-container">
          <li>
            <div class="replyInfo">
              <strong class="replyId" style="font-size: 16px">testid</strong>
              <span class="replyDay">2024/03/18</span>
              <span class="buttonSub"
                ><button class="w3-white modifyDelete">수정</button
                ><button class="modifyDelete">삭제</button
                ><button class="modifyDelete">신고</button></span
              >
            </div>
            <p class="w3-margin-top">리플내용이 담김</p>
          </li>
        </ul>
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

const serverUrl = "http://localhost:8081";
export default {
  data() {
    return {
      viewer: null,
      categoryTitle: "", // 페이지 제목
      categoryType: "", // 페이지 유형 ('inquiry' 또는 'notice')
      // requestBody: this.$route.query,
      boardTitle: "",
      boardSn: null, // 게시물 번호
      createdAt: "",
      boardCategory: "",
      boardCnt: "",
      boardContent: "",
      role: "",
    };
  },
  mounted() {
    this.boardSn = this.$route.params.boardSn;
    this.getDetail();
    const viewer = new Viewer({
      el: this.$refs.viewer, // 이 부분을 수정했습니다.
      // initialValue: this.boardContent, // 초기 내용을 설정합니다.
    });
  },
  methods: {
    getDetail(boardSn) {
      alert("getList 넘버 : " + this.boardSn);
      this.$axios
        .get(serverUrl + "/api/admin/board/detail/" + this.boardSn, {
          // params: this.requestBody,
        })
        .then((res) => {
          console.log(res);
          this.boardCategory = res.data.boardCategory;
          this.boardCnt = res.data.boardCnt;
          this.boardTitle = res.data.boardTitle;
          this.boardContent = res.data.boardContent;
          this.role = res.data.role;
          this.createdAt = res.data.createdAt;
          this.boardStatus = res.data.boardStatus;
        })
        .catch(function (error) {
          alert("실패입니다.");
          console.log(error);
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
        boardCategory: this.boardCategory,
        boardCnt: this.boardCnt,
        boardTitle: this.boardTitle,
        boardContent: this.boardContent,
        role: this.role,
        createdAt: this.createdAt,
        boardStatus: this.boardStatus,
      };
      console.log(boardStatus);
      this.$axios
        .put(
          "http://localhost:8081/api/admin/board/detail/" + this.boardSn,
          boardStatus
        )
        .then((res) => {
          console.log("data sent", res.boardData);
          alert("글작성이 완료되었습니다");
          this.$router.push({ path: "/admin/board" }); // 페이지 이동
        })
        .catch((error) => {
          console.log("에러닷!");
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
</style>
