<template>
  <section class="banner bgwhite p-t-40 p-b-40">
    <div class="container">
      <div class="sec-title p-b-60">
        <h3 class="m-text5 t-center">
          Best Product List (상품랭킹)
        </h3>
      </div>
      <div class="row">
        <div class="col-sm-10 col-md-8 col-lg-4 m-l-r-auto">
          <template v-for="product in firstColumn">
            <!-- block1 -->
            <div :key="product" class="block1 hov-img-zoom pos-relative m-b-30">
              <img :src="product.image" alt="IMG-BENNER" />

              <div class="block1-wrapbtn w-size2">
                <!-- Button -->
                <router-link to="/" class="flex-c-m size2 m-text2 bg3 hov1 trans-0-4">
                  {{ product.linkText }}
                </router-link>
              </div>
            </div>
          </template>
        </div>

        <div class="col-sm-10 col-md-8 col-lg-4 m-l-r-auto">
          <template v-for="product in secondColumn">
            <!-- block1 -->
            <div :key="product" class="block1 hov-img-zoom pos-relative m-b-30">
              <img :src="product.image" alt="IMG-BENNER" />

              <div class="block1-wrapbtn w-size2">
                <!-- Button -->
                <router-link to="/" class="flex-c-m size2 m-text2 bg3 hov1 trans-0-4">
                  {{ product.linkText }}
                </router-link>
              </div>
            </div>
          </template>
        </div>

        <div class="col-sm-10 col-md-8 col-lg-4 m-l-r-auto">
          <template v-for="product in thirdColumn">
            <!-- block1 -->
            <div :key="product" class="block1 hov-img-zoom pos-relative m-b-30">
              <img :src="product.image" alt="IMG-BENNER" />

              <div class="block1-wrapbtn w-size2">
                <!-- Button -->
                <router-link to="/" class="flex-c-m size2 m-text2 bg3 hov1 trans-0-4">
                  {{ product.linkText }}
                </router-link>
              </div>
            </div>
          </template>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import { mapState } from 'vuex';

export default {
  computed: {
    ...mapState('product', {
      products: state => state.bestProducts,
    }),
    firstColumn() {
      if (this.products.length >= 2) {
        return this.products.slice(0, 2);
      }

      return [];
    },
    secondColumn() {
      if (this.products.length >= 4) {
        return this.products.slice(2, 4);
      }

      return [];
    },
    thirdColumn() {
      // if (this.products.length >= 5) {
      //   return this.products[4];
      // }
      if (this.products.length >= 6) {
        return this.products.slice(4, 6);
      }

      return [];
    },
  },
  created() {
    this.$store.dispatch('product/setBestProducts');
  },
};
</script>
