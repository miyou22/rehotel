<template>
    <div class="wrap">
        <h2 class="subtitle">비밀번호 찾기</h2>
        <h4 class="reset">비밀번호를 재설정해주세요.</h4>
        <p class="input-text">새로 사용하실 비밀번호를 입력해주세요.</p>
        <div class="content">
          <form @submit.prevent="submitNewPassword">
            <input type="password" v-model="newPassword" placeholder="새 비밀번호">
            <input type="password" v-model="confirmPassword" placeholder="비밀번호 확인">
            <button type="submit" class="submit" :style="{ backgroundColor: canSubmit ? '#d4af37' : '#ddd' }" :disabled="!canSubmit">비밀번호 변경</button>
          </form>
        </div>
    </div>
</template>

<script>
import axios from 'axios'
import store from "@/store";
const serverUrl = 'http://localhost:8081'
export default {
  data() {
    return {
      newPassword: '',
      confirmPassword: '',
    };
  },
 // mounted()  {
 //   alert( userId )
 // },
  computed: {
    canSubmit() {
      return this.newPassword !== '' && this.newPassword === this.confirmPassword;      // 둘 다 비어있지 않고 두 값이 서로 일치하면 true를 반환. true면 버튼의 색을 #d4af37
    }
  },
  methods: {
    submitNewPassword() {
      if (this.canSubmit) {
        axios.post(serverUrl + '/api/member/newPw', {
                   userId: store.state.userId,  // 비밀번호 찾기 폼에 입력한 아이디를 저장한 스토어의 아이디 값을 가져옴
                   newPassword: this.newPassword
        })
          .then(response => {
            alert('비밀번호가 성공적으로 변경되었습니다.');
            // 비밀번호 변경 후 로그인 페이지로 이동
            this.$router.push('/login');
          })
          .catch(error => {
            console.error(error);
            alert('비밀번호 변경에 실패했습니다. 다시 시도해주세요.');
          });
      } else {
        alert('새 비밀번호와 비밀번호 확인이 일치하지 않습니다.');
      }
    }
  }
};
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
    color: #fff;
    border: 1px solid #eee;
    cursor: pointer;
}

</style>