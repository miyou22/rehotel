<template>
  <!-- Top Text -->
  <div class="board-container">
    <div class="page-header-container">
      <h1 class="page-header">FAQ</h1>
    </div>
    <!-- Acodian -->
    <div
      id="accordions"
      v-for="item in 3"
      :key="item"
      :class="[`accor item${item}`, { 'w3-show': isOpen[item] }]"
    >
      <button
        class="w3-btn w3-block w3-white w3-left-align w3-padding-24 w3-border-top w3-border-bottom"
        @click="toggleAccordion(item)"
        id="accBtn"
        :class="{ opened: isOpen[item] }"
      >
        <span class="ico"
          ><img src="../../../assets/img/ico_q.png" />
          <span class="btnSpan"> Open Section 1</span></span
        >
        <span class="plus"></span>
      </button>
      <div
        id="panel"
        class="w3-container w3-border-bottom"
        v-show="isOpen[item]"
      >
        <h4>Section {{ item }}</h4>
        <p class="w3-margin-bottom">Some text..</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      // isOpen객체의 값은 빈값이다. 빈값은 false로 반환한다.
      isOpen: {},
    };
  },
  methods: {
    toggleAccordion(item) {
      // 아코디언 열림 상태를 토글
      this.isOpen[item] = !this.isOpen[item];
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
