<template>
  <main>
    <div class="wrap">
      <h2 class="tit">관리자 로그인</h2>
      <form>
        <input type="text" placeholder="아이디" v-model="userId" />
        <input type="password" placeholder="비밀번호" v-model="userPwd" />
      </form>
      <div class="btn-wrap">
        <!--버튼을 누르면 관리자로-->
        <button @click="login">로그인</button>
      </div>
      <div class="bottom">
        <a href="/">사용자 홈 바로가기</a>
        <p>ID : admin / PW : admin1234</p>
      </div>
    </div>
  </main>
</template>
<script>
import axios from "axios";
const serverUrl = "http://localhost:8081";
import store from "@/store";
export default {
  data() {
    return {
      userId: "",
      userPwd: "",
    };
  },
  methods: {
    login: function () {
      if (!this.userId || !this.userPwd) {
        alert("아이디와 비밀번호가 일치하지 않습니다.");
        return;
      }
      var data = {
        userId: this.userId,
        userPwd: this.userPwd,
      };

      // alert('로그인을 시작합니다!!!' + data.userId)
      axios
        .post(serverUrl + "/api/member/login", data)
        .then((response) => {
          if (
            response.status === 200 &&
            response.data === this.userId &&
            response.data === "admin"
          ) {
            alert(response.data + "님 환영합니다! ");
            store.commit("setAccount", response.data); // store에 로그인 정보를 저장
            console.log("Store => " + store.state.userId);
            console.log(response);
            sessionStorage.setItem("sessionId", response.data); // 세션스토리지에도 저장
            console.log("세션생성 ==> " + sessionStorage.sessionId);
            console.log("현재 세션 :", sessionStorage.getItem("sessionId"));

            this.$router.push("/admin");
          } else if (response.status === 401) {
            alert("아이디나 비밀번호가 맞지 않습니다.");
          } else if (response.status === 404) {
            alert("해당 아이디의 회원을 찾을 수 없습니다.");
          } else {
            alert("로그인에 실패하였습니다.");
          }
        })
        .catch(function (error) {
          console.log(error);
          alert("로그인에 실패하였습니다.");
        });
    },

    getResList() {
      // alert("getresList 시작.....")
      this.$axios
        .get("http://localhost:8081/api/member/memInfo")
        .then((res) => {
          this.resList = res.data.filter((item) => item.role === "ADMIN");
          // alert('getData() 수신데이터 ==> ' + res.data)
          console.log(res.data);
        })
        .catch((error) => {
          console.log(error);
        })
        .finally(() => {
          console.log("항상 마지막에 실행");
        });
    },
  },
  mounted() {
    this.getResList();
  },
};
</script>
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
