<template>
    <div class="wrap">
        <section class="page-header-container">
            <h1 class="header">로그인</h1>
        </section>
        <div class="content">
            <section class="login-container">
                <div class="tabs">
                    <button :class="{ active: activeTab === 'member' }" @click="activeTab = 'member'">회원</button>
                    <button :class="{ active: activeTab === 'non-member' }" @click="activeTab = 'non-member'">비회원(예약확인)</button>
                </div>
                <div v-if="activeTab === 'member'" class="tab-content">
                    <form @submit.prevent="login">
                    <div class="form-group">
                        <input type="text" id="userid" v-model="userid" required placeholder="아이디">
                    </div>
                    <div class="form-group">
                        <input type="password" id="password" v-model="password" required placeholder="비밀번호">
                    </div>
                    <button type="submit" class="submit">로그인</button>
                    <div class="forgot-password">
                        <a href="#">아이디/비밀번호 찾기</a>
                    </div>
                    </form>
                </div>
                <div v-else class="tab-content">
                    <form @submit.prevent="checkReservation">
                    <div class="form-group">
                        <input type="text" id="reservation-number" v-model="reservationNumber" required placeholder="예약번호">
                    </div>
                    <div class="form-group">
                        <input type="email" id="udseremail" v-model="email" required placeholder="이메일">
                    </div>
                    <button type="submit" class="submit">예약 확인</button>
                    </form>
                </div>
            </section>
            <div class="vertical-line"></div> <!--세로 선 추가-->
            <section class="signup-link">
                <div class="text">
                   <h1>아직 회원이 아니신가요?</h1>
                   <p>저희 킹스호텔 회원이 되시면 예약조회를 포함한<br/> 다양한 사이트 이용이 가능합니다 !</p>
                </div>
                <a href="/joinmember">회원가입</a>
            </section>
        </div>
    </div>
</template>

<script>
export default {
    data() {
    return {
      activeTab: 'member',
      userid: '',
      password: '',
      reservationNumber: '',
      useremail: '',
    };
  },
  methods: {
    login() {
      // 로그인 로직
    },
    checkReservation() {
      // 예약 확인 로직
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
        font-size: 40px;
        font-weight: 500;
        margin-top: 85px;
    }

    .content {
        height: 280px;
        display: flex;
        justify-content: center;
    }

    .vertical-line {
        border-left: 1px solid #a8a8a8;
    }

    .login-container, .signup-link {
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

    input[type="text"], input[type="email"], input[type="password"] {
        width: 100%;
        height: 50px;
        margin-bottom: 10px;
        padding: 0 20px;
        font-size: 15px;
        border: 1px solid #ccc;
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

    a {
        text-decoration: none;
        color: #555;
    }

    .forgot-password {
        text-align: end;
    }

    .forgot-password  a {
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
        margin-bottom: 50px;
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