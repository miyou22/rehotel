<template>
  <main>
    <div class="container">
      <h2>마이페이지</h2>

      <p>회원 정보 수정</p>
      <form>
        <div>
          <label for="username" class="label-username">아이디:</label>
          <input type="text" id="username" name="username" required class="input-username" />
        </div>
        <div>
          <label for="email" class="label-email">이메일 주소:</label>
          <input type="email" id="useremail" name="useremail" required class="input-email" />
          <button type="button" @click="sendVerificationCode" class="button-send-verification">인증번호 발송</button>
        </div>
        <div>
          <label for="verification-code" class="label-verification-code">인증번호:</label>
          <input type="text" id="verification-code" name="verification-code" required class="input-verification-code" />
        </div>
        <div>
          <label for="password" class="label-password">비밀번호:</label>
          <input type="password" id="password" name="password" required class="input-password" />
        </div>
        <div>
          <label for="confirm-password" class="label-confirm-password">비밀번호 확인:</label>
          <input
            type="password"
            id="confirm-password"
            name="confirm-password"
            required
            class="input-confirm-password"
          />
        </div>
        <div>
          <label for="name" class="label-name">이름:</label>
          <input type="text" id="username" name="name" required class="input-name" />
        </div>
        <div>
          <label for="gender" class="label-gender">성별:</label>
          <select id="gender" name="gender" required class="select-gender">
            <option value="">성별 선택</option>
            <option value="male">남성</option>
            <option value="female">여성</option>
            <option value="other">기타</option>
          </select>
        </div>

        <div class="button-container">
          <button type="button" class="complete-button">수정 완료</button>
        </div>
      </form>

    </div>
  </main>
</template>

<script>
export default {
  methods: {
    sendVerificationCode() {
      // 인증번호 발송 버튼 클릭 시 수행할 동작을 여기에 작성
      console.log("Verification code sent");
    }
  }
};
</script>

<style scoped>
.container {
  max-width: 1200px;
  padding: 1.5rem 0.5rem;
}
form {
  margin: 0 auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  background-color: #f9f9f9;
}

div {
  margin-bottom: 15px;
}

.label-username,
.label-email,
.label-verification-code,
.label-password,
.label-confirm-password,
.label-name,
.label-gender {
  display: block;
  margin-bottom: 5px;
  font-size: 16px; /* 라벨 폰트 크기 설정 */
}

.input-username,
.input-email,
.input-verification-code,
.input-password,
.input-confirm-password,
.input-name,
.select-gender {
  width: calc(100% - 135px); /* 버튼 폭과 여백만큼 감소 */
  padding: 8px;
  font-size: 16px; /* 인풋 폰트 크기 설정 */
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box; /* 입력 내용의 크기가 패딩 및 테두리 포함될 수 있도록 함 */
}

.button-container {
  display: flex;
  justify-content: flex-end;
}

.button-send-verification,
.complete-button {
  width: 120px; /* 버튼의 고정된 너비 */
  padding: 10px;
  margin-left: 10px;
  font-size: 14px;
  color: black;
  background-color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  border: none;
  border-radius: 0; /* 사각형 모양으로 만들기 */
  outline: 1px solid black;
}

.complete-button {

  width: 120px; /* 버튼의 고정된 너비 */
  padding: 10px;
  margin-left: 10px;
  font-size: 14px;
  color: black;
  background-color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  border-radius: 0; /* 사각형 모양으로 만들기 */
  outline: 1px solid black;
}

.button-send-verification:hover,
.complete-button:hover {
  background-color: #d4af37;
}

.complete-button:hover {
  background-color: #d4af37; /* 수정 완료 버튼 hover 색상 */
}

</style>
