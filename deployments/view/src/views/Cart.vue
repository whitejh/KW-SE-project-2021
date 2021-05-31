<template>
  <div>
    <section
      class="bg-title-page p-t-40 p-b-50 flex-col-c-m"
      style="background-image: url(https://picsum.photos/1920/239/?image=864);"
    >
      <h2 class="l-text2 t-center">
        구매자의 장바구니 (상품 구매)
      </h2>
    </section>

    <section class="cart bgwhite p-t-70 p-b-100">
      <div class="container">
        <!-- CartList from '@/components/features/CartList.vue';-->
        <CartList />

        <div class="flex-w flex-sb-m p-t-25 p-b-25 bo8 p-l-35 p-r-60 p-lr-15-sm">
          <div class="flex-w flex-m w-full-sm"></div>

          <div class="size10 trans-0-4 m-t-10 m-b-10">
            <!-- Button -->
            <button class="flex-c-m sizefull bg1 bo-rad-23 hov1 s-text1 trans-0-4" @click="addList">
              구매하기
            </button>
          </div>

          <div class="size10 trans-0-4 m-t-10 m-b-10">
            <!-- Button -->
            <button
              class="flex-c-m sizefull bg1 bo-rad-23 hov1 s-text1 trans-0-4"
              @click="clearCart"
            >
              장바구니 비우기
            </button>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import CartList from '@/components/features/CartList.vue';

export default {
  components: {
    CartList,
  },
  methods: {
    clearCart() {
      this.$store.dispatch('cart/clearCart');
    },
    addList() {
      this.$store.dispatch('cart/addList');
    },
  },
};
</script>

<style scoped></style>
