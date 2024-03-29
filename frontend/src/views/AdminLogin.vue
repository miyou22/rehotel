<template>
  <main>
    <div class="wrap">
      <h2 class="tit">관리자 로그인</h2>
      <form>
        <input type="text" placeholder="아이디" />
        <input type="password" placeholder="비밀번호" />
      </form>
      <div class="btn-wrap">
        <!--버튼을 누르면 관리자로-->
        <button>로그인</button>
      </div>
      <div class="bottom">
        <a href="/">사용자 홈 바로가기</a>
        <p>ID : ~~~ / PW : ~~~</p>
      </div>
    </div>
  </main>
</template>

<style scoped>
* {
  font-family: "Noto Sans KR", sans-serif;
}
.bottom {
  line-height: 1.6;
  padding: 20px;
  margin-top: 20px;
  color: rgb(136, 136, 136);
  text-align: center;
}
.bottom P {
  font-size: 16px;
}
.bottom a {
  font-size: 16px;
  display: inline-block;
  margin-bottom: 20px;
  color: rgb(156, 131, 106);
  text-decoration: underline;
}
button {
  margin-top: 10px;
  height: 50px;
  padding: 10px 20px;
  font-size: 15px;
  border: none;
  background-color: #d4af37;
  color: #fff;
  cursor: pointer;
  width: 100%;
}
button:hover {
  background-color: #c2a031;
}
.btn-wrap {
  margin-top: 20px;
}
.wrap {
  width: 400px;

  margin: 0px auto;
  padding: 140px 40px 0px;
}
.tit {
  color: rgb(17, 17, 17);
  font-weight: 500;
  font-size: 32px;
  margin-bottom: 40px;
  text-align: center;
}
form {
  margin-bottom: 10px;
}
input {
  border: 1px solid rgb(221, 221, 221);
  padding: 0px 8px;
  font-style: inherit;
  font-variant: inherit;
  font-weight: inherit;
  font-stretch: inherit;
  line-height: inherit;
  font-family: inherit;
  font-optical-sizing: inherit;
  font-kerning: inherit;
  font-feature-settings: inherit;
  font-variation-settings: inherit;
  font-size: 15px;
}
form input {
  width: 100%;
  height: 50px;
  margin-top: 10px;
  padding-left: 12px;
}
</style>
