<template>
  <main>
    <!-- Top Text -->
    <div class="container-check">
      <div class="page-header-container">
        <h2 class="page-header">예약 목록</h2>
      </div>
      <!-- Board -->
      <div class="board-list">
        <table class="w3-table w3-bordered w3-hoverable w3-margin-bottom">
          <colgroup>
            <col width="110px" />
            <col width="180px" />
            <col width="auto" />
            <col width="180px" />
          </colgroup>
          <thead>
            <tr class="w3-light-grey w3-border-top w3-border-black">
              <th class="w3-center" style="width: 110px">번호</th>
              <th class="w3-center" style="width: 220px">예약번호</th>
              <th class="w3-center" style="width: 280px">객실명</th>
              <th class="w3-center" style="width: 140px">체크인</th>
              <th class="w3-center" style="width: 140px">체크아웃</th>
              <th class="w3-center" style="width: 140px">예약날짜</th>
              <th class="w3-center" style="width: 150px">결제금액</th>
              <th class="w3-center" style="width: 140px">예약 취소</th>

            </tr>
          </thead>
          <tbody>
            <tr v-for="(item, index) in filteredList" :key="index">
              <template v-if="item.userId === userId || (item.resId === reservationId && item.userEmail === reservationEmail)">
                <td class="w3-center">{{ index + 1 }}</td>
                <td
                  class="w3-center detail"
                  :class="{ 'cancelled-reservation': item.payCheck === 0 }"
                  @click="saveSelectedItems(item)"
                >
                  <span v-if="item.isCancelled">{{ item.resId }}</span>
                  <span v-else>{{ item.resId }}</span>
                </td>
                <td class="w3-center room">{{ item.roomName }}</td>
                <td class="w3-center">{{ item.resCheckin.split("T")[0] }}</td>
                <td class="w3-center">{{ item.resCheckout.split("T")[0] }}</td>
                <td class="w3-center">{{ item.resDate.split("T")[0] }}</td>
                <td class="w3-center">
                  {{ numberWithCommas(item.roomPrice) }}
                </td>
                <td class="w3-center">
                  <button class="return" @click="checkRe(item.resId)">취소</button>
                </td>
              </template>

            </tr>
          </tbody>
        </table>
      </div>

      <!-- Pagination -->
      <div class="w3-bar pagin">
        <a href="#" class="w3-button w3-hover-purple circle">«</a>
        <a href="#" class="w3-button w3-hover-green">1</a>

        <a href="#" class="w3-button w3-hover-orange circle">»</a>
      </div>
    </div>
  </main>
</template>

<script>
import axios from "axios";
import {mapActions, mapState} from "vuex";
export default {
  data() {
    return {
      resList: [],
    };
  },
  mounted() {
    this.getResList();
  },
  methods: {

    saveSelectedItems(item) {
      this.setSelectedResItems(item); // Vuex 액션 호출
      this.$router.push("/checkDetail");
    },
    ...mapActions(["setSelectedResItems"]),
    numberWithCommas(x) {
      return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },


    checkRe(resId) {
      if (confirm("삭제하시겠습니까?") == true) {
        //true는 확인버튼을 눌렀을 때 코드 작성
        const selectedIds = [resId]
        axios
          .post(
            "http://localhost:8081/api/reservation/updatePayCheck",
            selectedIds
          )
          .then((response) => {
            if (response.status === 200) {
              alert("선택된 예약의 결제 상태가 취소로 변경되었습니다.");
              // 변경된 상태를 다시 불러옵니다.
              this.getResList();
            } else {
              alert("예약 취소에 실패했습니다.");
            }
          })
          .catch((error) => {
            console.error("예약 취소에 실패했습니다.", error);
          });
        alert("예약 취소되었습니다");
      } else {
        return;
      }
    },
    getResList() {
      // alert("getresList 시작.....")
      this.$axios
        .get("http://localhost:8081/api/reservation/resInfo")
        .then((res) => {
          this.resList = res.data;
          // alert('getData() 수신데이터 ==> ' + res.data)
          console.log(res.data);
        })
        .catch((error) => {
          console.log(error);
        })
        .finally(() => {
          console.log("항상 마지막에 실행");
        });
    },
  },
  computed: {
    filteredList() {
      if (this.userId) {
        return this.resList.filter(item => item.userId === this.userId ||
            (item.resId === this.reservationId && item.userEmail === this.reservationEmail));
      } else {
        // 비회원인 경우 reservationId와 reservationEmail이 일치하는 예약 정보만 필터링
        return this.resList.filter(item => item.resId ===
            parseInt(this.reservationId) && item.userEmail === this.reservationEmail);
      }
    },

    ...mapState(["userId"]),
    ...mapState(["reservationId"]),
    ...mapState(["reservationEmail"]),
  },
};
</script>

<style scoped>
* {
  font-family: "Noto Sans KR", sans-serif;
}
.detail:hover {
  color: #d4af37;
  cursor: pointer;
}
.cancelled-reservation {
  text-decoration: line-through;
}
.container-check {
  width: 1200px;
  margin: auto;
}
.common-buttons {
  text-align: right;
  font-size: 15px;
}
.common-buttons button {
  padding: 15px 75px;
}
.pagin {
  text-align: center;
}
.room {
  vertical-align: middle;
  font-size: 16px;
  font-weight: bold;
}
.return {
  border-radius: 10px;
  width: 50px;
  padding: 5px;
  font-size: 14px;
  border: none;
  background-color: #d4af37;
  cursor: pointer;
  color: white;
}
.return:hover {
  background-color: #e0ba3a;
  color: black;
}
.circle {
  width: 24px;
  border: 1px solid black;
  /* border: 1px solid rgb(186, 160, 133); */
  /* color: rgb(156, 131, 106); */
  color: black;
  border-radius: 100%;
  padding: 0 7px;
  height: 24px;
  line-height: 20px;
}
.page-header {
  text-align: center;
  margin-top: 85px;
  margin-bottom: 80px;
  font-weight: 500;
  font-size: 36px;
}
</style>

