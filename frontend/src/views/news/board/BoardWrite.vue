<template>
  <div class="board-container w3-margin-bottom">
    <div class="page-header-container">
      <h1 class="page-header">{{ pageTitle }}</h1>
    </div>

    <!-- 글작성 메뉴 -->
    <table class="w3-border-top w3-margin-top w3-border-black">
      <tbody>
        <tr>
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
        </tr>
        <tr>
          <th>제목</th>
          <td>
            <input type="text" class="titleLong" name="title" required value />
          </td>
        </tr>
        <tr>
          <th>작성자</th>
          <td>
            <input
              type="text"
              class="boardWriter"
              name="boardWriter"
              required
              value
            />
          </td>
        </tr>
        <tr>
          <th>비밀번호</th>
          <td>
            <input
              type="password"
              class="boardPass"
              name="boardPassword"
              required
              value
            />
          </td>
        </tr>
      </tbody>
    </table>
    <!-- 글작성 에이터 -->
    <div id="editor" class="w3-border-bottom w3-border-black"></div>
    <!-- 버튼 -->
    <div class="w3-container w3-center w3-margin-top">
      <button class="w3-button w3-round y w3-margin-bottom" style="width: 20%">
        작성하기
      </button>
      <button
        class="w3-button w3-round w3-margin-bottom"
        style="width: 20%"
        @click="$router.push({ path: '/' + pageType })"
      >
        취소
      </button>
    </div>
  </div>
</template>

<script>
import Editor from "@toast-ui/editor";
import "@toast-ui/editor/dist/toastui-editor.css";

export default {
  data() {
    return {
      editor: null,
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
  mounted() {
    this.editor = new Editor({
      el: document.querySelector("#editor"),
      height: "400px",
      initialEditType: "wysiwyg",
      previewStyle: "vertical",
    });
  },
  methods: {},
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
  background-image: url(../../../assets/img/dropdown.svg);
  background-repeat: no-repeat;
  background-position: 95% center;
  background-size: 14px;
}
/* tab-item 과 dining 반응형 css와 겹침 */
</style>
