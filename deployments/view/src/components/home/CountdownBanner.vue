<template>
  <div class="bgwhite pos-relative p-b-20per-ssm">
    <h1>특가 세일 상품</h1>
    <img
      src="https://image.msscdn.net/images/goods_img/20210325/1862704/1862704_1_500.jpg"
      alt="IMG-BANNER"
    />

    <div class="ab-t-l sizefull flex-col-c-b p-l-15 p-r-15 p-b-20">
      <div class="product">
        <a href="product-detail.html" class="dis-block s-text3 p-b-5">
          21SS MJS152A 055 사선 요크 심 반팔 티셔츠
        </a>
      </div>

      <div class="t-center">
        <span class="block2-oldprice m-text7 p-r-5">
          $850,000원
        </span>

        <span class="block2-newprice m-text8">
          $684,000원
        </span>
      </div>

      <div ref="countdown" class="flex-c-m p-t-44 p-t-30-xl">
        <div class="flex-col-c-m size3 bo1 m-l-5 m-r-5">
          <span class="m-text10 p-b-1 days">
            7
          </span>

          <span class="s-text5">
            days
          </span>
        </div>

        <div class="flex-col-c-m size3 bo1 m-l-5 m-r-5">
          <span class="m-text10 p-b-1 hours">
            04
          </span>

          <span class="s-text5">
            hrs
          </span>
        </div>

        <div class="flex-col-c-m size3 bo1 m-l-5 m-r-5">
          <span class="m-text10 p-b-1 minutes">
            32
          </span>

          <span class="s-text5">
            mins
          </span>
        </div>

        <div class="flex-col-c-m size3 bo1 m-l-5 m-r-5">
          <span class="m-text10 p-b-1 seconds">
            05
          </span>

          <span class="s-text5">
            secs
          </span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  mounted() {
    // public/vendor/countdowntime/countdowntime.js 파일에 구현.
    $(this.$refs.countdown).initializeClock(
      new Date(Date.parse(new Date()) + 7 * 24 * 60 * 60 * 1000 + 13 * 60 * 60 * 1000),
    );
  },
};
</script>

<style scoped>
h1 {
  text-align: center;
  margin-top: 0.67em;
  margin-bottom: 0.67em;
  margin-left: 0;
  margin-right: 0;
  font-weight: bold;
}
.product {
  display: block;
  text-align: center;
  margin-top: 0.67em;
  margin-bottom: 0.67em;
  margin-left: 0;
  margin-right: 0;
  font-weight: bold;
}

img {
  display: inline;
  text-align: center;
  margin-left: auto;
  margin-right: auto;
}
</style>
