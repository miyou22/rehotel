<template>
  <div class="board-container">
    <div class="page-header-container">
      <h1 class="page-header">{{ pageTitle }}</h1>
    </div>
    <div class="boardDetail" style="width: 100%">
      <!--제목,분류,작성일-->
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
        <span class="w3-right">조회수 : {{ boardCnt }}</span>
      </nav>
      <!-- 첨부파일, 본문, 버튼 -->
      <div
        class="contents w3-padding-32 w3-container w3-margin-bottom w3-border-bottom"
      >
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
          >
            수정</button
          >&nbsp;
          <button
            type="button"
            class="w3-button w3-round w3-white w3-text-black w3-border w3-wide w3-border-black w3-padding-large"
            @click.prevent="changeMod"
          >
            삭제</button
          >&nbsp;
          <button
            type="button"
            class="w3-button w3-round w3-white w3-text-black w3-border w3-border-black w3-wide w3-padding-large"
            @click.prevent="button1"
          >
            목록
          </button>
        </div>
      </div>
      <!-- 댓글 -->
      <div
        class="w3-padding-32 w3-container w3-border-bottom"
        v-if="pageTitle != '공지사항'"
      >
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
      <!--댓글리스트-->
      <div
        class="w3-padding-32 w3-container w3 w3-border-bottom"
        v-if="pageTitle != '공지사항'"
      >
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
            @click="$router.push({ path: '/' + pageType })"
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
      pageTitle: "", // 페이지 제목
      pageType: "", // 페이지 유형 ('inquiry' 또는 'notice')
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
  mounted() {
    this.boardSn = this.$route.params.boardSn;
    this.getDetail();
  },
  methods: {
    formatDate(dateTimeString) {
      return dateTimeString.slice(0, 10);
    },
    getDetail(boardSn) {
      alert("getList 넘버 : " + this.boardSn);
      this.$axios
        .get(
          "http://localhost:8081/api/" + this.pageType + "/" + this.boardSn,
          {
            // params: this.requestBody,
          }
        )
        .then((res) => {
          console.log(res);
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
      console.log(boardStatus);
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
      alert("boardSn은 : " + boardSn);
      alert("boardSn은 : " + this.pageType);
      this.$router.push({
        path: "/inquiry/update/" + boardSn,
      });
    },
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
