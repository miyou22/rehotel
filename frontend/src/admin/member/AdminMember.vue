<template>
  <!-- Top Text -->
  <div class="board-container">
    <div class="page-header-container">
      <h1 class="page-header">전체회원관리</h1>
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
            @click="MemDelete"
          >
            선택회원 삭제
          </button>
        </div>
        <table class="w3-table w3-bordered w3-hoverable w3-margin-bottom">
          <colgroup>
            <col width="80px" />
            <col width="100px" />
            <col width="200px" />
            <col width="200px" />
            <col width="auto" />
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
              <th class="w3-center">회원ID</th>
              <th class="w3-center">회원이름</th>
              <th class="w3-center">가입일</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(item, idx) in paginatedResList" :key="idx">
              <td class="w3-center">
                <input type="checkbox" id="select" v-model="item.selected" />
              </td>
              <td class="w3-center">{{ getNumber(idx) }}</td>
              <td class="w3-center detail" @click="saveSelectedItems(item)">
                {{ item.userId }}
              </td>
              <td class="w3-center">{{ item.userName }}</td>
              <td class="w3-center">
                {{ item.userJoin.split("T")[0] }}
              </td>
            </tr>
          </tbody>
        </table>
      </div>
      <!-- Pagination -->
      <div class="w3-bar pagin">
        <a
          href="#"
          class="w3-button w3-hover-white w3-hover-text-amber"
          @click="prevPage"
          >&laquo;</a
        >
        <a
          v-for="page in pageCount"
          :key="page"
          href="#"
          class="w3-button"
          :class="{
            'w3-text-black  w3-white w3-border w3-hover-white hofont':
              page === currentPage,
            'w3-text-black  w3-white w3-hover-white w3-hover-text-amber nofont':
              page !== currentPage,
          }"
          @click="changePage(page)"
          >{{ page }}</a
        >
        <a
          href="#"
          class="w3-button w3-hover-white w3-hover-text-amber w3-center"
          @click="nextPage"
          >&raquo;</a
        >
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import { mapActions } from "vuex";
export default {
  data() {
    return {
      memList: [],
      itemsPerPage: 10,
      currentPage: 1,
    };
  },
  computed: {
    pageCount() {
      return Math.ceil(this.memList.length / this.itemsPerPage);
    },
    paginatedResList() {
      const startIndex = (this.currentPage - 1) * this.itemsPerPage;
      const endIndex = startIndex + this.itemsPerPage;
      return this.memList.slice(startIndex, endIndex);
    },
    // selectedIds() {
    //   return this.getSelected().join(", "); // 선택된 회원의 ID를 쉼표로 구분하여 문자열로 반환
    // },
  },
  methods: {
    saveSelectedItems(item) {
      this.setSelectedMemItems(item); // Vuex 액션 호출
      this.$router.push("/admin/member/detail");
    },
    ...mapActions(["setSelectedMemItems"]),
    changePage(page) {
      this.currentPage = page;
    },
    nextPage() {
      if (this.currentPage < this.pageCount) {
        this.currentPage++;
      }
    },
    prevPage() {
      if (this.currentPage > 1) {
        this.currentPage--;
      }
    },
    getNumber(index) {
      const reversedIndex =
        this.memList.length -
        (index + (this.currentPage - 1) * this.itemsPerPage);
      return reversedIndex;
    },

    selectAllItems(checked) {
      this.allChecked = checked;
      for (let i in this.memList) {
        this.memList[i].selected = this.allChecked;
      }
    },
    getSelected() {
      // 선택한 인풋의 아이디 가져오기
      return this.memList
        .filter((item) => item.selected)
        .map((item) => item.userId);
    },
    getMemList() {
      // alert("getresList 시작.....")
      this.$axios
        .get("http://localhost:8081/api/member/memInfo")
        .then((res) => {
          this.memList = res.data.filter((item) => item.role === "USER");
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
    MemDelete() {
      const selectedIds = this.getSelected(); // 선택된 회원의 ID 목록을 가져오기
      if (selectedIds.length === 0) {
        alert("아무것도 선택을 하지 않습니다.");
        return;
      }
      axios
        .post("http://localhost:8081/api/member/deleteMember", selectedIds)

        .then((response) => {
          if (response.status === 200) {
            alert("선택된 회원의 정보가 삭제되었습니다.");
            // 변경된 상태를 다시 불러옵니다.
            this.getMemList();
          } else {
            alert("회원 삭제에 실패했습니다.");
          }
        })
        .catch((error) => {
          console.error("회원 삭제에 실패했습니다.", error);
        });
    },
  },
  mounted() {
    this.getMemList();
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
.hofont {
  font-weight: 500;
}
.nofont {
  font-weight: 300;
}
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
  margin-top: 85px;
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
