<template>
  <div class="wrap">
    <section class="page-header-container">
      <h1 class="header">아이디/비밀번호 찾기</h1>
    </section>
    <section class="content-container">
      <div class="find-id">
        <h2 class="subtitle">아이디 찾기</h2>
        <form @submit.prevent="findId">
          <div class="form-group">
            <input
              type="text"
              id="findIdUsername"
              v-model="findIdUsername"
              required
              placeholder="이름"
            />
          </div>
          <div class="form-group">
            <input
              type="email"
              id="findIdUseremail"
              v-model="findIdUseremail"
              required
              placeholder="이메일"
            />
          </div>
          <button type="submit" class="submit" @click.prevent="findId">
            아이디 찾기
          </button>
        </form>
      </div>
      <div class="vertical-line"></div>
      <!--세로 선 추가-->
      <div class="find-pw">
        <h2 class="subtitle">비밀번호 찾기</h2>
        <form @submit.prevent="findPw">
          <div class="form-group">
            <input
              type="text"
              id="findPwUserid"
              v-model="findPwUserid"
              required
              placeholder="아이디"
            />
          </div>
          <div class="form-group">
            <input
              type="text"
              id="findPwUsername"
              v-model="findPwUsername"
              required
              placeholder="이름"
            />
          </div>
          <div class="form-group">
            <input
              type="email"
              id="findPwUseremail"
              v-model="findPwUseremail"
              required
              placeholder="이메일"
            />
          </div>
          <button type="submit" class="submit" @click.prevent="findPw">
            비밀번호 찾기
          </button>
        </form>
      </div>
    </section>
  </div>
</template>

<script>
import axios from "axios";
const serverUrl = "http://localhost:8081";
import store from "@/store";
export default {
  data() {
    return {
      findIdUsername: "",
      findIdUseremail: "",
      findPwUserid: "",
      findPwUsername: "",
      findPwUseremail: "",
    };
  },
  methods: {
    findId: function () {
      if (!this.findIdUsername) {
        alert("이름을 입력해주세요.");
        return;
      }
      if (!this.findIdUseremail) {
        alert("이메일을 입력해주세요.");
        return;
      }
      axios
        .post(serverUrl + "/api/member/find-id", {
          userName: this.findIdUsername,
          userEmail: this.findIdUseremail,
        })
        .then((response) => {
          alert(`찾으시는 아이디는 ${response.data} 입니다.`);
        })
        .catch((error) => {
          console.error(error);
          alert("아이디를 찾을 수 없습니다.");
        });
    },
    findPw: function () {
      if (!this.findPwUserid || !this.findPwUsername || !this.findPwUseremail) {
        alert("아이디, 이름, 이메일을 모두 입력해주세요");
        return;
      }

      axios
        .post(serverUrl + "/api/member/find-pw", {
          userId: this.findPwUserid,
          userName: this.findPwUsername,
          userEmail: this.findPwUseremail,
        })
        .then((response) => {
          // 서버에서 응답을 받으면 비밀번호 변경 페이지로 이동
          if (response.data === "success") {
            console.log("비밀번호 변경으로 이동");
            store.commit("setUserId", this.findPwUserid); // 입력한 아이디를 스토어에 저장
            console.log("$store.state.userId", this.$store.state.userId);
            this.$router.push("/findpw"); // 비밀번호 변경 페이지로 이동
          } else {
            alert("입력한 정보와 일치하는 회원이 없습니다.");
          }
        })
        .catch((error) => {
          console.error(error);
          alert("비밀번호를 찾을 수 없습니다.");
        });
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
  font-size: 36px;
  font-weight: 500;
  margin-top: 85px;
}

.content-container {
  display: flex;
  justify-content: center;
}

.vertical-line {
  border-left: 1px solid #a8a8a8;
}

.find-id,
.find-pw {
  flex: 1;
  padding: 0px 80px;
}

.subtitle {
  font-size: 18px;
  font-weight: normal;
  margin-bottom: 25px;
}

form {
  max-width: 500px;
  display: flex;
  flex-direction: column;
  justify-content: center;
}

input[type="text"],
input[type="email"] {
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
</style>
