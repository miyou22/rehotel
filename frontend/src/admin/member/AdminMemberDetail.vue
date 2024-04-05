<template>
  <div class="board-container w3-margin-bottom">
    <div class="page-header-container">
      <h1 class="page-header">회원정보상세</h1>
    </div>

    <!-- 글작성 메뉴 -->
    <table class="w3-border-top w3-margin-top w3-border-black">
      <tbody>
        <tr>
          <th>회원 ID</th>
          <td>
            <input
              type="text"
              class="memberId"
              name="memberId"
              placeholder="나중에수정못하도록 input이 아닌 데이터값을 넣어야함."
              :value="SelectedMemItems.userId"
              readonly
            />
          </td>
        </tr>
        <tr>
          <th>회원이름</th>
          <td>
            <input
              type="text"
              class="memberName"
              name="memberName"
              v-model="userName"
            />
          </td>
        </tr>
        <tr>
          <th>비밀번호</th>
          <td>
            <input
              type="password"
              class="password"
              name="password"
              v-model="userPwd2"
            />
          </td>
        </tr>
        <tr>
          <th>비밀번호 확인</th>
          <td>
            <input
              type="password"
              class="passwordCheck"
              name="passwordCheck"
              v-model="passwordConfirm"
            />
          </td>
        </tr>
        <tr>
          <th>이메일</th>
          <td>
            <input
              type="email"
              class="email"
              name="email"
              v-model="userEmail"
            />
          </td>
        </tr>
        <tr>
          <th>연락처</th>
          <td>
            <input type="tel" class="tell" name="tell" v-model="formattedTel" />
          </td>
        </tr>
        <tr>
          <th>생일</th>
          <td>
            <input type="date" class="birth" name="birth" v-model="userBirth" />
          </td>
        </tr>
        <tr>
          <th>성별</th>
          <td>
            <select
              id="gender"
              name="gender"
              v-model="userGender"
              required
              class="select-gender"
            >
              <option value="" selected disabled hidden>성별 선택</option>
              <option value="m">남성</option>
              <option value="f">여성</option>
            </select>
          </td>
        </tr>
        <tr>
          <th>가입일</th>
          <td>
            <input
              type="text"
              class="join"
              name="join"
              required
              :value="formattedJoinDate"
              readonly
            />
          </td>
        </tr>
      </tbody>
    </table>
    <!-- 버튼 -->
    <div class="w3-container w3-center w3-margin-top">
      <button
        class="w3-button w3-round y w3-margin-bottom"
        style="width: 20%"
        @click="completeUpdate"
      >
        수정하기
      </button>
      <button
        class="w3-button w3-round w3-margin-bottom"
        style="width: 20%"
        @click="$router.push({ path: '/admin/member' })"
      >
        취소
      </button>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  data() {
    return {
      userId: "",
      userPwd: "",
      userPwd2: "",
      passwordConfirm: "",
      userName: "",
      userEmail: "",
      userTel: "",
      userAddr: "",
      userBirth: "",
      userGender: "",
      role: "",
    };
  },
  computed: {
    // Vuex 게터를 사용하여 선택된 예약 항목을 가져오기
    ...mapGetters(["getSelectedMemItems"]),
    SelectedMemItems() {
      return this.getSelectedMemItems;
    },
    formattedJoinDate() {
      const joinDate = new Date(this.SelectedMemItems.userJoin);
      return joinDate.toISOString().split("T")[0];
    },
    formattedTel() {
      const tel = this.SelectedMemItems.userTel;
      return tel ? "0" + tel : tel;
    },
  },
  methods: {
    getUserMember() {
      this.userId = this.SelectedMemItems.userId;
      var data = {
        userId: this.userId,
      };
      this.$axios
        .post("http://localhost:8081/api/member/memberUpdate", data)
        .then((res) => {
          console.log(res);
          this.userId = res.data.userId;
          this.userPwd = res.data.userPwd;
          this.userName = res.data.userName;
          this.userEmail = res.data.userEmail;
          this.userTel = res.data.userTel;
          this.userAddr = res.data.userAddr;
          this.userBirth = res.data.userBirth;
          this.userGender = res.data.userGender;
        })
        .catch((error) => {
          console.log(error);
        });
    },
    completeUpdate() {
      if (this.userPwd2) {
        var data = {
          userId: this.userId,
          userPwd: this.userPwd2,
          userName: this.userName,
          userEmail: this.userEmail,
          userTel: this.userTel,
          userAddr: this.userAddr,
          userBirth: this.userBirth,
          userGender: this.userGender,
          userFlag: 1,
        };
      } else {
        var data = {
          userId: this.userId,
          userPwd: this.userPwd,
          userName: this.userName,
          userEmail: this.userEmail,
          userTel: this.userTel,
          userAddr: this.userAddr,
          userBirth: this.userBirth,
          userGender: this.userGender,
        };
      }
      this.$axios
        .post("http://localhost:8081/api/member/memberUpdatePost", data)
        .then((res) => {
          alert("회원 정보 수정을 완료하였습니다");
          console.log(res);
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
  mounted() {
    this.getUserMember();
  },
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
  margin-top: 85px;
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
  /* background-image: url(../../../assets/img/dropdown.svg); */
  background-repeat: no-repeat;
  background-position: 95% center;
  background-size: 14px;
}
/* tab-item 과 dining 반응형 css와 겹침 */
</style>
