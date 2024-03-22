<template>
  <div class="container-full">
    <h1>사이트맵</h1>
    <div class="content">
      
      <div class="text">
        <h3 class="name">
          구름호텔소개
          <div class="hr"></div>
        </h3>
        <ul>
          <li><a href="/">호텔소개</a></li>
          <li><a href="/">오시는길</a></li>
        </ul>
      </div>


      <div class="text">
      
        <h3 class="name">
          시설소개
          <div class="hr"></div>

        </h3>
        <ul>
          <li><a href="/">객실</a></li>
          <li><a href="/">부대시설</a></li>
          <li><a href="/">연회장</a></li>
        </ul>
      </div>


      <div class="text">
      
        <h3 class="name">
          예약
          <div class="hr"></div>

        </h3>
        <ul>
          <li><a href="/">예약</a></li>
        </ul>
      </div>

    </div>

    <div class="content">
      <div class="text">
      
        <h3 class="name">
          고객지원
          <div class="hr"></div>

        </h3>
        <ul>
          <li><a href="/">공지사항</a></li>
          <li><a href="/">문의하기</a></li>
          <li><a href="/">이용후기</a></li>
        </ul>
      </div>

      <div class="text">
      
        <h3 class="name">
          마이페이지
          <div class="hr"></div>

        </h3>
        <ul>
          <li><a href="/">로그인</a></li>
          <li><a href="/">회원가입</a></li>
        </ul>
      </div>

      <div class="text">
      
        <h3 class="name">
          약관안내
          <div class="hr"></div>

        </h3>
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
.container-full h1{
  margin: 85px 0 50px 0;
  text-align: center;
  font-weight: bold;
}
.content {
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 1200px;
  margin: auto;
}
.text{
  width: 300px;
  height: 200px;
}
.name {
  font-weight: 100;
  color: #d4af37;
}
.text li {
  list-style: none;
  color: rgb(136, 136, 136);
  font-size: 14px;
}
.text li a{
  text-decoration: none;
}
.hr{
  width: 200px;
  outline: 1px solid rgb(216, 212, 212);
}

</style>