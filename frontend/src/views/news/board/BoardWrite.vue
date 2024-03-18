<template>
  <div class="container">
    <table>
      <tbody>
        <tr>
          <th></th>
          <td>
            <select required>
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
    <div id="editor"></div>
  </div>
</template>

<script>
import Editor from "@toast-ui/editor";
import "@toast-ui/editor/dist/toastui-editor.css";

export default {
  data() {
    return {
      editor: null,
    };
  },
  mounted() {
    this.editor = new Editor({
      el: document.querySelector("#editor"),
      height: "200px",
      initialEditType: "wysiwyg",
      previewStyle: "vertical",
    });
  },
  methods: {},
};
</script>

<style scoped>
#editor {
  width: 80%;
  font-size: 4px !important;
}
/* tab-item 과 dining 반응형 css와 겹침 */
</style>
