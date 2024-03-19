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
                <div class="scrollable-content"><terms-content></terms-content></div>
                <div class="user">
                    <h4>개인정보처리방침 동의 <b>(필수)</b></h4>
                    <div>
                        <input type="checkbox" id="privacy">
                        <label for="privacy">동의합니다.</label>
                    </div>
                </div>
                <div class="scrollable-content"><privacy-policy-content></privacy-policy-content></div>
            </section>
            <div class="vertical-line"></div> <!--세로 선 추가-->
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
    import termsContent from './termsContent.vue';
    import privacyPolicyContent from './privacyPolicyContent.vue';

    export default {
        components:{termsContent, privacyPolicyContent},
    }
</script>

<style scoped>
    .wrap {
        font-family: "Noto Sans KR", sans-serif;
        max-width: 1200px;
        margin: auto;
        margin-bottom: 96px;
    }

    .header {
        font-size: 40px;
        font-weight: bold;
    }
    .content {
        display: flex;
        justify-content: center;
    }

    .agreement, .join-form {
        flex: 1;
        padding: 0px 80px;
    }

    .vertical-line {
        border-left: 1px solid #a8a8a8;
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
    color: #555555;
    }

    /* checkbox꾸미기 */
    input[type="checkbox"] {
    position: relative;
    top: 4px;
    left: -6px;
    width: 16px;
    height: 16px;
    -webkit-appearance: none;
    outline: none;
    transition: 0.5s;
    }

    input[type="checkbox"]:before {
    content: "";
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    border: 1px solid #a8a8a8;
    box-sizing: border-box;
    transition: 0.5s;
    }

    input:checked[type="checkbox"]:before {
    border-left: none;
    border-top: none;
    width: 10px;
    border-color: rgb(0, 67, 192);
    transform: rotate(45deg) translate(0px, -5px);
    }

    label {
    font-size: 14px;
    }

    .agree, .input {
        font-size: 20px;
        font-weight: 500;
        margin-bottom: 30px;
    }

    .scrollable-content {
        border: 1px solid #c7c7c7;
        font-size: 14px;
        color: #7e7e7e;
        background-color: #f0f0f0;
        padding: 20px;
        margin: 10px 0 30px 0;
        max-height: 200px; /* 내용이 너무 많으면 스크롤바 생성 */
        overflow-y: auto; /* 세로 스크롤바 표시 */
    }


    form {
        display: flex;
        flex-direction: column;
    }

    /*input란 디자인 수정*/
    input[type="text"], input[type="email"], input[type="password"] {
        width: 100%;
        height: 50px;
        margin-bottom: 10px;
        padding: 0 20px;
        font-size: 14px;
        border: 1px solid #ccc;
    }

    .input-id {
        display: flex;
    }

    .input-id button {
        min-width: 110px;
        height: 50px;
        font-size: 14px;
        margin-left: 10px;
        cursor: pointer;
        border: 1px solid black;
        border-radius: 0;
        background-color: white;
    }

    .submit {
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