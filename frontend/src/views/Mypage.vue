<template>
  <main>
    <div class="wrap">
      <h1 class="header">마이페이지</h1>
      <div class="mypage-info">
        <h3>회원 정보 수정</h3>
        <form class="user-info">
          <div>
            <label for="username" class="label-username">아이디</label>
            <input type="text" id="username" name="username" required class="input-username" v-model="userId" />
          </div>
          <div>
            <label for="password" class="label-password">비밀번호</label>
            <input type="password" id="password" name="password" v-model="userPwd" required class="input-password" />
          </div>
          <div>
            <label for="confirm-password" class="label-confirm-password">비밀번호 확인</label>
            <input type="password" id="confirm-password" name="confirm-password" v-model="passwordConfirm" required
              class="input-confirm-password" />
          </div>
          <div>
            <label for="name" class="label-name">이름</label>
            <input type="text" id="username" name="name" v-model="userName" required class="input-name" />
          </div>
          <label for="email" class="label-email">이메일 주소</label>
          <div class="email-verify">
            <input type="email" id="useremail" name="useremail" v-model="userEmail" required class="input-email" />
            <button type="button" @click="sendVerificationCode" class="button-send-verification">인증번호 발송</button>
          </div>
          <div>
            <input type="text" id="verification-code" name="verification-code" required class="input-verification-code"
              placeholder="인증번호를 입력하세요." />
          </div>
          <div>
            <label for="tel" class="label-tel">연락처</label>
            <input type="text" id="usertel" name="usertel" v-model="userTel" required class="input-tel" />
          </div>
          <div>
            <label for="addr" class="label-addr">주소</label>
            <input type="text" id="useraddr" name="useraddr" v-model="userAddr" required class="input-addr" />
          </div>
          <div>
            <label for="birth" class="label-birth">생년월일</label>
            <input type="text" id="userbirth" name="birth" v-model="userBirth" required class="input-birth" />
          </div>
          <div>
            <label for="gender" class="label-gender">성별</label>
            <select id="gender" name="gender" v-model="userGender" required class="select-gender">
              <option value="" selected disabled hidden>성별 선택</option>
              <option value="male">남성</option>
              <option value="female">여성</option>
            </select>
          </div>
          <button type="submit" @click="completeUpdate" class="complete-button">회원 정보 수정</button>
        </form>
      </div>
    </div>
  </main>
</template>

<script>
export default {
  data() {
    return {
      userId: '',
      userPwd: '',
      passwordConfirm: '',
      userName: '',
      //userEmail: '',
      userTel: '',
      userAddr: '',
      userBirth: '',
      userGender: ''
    }
  },
  methods: {
    sendVerificationCode() {
      // 인증번호 발송 버튼 클릭 시 수행할 동작을 여기에 작성
      console.log("Verification code sent");
      alert("인증번호가 발송되었습니다")
    },
    completeUpdate() {
      //수정완료 버튼 클릭시 alert로 수정이 완료되었습니다 라는 문구생김
      alert("수정이 완료되었습니다")
    },
  }
};
</script>

<style scoped>
* {
  font-family: "Noto Sans KR", sans-serif;
}

.wrap {
  margin: auto;
  max-width: 1200px;
}

.header {
  font-size: 40px;
  font-weight: 500;
  margin-top: 85px;
  margin-bottom: 70px;
}

.mypage-info {
  padding: 0 250px;
  display: flex;
  flex-direction: column;
  justify-content: center;
}

.mypage-info h3 {
  margin-top: 0;
  margin-bottom: 30px;
  font-size: 24px;
  font-weight: 400;
}

.user-info {
  margin-bottom: 15px;
}

.email-verify {
  display: flex;
  flex-direction: row;
}

.label-username,
.label-email,
.label-password,
.label-confirm-password,
.label-name,
.label-tel,
.label-addr,
.label-birth,
.label-gender {
  display: block;
  margin-bottom: 10px;
  font-size: 16px;
  color: #444444
}

.input-username,
.input-email,
.input-verification-code,
.input-password,
.input-confirm-password,
.input-name,
.input-tel,
.input-addr,
.input-birth,
.select-gender {
  width: 100%;
  height: 50px;
  margin-bottom: 20px;
  padding: 0 20px;
  font-size: 14px;
  border: 1px solid #ccc;
}

.input-email {
  margin-bottom: 10px;
}

.input-verification-code {
  margin-top: 0;
}

.select-gender {
  text-align: start;
  color: #555555;
}

option {
  font-size: 14px
}

.button-send-verification {
  width: 130px;
  height: 50px;
  padding: 10px;
  margin-left: 10px;
  font-size: 14px;
  color: black;
  background-color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  border: none;
  border-radius: 0;
  /* 사각형 모양으로 만들기 */
  outline: 1px solid black;
}

.complete-button {
  width: 100%;
  margin-top: 20px;
  height: 50px;
  padding: 10px 20px;
  font-size: 15px;
  border: none;
  background-color: #d4af37;
  color: #fff;
  cursor: pointer;
}

.button-send-verification:hover {
  background-color: black;
  color: white;
}

.complete-button:hover {
  background-color: #c2a031;
}
</style>
