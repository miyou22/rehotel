<template>
  <div class="container-full">
    <h1>사이트맵</h1>
    <div class="content">
      
      <div class="text">
        <h3 class="name">
          킹스호텔 소개
        </h3>
        <div class="under-line"></div>
        <ul>
          <li><a href="/about">호텔 소개</a></li>
          <li><a href="/location">오시는 길</a></li>
        </ul>
      </div>


      <div class="text">
      
        <h3 class="name">
          시설 소개
        </h3>
        <div class="under-line"></div>
        <ul>
          <li><a href="/accommodation">객실</a></li>
          <li><a href="/facility">부대시설</a></li>
          <li><a href="/banquethall">연회장</a></li>
        </ul>
      </div>


      <div class="text">
      
        <h3 class="name">
          예약
        </h3>
          <div class="under-line"></div>
        <ul>
          <li><a href="/checklist">예약확인</a></li>
        </ul>
      </div>

    </div>

    <div class="content">
      <div class="text">
      
        <h3 class="name">
          고객지원
        </h3>
        <div class="under-line"></div>
        <ul>
          <li><a href="/notice">공지사항</a></li>
          <li><a href="/">문의하기</a></li>
          <li><a href="/">이용후기</a></li>
        </ul>
      </div>

      <div class="text">
      
        <h3 class="name">
          마이페이지
        </h3>
        <div class="under-line"></div>
        <ul>
          <li><a href="/login">로그인</a></li>
          <li><a href="/joinmember">회원가입</a></li>
        </ul>
      </div>

      <div class="text">
      
        <h3 class="name">
          약관 안내
        </h3>
        <div class="under-line"></div>
        <ul>
          <li><a href="/">이용약관</a></li>
          <li><a href="/">개인정보처리방침</a></li>
        </ul>
      </div>
      </div>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>
*{
    font-family: "Noto Sans KR", sans-serif;
}

.container-full {
  margin-bottom: 96px;
}

.container-full h1{
  margin: 85px 0 60px 0;
  text-align: center;
  font-weight: 500;
}
.content {
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 1200px;
  margin: auto;
  margin-bottom: 30px;
}
.text{
  width: 300px;
  height: 200px;
}
.name {
  font-size: 20px;
  font-weight: 400;
  color: #d4af37;
  margin-bottom: 12px;
}
.text li {
  list-style: none;
  margin-top: 4px;
  color: #777;
}
.text li a{
  text-decoration: none;
  font-size: 18px;
}
.under-line{
  width: 200px;
  margin-bottom: 20px;
  border-bottom: 1px solid #ddd;
}

</style>