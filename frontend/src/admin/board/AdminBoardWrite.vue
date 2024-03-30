<template>
  <div class="board-container w3-margin-bottom">
    <div class="page-header-container">
      <h1 class="page-header">게시글 작성</h1>
    </div>

    <!-- 글작성 메뉴 -->
    <table class="w3-border-top w3-margin-top w3-border-black">
      <tbody>
        <tr>
          <th>게시판</th>
          <td>
            <select
              required
              v-model="selectValue"
              @change="change"
              class="selectCategory"
            >
              <option value="">선택</option>

              <option
                v-for="(option, idx) in options"
                :key="idx"
                :value="option"
              >
                {{ option.name }}
              </option>
            </select>
          </td>
        </tr>
        <!-- <tr>
          <th>카테고리</th>
          <td>
            <select required name="category" class="selectCategory">
              <option value>선택</option>
              <option value="칭찬">칭찬</option>
              <option value="문의">문의</option>
              <option value="제안">제안</option>
              <option value="기타">기타</option>
            </select>
          </td>
        </tr> -->
        <tr>
          <th>제목</th>
          <td>
            <input
              type="text"
              class="titleLong"
              v-model="title"
              required
              value
            />
          </td>
        </tr>
        <tr>
          <th>작성자</th>
          <td>
            <input
              type="text"
              class="boardWriter"
              v-model="writer"
              required
              value
            />
          </td>
        </tr>
      </tbody>
    </table>
    <!-- 글작성 에이터 -->
    <div id="editor" class="w3-border-bottom w3-border-black"></div>
    <button @click="saveContent">Save Content</button>

    <!-- 버튼 -->
    <div class="w3-container w3-center w3-margin-top">
      <button
        type="submit"
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
import { Editor } from "@toast-ui/editor";
import "@toast-ui/editor/dist/toastui-editor.css";
import axios from "axios";
let result;

export default {
  data() {
    return {
      editor: null,
      pageTitle: "", // 페이지 제목
      pageType: "", // 페이지 유형 ('inquiry' 또는 'notice')
      selectValue: "",
      options: [
        { name: "공지사항", value: "notice" },
        { name: "문의사항", value: "inquiry" },
        { name: "FAQ", value: "faq" },
      ],
      category: "",
      title: "",
      createdAt: "",
      boardContent: "",
      content: "",
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
    change() {
      const category = this.selectValue.value;
      console.log(category);
    },
    fnSave() {
      var boardData = {
        boardCategory: this.selectValue.value,
        boardTitle: this.title,
        createdAt: this.createdAt,
        boardContent: this.content,
        boardContent: this.editor.getHTML(),
      };
      console.log(boardData);
      axios
        .post("http://localhost:8081/api/admin/board/write", boardData)
        .then((res) => {
          console.log("data sent", res.boardData);
          alert("글작성이 완료되었습니다");
          this.$router.push({ path: "/admin/board" }); // 페이지 이동
        })
        .catch((error) => {
          console.log("에러닷!");
        });
    },
    saveContent() {
      this.content = this.editor.getHTML(); // 에디터의 HTML 내용을 가져와 변수에 할당
      console.log("Saved content:", this.content);
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
  width: 60%;
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
  background-image: url(../../assets/img/dropdown.svg);
  background-repeat: no-repeat;
  background-position: 95% center;
  background-size: 14px;
}
/* tab-item 과 dining 반응형 css와 겹침 */
</style>
