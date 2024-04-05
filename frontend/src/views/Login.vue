<template>
  <div class="wrap">
    <section class="page-header-container">
      <h1 class="header">로그인</h1>
    </section>
    <section class="content-container">
      <div class="login-container">
        <div class="tabs">
          <button
            :class="{ active: activeTab === 'member' }"
            @click="activeTab = 'member'"
          >
            회원
          </button>
          <button
            :class="{ active: activeTab === 'non-member' }"
            @click="activeTab = 'non-member'"
          >
            비회원(예약확인)
          </button>
        </div>
        <div v-if="activeTab === 'member'" class="tab-content">
          <form @submit.prevent="login">
            <div class="form-group">
              <input
                type="text"
                id="user-id"
                v-model="userId"
                required
                placeholder="아이디"
              />
            </div>
            <div class="form-group">
              <input
                type="password"
                id="user-pwd"
                v-model="userPwd"
                required
                placeholder="비밀번호"
              />
            </div>
            <button type="submit" class="submit" @click.prevent="login">
              로그인
            </button>
            <div class="forgot-password">
              <a href="/findidpw">아이디/비밀번호 찾기</a>
            </div>
          </form>
        </div>
        <div v-else class="tab-content">
          <form @submit.prevent="checkReservation">
            <div class="form-group">
              <input
                type="text"
                id="reservation-id"
                v-model="resId"
                required
                placeholder="예약번호"
              />
            </div>
            <div class="form-group">
              <input
                type="email"
                id="user-email"
                v-model="userEmail"
                required
                placeholder="이메일"
              />
            </div>
            <button
              type="submit"
              class="submit"
              @click.prevent="checkReservation"
            >
              예약 확인
            </button>
          </form>
        </div>
      </div>
      <div class="vertical-line"></div>
      <!--세로 선 추가-->
      <div class="signup-link">
        <div class="text">
          <h1>아직 회원이 아니신가요?</h1>
          <p>
            저희 킹스호텔 회원이 되시면 예약조회를 포함한<br />
            다양한 사이트 이용이 가능합니다 !
          </p>
        </div>
        <a href="/joinmember">회원가입</a>
      </div>
    </section>
  </div>
</template>

<script>
import axios from "axios";
import store from "@/store";
const serverUrl = "http://localhost:8081";

export default {
  data() {
    return {
      activeTab: "member",
      userId: "",
      userPwd: "",
      resId: "",
      userEmail: "",
    };
  },
  methods: {
    login: function () {
        store.commit('setLoggedIn', true);
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
          if (response.status === 200 && response.data === this.userId) {
            alert(response.data + "님 환영합니다! ");
            store.commit("setAccount", response.data); // store에 로그인 정보를 저장
            console.log("Store => " + store.state.userId);
            console.log(response);
            sessionStorage.setItem("sessionId", response.data); // 세션스토리지에도 저장
            console.log("세션생성 ==> " + sessionStorage.sessionId);
            console.log("현재 세션 :", sessionStorage.getItem("sessionId"));

            this.$router.push({
              path: "/",
              name: "home", // 로그인 후 홈화면으로 이동
            });
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
    checkReservation: function () {
      if (!this.resId || !this.userEmail) {
        alert("예약번호와 이메일을 확인해주세요.");
        return;
      }
      // 예약번호를 Vuex store에 저장하는 mutation 호출
      this.$store.commit("setReservationId", this.resId);
      this.$store.commit("setReservationEmail", this.userEmail);


      // 예약 확인 후 페이지 이동
            this.$router.push("/checklist");
    },
  },
};
</script>

<style scoped>
* {
  font-family: "Noto Sans KR", sans-serif;
}
.wrap {
  max-width: 1200px;
  margin: auto;
  margin-bottom: 96px;
}

.header {
  font-size: 40px;
  font-weight: 500;
  margin-top: 85px;
}

.content-container {
  height: 280px;
  display: flex;
  justify-content: center;
}

.vertical-line {
  border-left: 1px solid #a8a8a8;
}

.login-container,
.signup-link {
  flex: 1;
  padding: 0px 80px;
}

.tabs {
  display: flex;
  justify-content: center;
  margin-bottom: 20px;
}

.tabs button {
  font-size: 15px;
  font-weight: 400;
  color: #616161;
  width: 100%;
  height: 60px;
  background-color: transparent;
  cursor: pointer;
  border: none;
}

.tabs button.active {
  color: #d4af37;
  border: 1px solid #d4af37;
  border-bottom: none;
}

.tabs button:not(.active) {
  border: 1px solid #ccc;
  border-bottom: 1px solid #d4af37;
  background-color: #f4f4f4;
}

form {
  max-width: 500px;
  display: flex;
  flex-direction: column;
  justify-content: center;
}

input[type="text"],
input[type="email"],
input[type="password"] {
  width: 100%;
  height: 50px;
  margin-bottom: 10px;
  padding: 0 20px;
  font-size: 15px;
  border: 1px solid #ccc;
}

.submit {
  margin-top: 10px;
  height: 50px;
  padding: 10px 20px;
  font-size: 15px;
  border: none;
  background-color: #d4af37;
  color: #fff;
  cursor: pointer;
}
.submit:hover {
  background-color: #c2a031;
}

a {
  text-decoration: none;
  color: #555;
}

.forgot-password {
  text-align: end;
}

.forgot-password a {
  font-size: 14px;
}

.signup-link {
  margin: auto;
}

.text h1 {
  color: #d4af37;
  font-size: 25px;
  margin-bottom: 18px;
}

.text p {
  color: #555;
  font-size: 16px;
  margin-bottom: 70px;
}

.signup-link a {
  border: 1px solid #d4af37;
  height: 50px;
  padding: 10px 30px;
  font-size: 15px;
  color: #d4af37;
  cursor: pointer;
}

.signup-link a:hover {
  color: white;
  background-color: #d4af37;
}
</style>
