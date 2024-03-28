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
                        <input type="checkbox" id="terms" v-model="agreedTerms">
                        <label for="terms">동의합니다.</label>
                    </div>
                </div>
                <div class="scrollable-content"><terms-content></terms-content></div>
                <div class="user">
                    <h4>개인정보처리방침 동의 <b>(필수)</b></h4>
                    <div>
                        <input type="checkbox" id="privacy" v-model="agreedPrivacy">
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
                        <input type="text" id="user-id" v-model="userId" required placeholder="아이디">
                        <button type="confirm" @click="checkDuplicate">중복확인</button>
                    </div>
                    <input type="password" id="user-pwd" v-model="userPwd" required placeholder="비밀번호">
                    <input type="password" id="password-confirm" v-model="passwordConfirm" required placeholder="비밀번호 확인">
                    <input type="text" id="user-name" v-model="userName" required placeholder="이름">
                    <div class="input-email">
                        <input type="email" id="user-email" v-model="userEmail" placeholder="이메일">
                        <button type="button" @click="sendVerificationCode" class="button-send-verification">인증번호 발송</button>
                    </div>
                    <input type="text" id="verification-code" name="verification-code"
                                    v-model="verificationCode"  placeholder="인증번호를 입력하세요."/>
                    <input type="text" id="user-tel" v-model="userTel" required placeholder="연락처">
                    <input type="text" id="user-addr" v-model="userAddr" required placeholder="주소">
                    <input type="date" id="user-birth" v-model="userBirth" required placeholder="생년월일">
                    <select id="user-gender" v-model="userGender" required>
                                <option value="">성별을 선택하세요</option>
                                <option value="m">남성</option>
                                <option value="f">여성</option>
                              </select>
                    <button type="submit" class="submit" @click.prevent="submitForm">회원가입</button>
                </form>
            </section>
        </div>
    </div>
</template>

<script>
    import termsContent from './termsContent.vue';
    import privacyPolicyContent from './privacyPolicyContent.vue';
    import axios from 'axios'
    const serverUrl = 'http://localhost:8081'

    export default {
        components: { termsContent, privacyPolicyContent },
        data() {
            return {
                agreedTerms: false,
                agreedPrivacy: false,
                userId: '',
                userPwd: '',
                passwordConfirm: '',
                userName: '',
                userEmail: '',
                verificationCode: '',
                userTel: '',
                userAddr: '',
                userBirth: '',
                userGender: ''
            }
        },
        methods: {
            updateUserPrivate() {
                // 이용약관과 개인정보처리방침에 모두 동의한 경우에만 userPrivate를 true로 설정
                if (this.agreedTerms && this.agreedPrivacy) {
                    this.userPrivate = true;
                }
            },

            checkDuplicate() {
                // 만약 사용자가 입력한 아이디가 비어있다면 중복 확인하지 않고 반환합니다.
                if (!this.userId) {
                    alert('아이디를 입력하세요.');
                    return;
                }

                // 서버로 보낼 데이터 객체 생성
                const requestData = {
                    userId: this.userId
                };

                // 서버로 중복 확인 요청을 보냅니다.
                axios.post(serverUrl + '/api/member/checkDuplicate', requestData)
                    .then(response => {
                        // 응답이 성공적으로 도착했을 때의 처리
                        if (response.data.isDuplicate) {
                            // 만약 중복된 아이디라면 알림을 표시합니다.
                            alert('이미 사용 중인 아이디입니다.');
                        } else {
                            // 중복되지 않은 아이디라면 알림을 표시합니다.
                            alert('사용 가능한 아이디입니다.');
                        }
                    })
                    .catch(error => {
                        // 요청이 실패했을 때의 처리
                        console.error('중복 확인 요청 실패:', error);
                        alert('중복 확인 요청에 실패했습니다.');
                    });
            },

           /*sendVerificationCode() {
                alert("인증번호가 발송되었습니다")
            },*/

         formatDate() {
                // 사용자가 선택한 날짜를 yyyy-MM-dd 형식으로 변환
                this.userBirth = new Date(this.userBirth).toISOString().split('T')[0];
            },

            submitForm: function () {
                    this.updateUserPrivate();
                    if (!this.agreedTerms || !this.agreedPrivacy) {
                        alert('약관 동의에 체크해주세요.')
                        return;
                    }
                    if (!this.userId || !this.userPwd || !this.passwordConfirm || !this.userName  || !this.userEmail || !this.verificationCode || !this.userTel || !this.userAddr || !this.userBirth || !this.userGender){
                        alert('고객정보를 입력해주세요.')
                        return;
                    } else if (this.userPwd !== this.passwordConfirm) {
                        alert('비밀번호가 일치하지 않습니다.')
                        return;
                    }
                        var postData = {
                            userId: this.userId,
                            userPwd: this.userPwd,
                            userName: this.userName,
                            userEmail: this.userEmail,
                            userTel: this.userTel,
                            userAddr: this.userAddr,
                            userBirth: this.userBirth,
                            userGender: this.userGender,
                            verificationCode: this.verificationCode,
                            passwordConfirm: this.passwordConfirm
                        }
                        alert(this.userName + '님의 회원가입을 시작합니다.');
                        axios.post(serverUrl + '/api/member/memberInsert', postData)
                            .then((response) => {
                                console.log(response);
                                alert('회원가입이 완료되었습니다.');
                                this.$router.push({
                                    path: '/login',
                                    name: 'login'  // 회원가입 후 로그인화면으로 이동
                                });
                            })
                            .catch((error) => {
                                alert('회원가입 실패');
                                console.log(error);
                            });
                }
            }
        }
</script>


<style scoped>
    *{
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
        font-weight: 400;
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
    input[type="text"], input[type="email"], input[type="password"], input[type="date"] {
        width: 100%;
        height: 50px;
        margin-bottom: 10px;
        padding: 0 20px;
        font-size: 14px;
        border: 1px solid #ccc;
    }

    #user-gender, #user-birth {
        width: 100%;
        height: 50px;
        margin-bottom: 10px;
        padding: 0 15px;
        font-size: 14px;
        border: 1px solid #ccc;
        color: #7e7e7e;
    }

    option {
        font-size: 14px;
        color: #555;
    }

    .input-id, .input-email {
        display: flex;
    }

    .input-id button, .input-email button {
        min-width: 110px;
        height: 50px;
        font-size: 14px;
        margin-left: 10px;
        cursor: pointer;
        border: 1px solid black;
        border-radius: 0;
        background-color: white;
    }

   .input-id button:hover,
   .input-email button:hover {
        background-color: black;
        color: white;
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