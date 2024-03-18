<template>
  <div class="wrap">
    <section class="page-header-container">
        <h1 class="header">회원가입</h1>
    </section>
    <div class="content">
        <section class="agreement">
            <h2 class="agree">약관 동의</h2>
            <div class="user">
                <h4>이용약관 동의 <b>(필수)</b></h4>
                <div>
                    <input type="checkbox" id="terms">
                    <label for="terms">동의합니다.</label>
                </div>
            </div>
            <div class="user">
                <h4>개인정보처리방침 동의 <b>(필수)</b></h4>
                <div>
                    <input type="checkbox" id="privacy">
                    <label for="privacy">동의합니다.</label>
                </div>
            </div>
        </section>
        <section class="join-form">
            <h2 class="input">회원정보 입력</h2>
            <form>
                <div class="input-id">
                    <input type="text" id="userid" name="userid" required placeholder="아이디">
                    <button type="confirm">중복확인</button>
                </div>
                <input type="password" id="password" name="password" required placeholder="비밀번호">
                <input type="password" id="password-confirm" name="password-confirm" required placeholder="비밀번호 확인">
                <input type="text" id="username" name="username" required placeholder="이름">
                <input type="email" id="useremail" name="useremail" required placeholder="이메일">
                <input type="text" id="tel" name="tel" required placeholder="연락처">
                <input type="text" id="birth" name="birth" placeholder="생년월일">
                <input type="text" id="gender" name="gender" placeholder="성별">
                <button type="submit" class="submit">회원가입</button>
            </form>
        </section>
    </div>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>
    .wrap {
        max-width: 1200px;
        margin: auto;
    }

    .header {
        font-size: 40px;
        font-weight: bold;
    }
    .content {
        display: flex;
        justify-content: center;
        height: 100vh;
    }

    .agreement, .join-form {
        flex: 1;
        padding: 20px;
    }

    .user {
        display: flex;
        justify-content: space-between;
    }

    .user h4 {
        font-size: 14px;
        font-weight: 500;
    }

    .user b {
        color: #ee0000;
        font-size: 14px;
    }

    label {
        font-size: 14px;
    }

    .agree, .input {
        font-size: 20px;
        font-weight: 500;
        margin-bottom: 30px;
    }

    form {
        display: flex;
        flex-direction: column;
      }

    input[type="text"], input[type="email"], input[type="password"] {
        width: 100%;
        margin-bottom: 10px;
        padding: 10px;
        font-size: 15px;
        border: 1px solid #ccc;
    }

    .input-id {
        display: flex;
    }

    .input-id button {
        min-width: 110px;
        height: 38px;
        font-size: 15px;
        margin-left: 10px;
        cursor: pointer;
        border: 1px solid black;
        border-radius: 0;
        background-color: white;
    }

    .submit {
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