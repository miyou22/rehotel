<template>
  <!-- Top Text -->
  <div class="board-container">
    <div class="page-header-container">
      <h1 class="page-header">FAQ</h1>
    </div>
    <!-- Acodian -->
    <div
      id="accordions"
      v-for="(item, idx) in faqList"
      :key="idx"
      :class="[`accor item${idx}`, { 'w3-show': isOpen[idx] }]"
    >
      <button
        class="w3-btn w3-block w3-white w3-left-align w3-padding-24 w3-border-top w3-border-bottom"
        @click="toggleAccordion(idx)"
        id="accBtn"
        :class="{ opened: isOpen[idx] }"
      >
        <span class="ico"
          ><img src="../../../assets/img/ico_q.png" />
          <span class="btnSpan">{{ item.boardTitle }}</span></span
        >
        <span class="plus"></span>
      </button>
      <div
        id="panel"
        class="w3-container w3-border-bottom"
        v-show="isOpen[idx]"
      >
        <!-- <h4>Section {{ item }}</h4> -->
        <p class="w3-margin-bottom">{{ item.boardContent }}</p>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
const url = "http://localhost:3081";

export default {
  data() {
    return {
      // isOpen객체의 값은 빈값이다. 빈값은 false로 반환한다.
      isOpen: {},
      faqList: [],
    };
  },
  created() {
    this.getFaqList();
  },
  methods: {
    toggleAccordion(idx) {
      // 아코디언 열림 상태를 토글
      this.isOpen[idx] = !this.isOpen[idx];
    },
    getFaqList() {
      this.$axios
        .get("http://localhost:8081/api/faq")
        .then((res) => {
          this.faqList = res.data;
          alert("faqList 수신데이터 => " + res.data);
          console.log(res.data);
        })
        .catch((error) => {
          console.log(error);
        })
        .finally(() => {
          console.log("마지막 실행");
        });
    },
  },
};
</script>

<style scoped>
.board-container {
  max-width: 1200px;
  margin: 0 auto;
}
.page-header {
  margin: 0;
  font-size: 40px;
  font-weight: bold;
}
.page-header-container {
  text-align: center;
}
#accBtn {
  display: flex;
  align-items: center;
  justify-content: space-between;
}
.btnSpan {
  padding: 10px;
  line-height: 1;
}
.plus {
  display: flex;
  align-items: center;
  justify-content: center;
  width: 50px;
  height: 50px;
  background-color: #525252;
}

.plus:before,
.plus:after {
  content: "";
  position: absolute;
  background: #fff;
  border-radius: 3px;
  transition: all 200ms ease-in-out;
}
.plus:before {
  width: 16px;
  height: 2px;
}
.plus:after {
  width: 2px;
  height: 16px;
}

#accBtn.opened .plus:after {
  transform: rotate(90deg);
}
#panel {
  /* transition: max-height 0.2s ease-out;
  padding: 0 18px; */
}
</style>
