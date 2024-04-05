<template v-if="fnLogin(sessionId)">
  <div class="board-container w3-margin-bottom">
    <div class="page-header-container">
      <h1 class="page-header">문의사항</h1>
    </div>

    <!-- 글작성 메뉴 -->
    <table class="w3-border-top w3-margin-top w3-border-black">
      <tbody>
        <tr>
          <th>제목</th>
          <td>
            <input
              type="text"
              class="titleLong"
              name="title"
              v-model="title"
              required
              value
            />
          </td>
        </tr>
        <!-- <tr>
          <th>작성자</th>
          <td>
            <input type="text" class="boardWriter" required value />
          </td>
        </tr> -->
      </tbody>
    </table>
    <!-- 글작성 에이터 -->
    <div id="editor" class="w3-border-bottom w3-border-black"></div>
    <!-- 버튼 -->
    <div class="w3-container w3-center w3-margin-top">
      <button
        class="w3-button w3-round y w3-margin-bottom"
        style="width: 20%"
        @click.prevent="fnSave"
      >
        작성하기
      </button>
      <button
        class="w3-button w3-round w3-margin-bottom"
        style="width: 20%"
        @click.prevent="$router.push({ path: '/' + pageType })"
      >
        취소
      </button>
    </div>
  </div>
</template>

<script>
import Editor from "@toast-ui/editor";
import "@toast-ui/editor/dist/toastui-editor.css";
import axios from "axios";
let result;

export default {
  data() {
    return {
      editor: null,
      pageTitle: "", // 페이지 제목
      pageType: "", // 페이지 유형 ('inquiry' 또는 'notice')
      category: "",
      title: "",
      createdAt: "",
      boardContent: "",
      content: "",
      userId: "",
    };
  },
  created() {
    const pageType = "inquiry";
  },
  mounted() {
    this.fnLogin();
    this.editor = new Editor({
      el: document.querySelector("#editor"),
      height: "400px",
      initialEditType: "wysiwyg",
      previewStyle: "vertical",
      hooks: {
        addImageBlobHook: async (blob, callback) => {
          // 1. 다른 서버에 이미지를 업로드
          const uploadResult = await this.uploadImage(blob);
          // 2. 1에서 업로드 된 이미지를 접근할 수 있는 url 세팅
          callback(uploadResult.imageAccessUrl);
          console.log("blob:::", blob);
          console.log("callback:::", callback);
        },
      },
    });
  },
  methods: {
    async uploadImage(blob) {
      const formData = new FormData();
      formData.append("image", blob);

      const options = {
        method: "POST",
        body: formData,
      };

      let response = await fetch(
        "http://localhost:8081/api/admin/board/write/upload",
        options
      );
      result = await response.json();
      console.log("result::::", result);

      return result;
    },
    fnSave() {
      const sessionId = sessionStorage.getItem("sessionId");

      var boardData = {
        boardTitle: this.title,
        createdAt: this.createdAt,
        boardCategory: "inquiry",
        boardContent: this.editor.getHTML(),
        boardCnt: 0,
        userId: sessionId, // 백엔드로부터 받은 userId 사용
      };

      axios
        .post("http://localhost:8081/api/admin/board/write", boardData)
        .then((res) => {
          console.log("data sent", res.boardData);
          alert("글작성이 완료되었습니다");
          this.$router.push({ path: "/inquiry" }); // 페이지 이동
        })
        .catch((error) => {
          console.log("에러닷!");
        });
    },
    saveContent() {
      this.content = this.editor.getHTML(); // 에디터의 HTML 내용을 가져와 변수에 할당
    },
    fnLogin() {
      // 세션 스토리지에서 데이터 가져오기
      const sessionId = sessionStorage.getItem("sessionId");
      console.log(sessionId);
      // 데이터가 없는 경우 경고창 표시
      if (!sessionId) {
        alert("로그인 후 이용가능합니다.");
        this.$router.push({ path: "/login" });
      } else {
        // 데이터가 있는 경우 페이지 이동
        this.$router.push({ path: "/inquiry/write" });
      }
    },
  },
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
  width: 100%;
  height: 40px;
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
  background-image: url(../../../assets/img/dropdown.svg);
  background-repeat: no-repeat;
  background-position: 95% center;
  background-size: 14px;
}
/* tab-item 과 dining 반응형 css와 겹침 */
</style>
