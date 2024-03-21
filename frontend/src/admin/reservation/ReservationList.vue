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
             @click="cancelSelectedReservations"
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
                  @change="selectAllItems"
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
            <tr :key='idx' v-for='(item, idx) in resList'>
              <td class="w3-center">
                <input type="checkbox" id="select" v-model="item.selected" />
              </td>
              <td class="w3-center">{{ idx+1 }}</td>
              <td class="w3-center">{{ item.resId }}</td>
              <td class="w3-center">{{ item.userName }}</td>
              <td class="w3-center">{{ item.resCheckin.split('T')[0] }}</td>
              <td class="w3-center">{{ item.resCheckout.split('T')[0] }}</td>
              <td class="w3-center">{{ item.resDate.split('T')[0] }}</td>
              <td class="w3-center">{{item.payCheck === 1 ? '예약' : '취소'}}</td>
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
import axios from 'axios';
import Swal from 'sweetalert2'

export default {
 data() {
    return {
      resList: [],
      selectedReservations: [],
    }
  },
   mounted() {
      this.getResList()
    },
  methods: {
  selectItem(item) {
    if (item.selected) {
      this.selectedReservations.push(item.resId);
    } else {
      const index = this.selectedReservations.indexOf(item.resId);
      if (index !== -1) {
        this.selectedReservations.splice(index, 1);
      }
    }
  },
      cancelSelectedReservations() {
          if (this.selectedReservations.length === 0) {
            Swal.fire({
              icon: 'warning',
              title: '취소할 예약을 선택하세요.',
              showConfirmButton: false,
              timer: 1500
            });
            return;
          }

          Swal.fire({
            title: '선택한 예약을 취소하시겠습니까?',
            text: '취소 후에는 복구할 수 없습니다.',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#d33',
            cancelButtonColor: '#3085d6',
            confirmButtonText: '취소',
            cancelButtonText: '취소 안 함'
          }).then((result) => {
            if (result.isConfirmed) {
              axios.post('http://localhost:8081/api/reservation/cancel', this.selectedReservations)
                .then(response => {
                  Swal.fire({
                    icon: 'success',
                    title: '취소되었습니다.',
                    showConfirmButton: false,
                    timer: 1500
                  });
                  // 선택 해제
                  this.selectedReservations = [];
                  // 예약목록 다시 불러오기
                  this.getResList();
                })
                .catch(error => {
                  console.error('예약 취소 중 오류가 발생했습니다:', error);
                  Swal.fire({
                    icon: 'error',
                    title: '취소 중 오류가 발생했습니다.',
                    showConfirmButton: false,
                    timer: 1500
                  });
                });
            }
          });
        },
   selectAllItems() {
     const firstBox = document.querySelector('input[id="selectAll"]');
     this.resList.forEach(item => {
       item.selected = firstBox.checked;
       this.selectItem(item);
     });
   },
     getResList() {
              // alert("getresList 시작.....")
              this.$axios
                .get('http://localhost:8081/api/reservation/resInfo')
                .then((res) => {
                  this.resList = res.data
                  // alert('getData() 수신데이터 ==> ' + res.data)
                  console.log(res.data)
                })
                .catch((error) => {
                  console.log(error)
                })
                .finally(() => {
                  console.log('항상 마지막에 실행')
                })
        },
  },
};
</script>

<style scoped>
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
