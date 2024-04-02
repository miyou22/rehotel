<template>
    <div class="wrap">
        <h2 class="subtitle">비밀번호 찾기</h2>
        <h4 class="reset">비밀번호를 재설정해주세요.</h4>
        <p class="input-text">새로 사용하실 비밀번호를 입력해주세요.</p>
        <div class="content">
            <form>
                <input type="password" id="user-pwd" v-model="userPwd" required placeholder="비밀번호">
                <input type="password" id="password-confirm" v-model="passwordConfirm" required placeholder="비밀번호 확인">
                <button type="submit" class="submit" @click.prevent="submitForm">비밀번호 변경</button>
            </form>
        </div>
    </div>
</template>

<script>
export default {}
   
</script>

<style scope>
.wrap {
    font-family: "Noto Sans KR", sans-serif;
    max-width: 1200px;
    margin: auto;
    margin-bottom: 96px;
}
.subtitle {
    font-family: "Noto Sans KR", sans-serif;
    font-size: 36px;
    font-weight: 500;
    margin-top: 85px;
    margin-bottom: 60px;
}
.reset {
    font-family: "Noto Sans KR", sans-serif;
    margin: 20px 0;
    text-align: center;
    font-size: 24px; 
    color: #d4af37;
}
.input-text {
    text-align: center;
    font-size: 18px;
    margin-bottom: 50px;
    color: #7e7e7e;
}
.content {
    display: flex;
    justify-content: center;
    align-items: center;
  }
form {
    width: 100%;
    max-width: 440px;
    display: flex;
    flex-direction: column;
    justify-content: center;
}
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
</style>