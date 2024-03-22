<template>
  <!-- Top Text -->
  <div class="board-container">
    <div class="page-header-container">
      <h1 class="page-header">예약목록</h1>
    </div>
    <!--체크박스 삽입 할까 말까?-->
    <!-- 게시글관리 -->
    <div class="allBoard">
      <!-- Board -->
      <div class="board-list">
        <div class="common-buttons">
          <button
            type="button"
            class="w3-button w3-white w3-border-red w3-border w3-text-red"
            @click="itemchange"
          >
            선택예약 취소
          </button>
        </div>
        <table class="w3-table w3-bordered w3-hoverable w3-margin-bottom">
          <colgroup>
            <col width="80px" />
            <col width="100px" />
            <col width="200px" />
            <col width="200px" />
            <col width="auto" />
            <col width="150PX" />
            <col width="100PX" />
            <col width="50PX" />
          </colgroup>
          <thead>
            <tr class="w3-light-grey w3-border-top w3-border-black">
              <th class="w3-center">
                <input
                  type="checkbox"
                  id="selectAll"
                  @change="selectAllItems($event.target.checked)"
                />
              </th>
              <th class="w3-center">번호</th>
              <th class="w3-center">예약번호</th>
              <th class="w3-center">예약자명(회원ID)</th>
              <th class="w3-center">체크인</th>
              <th class="w3-center">체크아웃</th>
              <th class="w3-center">체크예약일</th>
              <th class="w3-center">상태</th>
            </tr>
          </thead>
          <tbody>
            <tr :key="idx" v-for="(item, idx) in resList">
              <td class="w3-center">
                <input type="checkbox" id="select" v-model="item.selected" />
              </td>
              <td class="w3-center">{{ idx + 1 }}</td>
              <td class="w3-center detail" @click="saveSelectedItem(item)">
                {{ item.resId }}
              </td>
              <td class="w3-center">{{ item.userName }}</td>
              <td class="w3-center">{{ item.resCheckin.split("T")[0] }}</td>
              <td class="w3-center">{{ item.resCheckout.split("T")[0] }}</td>
              <td class="w3-center">{{ item.resDate.split("T")[0] }}</td>
              <td class="w3-center">
                {{ item.payCheck === 1 ? "예약" : "취소" }}
              </td>
            </tr>
          </tbody>
        </table>
      </div>
      <!-- Pagination -->
      <div class="w3-bar pagin">
        <a href="#" class="w3-button w3-hover-purple circle">«</a>
        <a href="#" class="w3-button w3-hover-green">1</a>
        <a href="#" class="w3-button w3-hover-red">2</a>
        <a href="#" class="w3-button w3-hover-blue">3</a>
        <a href="#" class="w3-button w3-hover-black">4</a>
        <a href="#" class="w3-button w3-hover-orange circle">»</a>
      </div>
      <!-- SearchBar -->
    </div>
  </div>
</template>

<script>
import axios from "axios";
import { mapActions } from "vuex";
export default {
  data() {
    return {
      resList: [],
      selectedReservations: [],
      selectedIds: [],
    };
  },
  mounted() {
    this.getResList();
  },
  methods: {
    saveSelectedItem(item) {
      this.setSelectedResItem(item); // Vuex 액션 호출
      this.$router.push("/admin/reservation/detail");
    },
    ...mapActions(["setSelectedResItem"]),
    itemchange() {
      const selectedIds = this.getSelected(); // 선택된 예약의 ID 목록을 가져오기
      if (selectedIds.length === 0) {
        alert("아무것도 선택을 하지 않습니다.");
        return;
      }
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
    },
    getSelected() {
      // 선택한 라인의 아이디 가져오기
      let itemIdx = [];
      for (let i in this.resList) {
        if (this.resList[i].selected) {
          itemIdx.push(this.resList[i].resId);
        }
      }
      return itemIdx;
    },
    selectAllItems(checked) {
      this.allChecked = checked;
      for (let i in this.resList) {
        this.resList[i].selected = this.allChecked;
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
};
</script>

<style scoped>
.detail {
  cursor: pointer;
  font-weight: bold;
}
.detail:hover {
  color: #d4af37;
}
table th,
table td {
  font-size: 16px;
}
.board-container {
  max-width: 1200px;
  margin: 0 auto;
  padding-bottom: 100px;
}
.buttonWrite {
  background-color: #d4af37;
  color: white;
}
.page-header {
  margin: 0;
  font-size: 40px;
  font-weight: bold;
}
.page-header-container {
  text-align: center;
  margin-bottom: 80px;
}
.common-buttons {
  text-align: right;
  font-size: 14px;
  margin-bottom: 24px;
}
.common-buttons button {
  width: 140px;
  height: 40px;
  margin-left: 8px;
  color: rgb(136, 136, 136);
  border: 1px solid rgb(221, 221, 221);
}

.pagin {
  text-align: center;
  margin-top: 50px;
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
.searchBar {
  justify-content: center;
  display: flex;
  column-gap: 10px;
  height: 40px;
  font-size: 14px;
  margin-top: 50px;
  margin-bottom: 100px;
}
.inputButton {
  display: flex;
  column-gap: 10px;
}
.inputButton input {
  border: 1px solid rgb(221, 221, 221);
  font-size: 14px;
  padding: 0 8px;
  width: 250px;
}
.inputButton button {
  font-size: 14px;
  width: 80px;
  height: 40px;
  border: none;
  background-color: #d4af37;
  color: white;
}
.searchBar select {
  width: 120px;
  border: 1px solid rgb(221, 221, 221);
  padding: 0 30px 0px 15px;
  font-size: 14px;
  -webkit-appearance: none; /* for chrome */

  -moz-appearance: none; /*for firefox*/

  appearance: none;
  background-repeat: no-repeat;
  background-position: 90% center;
  background-size: 14px;
}
a {
  text-decoration: none;
}
</style>
