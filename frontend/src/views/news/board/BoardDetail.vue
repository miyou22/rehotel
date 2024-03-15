<template>
  <div class="container">
    <div class="page-header-container">
      <h2 class="page-header">문의하기</h2>
      <hr />
    </div>
    <div class="w3-card-4 boardDetail" style="width: 100%">
      <!--제목,분류,작성일-->
      <header class="w3-container w3-blue w3-padding-32">
        <span class="w3-left">[분류들어감]</span>
        <span>&nbsp; 제목들어감</span>
        <span class="w3-right">2024.03.15 11:59</span>
      </header>
      <!-- 작성자, 조회수 -->
      <nav
        class="w3-container w3-green w3-padding-16 w3-border-bottom w3-border-black"
      >
        <span>작성자들어감</span>
        <span class="w3-right">조회수들어감</span>
      </nav>
      <!-- 첨부파일, 본문, 버튼 -->
      <div
        class="contents w3-padding-32 w3-container w3-margin-bottom w3-border-bottom w3-border-black"
      >
        <!-- 첨부파일 -->
        <div class="filename w3-padding-16 w3-container">
          첨부파일아이콘과 첨부파일
        </div>
        <!-- 본문 및 버튼 -->
        <div class="boardContent w3-padding-16 w3-container">본문이 들어감</div>

        <!-- <div class="common-buttons">  버튼이 커짐.-->
        <div class="buttons w3-right">
          <button
            type="button"
            class="w3-button w3-round w3-white w3-text-black w3-border w3-wide w3-border-black w3-padding-large"
          >
            수정</button
          >&nbsp;
          <button
            type="button"
            class="w3-button w3-round w3-white w3-text-black w3-border w3-wide w3-border-black w3-padding-large"
          >
            삭제</button
          >&nbsp;
          <button
            type="button"
            class="w3-button w3-round w3-white w3-text-black w3-border w3-border-black w3-wide w3-padding-large"
          >
            목록
          </button>
        </div>
      </div>
      <!-- 댓글 -->
      <div class="w3-padding-32 w3-container w3-border-bottom w3-border-black">
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
              class="w3-input w3-border"
              type="text"
              placeholder="비밀번호"
            />
          </div>
          <div class="w3-col s9">
            <textarea
              class="w3-input w3-border"
              style="resize: none"
            ></textarea>
          </div>
          <button class="w3-col s2 w3-right">눌러줭</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>
<style scoped></style>
