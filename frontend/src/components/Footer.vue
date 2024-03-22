<template>
  <footer>
    <div class="footer-top">
      <div class="top-left">
        <p>COSTOMER CENTER</p>
        <div class="top-tell">
          객실예약 031-123-4567 &nbsp;&nbsp;&nbsp;&nbsp;문의하기 031-1234-5678
        </div>
        <div class="top-sub">
          FAX 031-123-4567
        </div>
      </div>
      <div class="top-right">
        <p>SOCIAL</p>
        <img src="../assets/img/instagram.svg" alt="">
        <img src="../assets/img/twitter.svg" alt="">
        <img src="../assets/img/facebook.svg" alt="">
      </div>
    </div>
    <hr />
    <div class="footer-bottom">
      <div class="left bottom">
        <li><a href="#">호텔소개</a></li>
        <li><a href="#">이용약관</a></li>
        <li><a href="#">(주)그린컴푸터 아카데미 경기 안산시 단원구 중앙대로 921, 동서코아빌딩/ 3층 </a></li>
      </div>
      <div class="middle bottom">
        <li><a href="#">오시는길</a></li>
        <li><a href="#">개인정보 처리방침</a></li>
        <li><a href="#">통신판매업신고번호 : 제2019-성남분당B-0224호대표이사(팀장) : 이동규대표번호 : 031-600-8586이메일 : contact@goorm.io</a></li>
      </div>
      <div class="right bottom">
        <li><a href="#">문의하기</a></li>
        <li><a href="#">사이트맵</a></li>
        <li><a href="#">Copyright © 1조(연지훈, 박강영, 전대섭,권지윤). All rights reserved. </a></li>
      </div>
    </div>


  </footer>
</template>

<script>
export default {};
</script>

<style scoped>
@import "../assets/css/Footer.css";

footer {
  width: 100%;
  height: 370px;
  background-color: black;
  color: white;
  padding-top: 60px;
}

.footer-top {
  max-width: 1200px;
  height: 140px;
  display: flex;
  justify-content: space-between;
  margin: auto;
}

.top-left {
  width: 450px;
}
.top-left p{
  margin-bottom:20px ;
  color: #d4af37;

}

.top-right {
  width: 370px;
}
.top-right p{
  margin-bottom:20px ;
  color: #d4af37;
}
.top-right img{
  margin-right: 20px;
  width: 30px;
}
.footer-bottom {
  max-width: 1200px;
  margin: auto;
  
}
.bottom{
  display: flex;
list-style: none;

}
@media (max-width: 1400px) {
.bottom a{
  font-size: 14px;
}
	}
  @media (min-width: 1400px) {
.bottom a{
  font-size: 14px;
}
	}


.bottom a{
text-decoration-line: none;
}
.bottom li:first-child{
  width: 100px;
}
.bottom li:nth-child(2){
width: 200px;
}

.bottom li:nth-child(3){
width: 900px;
}
</style>
